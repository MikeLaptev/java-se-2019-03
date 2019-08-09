package org.mlaptev.otus.atm;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mlaptev.otus.currencies.BaseCurrency;
import org.mlaptev.otus.currencies.CurrencyType;
import org.mlaptev.otus.exceptions.AtmException;
import org.mlaptev.otus.exceptions.CannotWithdrawException;
import org.mlaptev.otus.exceptions.CurrencyNotSupportedException;
import org.mlaptev.otus.exceptions.InvalidBanknoteNominationException;
import org.mlaptev.otus.exceptions.InvalidCassetteStateException;

public class Atm {

  private static final Logger logger = LogManager.getLogger(Atm.class);

  private Map<CurrencyType, BaseCurrency> acceptedCurrencies = new HashMap<>();

  public void addSupportOfCurrencyType(CurrencyType type) throws Exception {
    logger.info("Adding support of currency {}", type.name());
    acceptedCurrencies.put(type, (BaseCurrency) type.getCurrency().getConstructor().newInstance());
  }

  public boolean isCurrencySupported(CurrencyType type) {
    return acceptedCurrencies.containsKey(type);
  }

  public Map<Integer, Integer> withdraw(CurrencyType type, int amount) throws AtmException {
    if (!isCurrencySupported(type)) {
      throw new CurrencyNotSupportedException(
          String.format("Currency %s is not supported by ATM", type.name()));
    }

    AtmCaretaker caretaker = new AtmCaretaker();
    try {
      caretaker.save(this);
      return acceptedCurrencies.get(type).withdraw(amount);
    } catch (CannotWithdrawException e) {
      caretaker.undo(this);
      throw e;
    }
  }

  public void loadCassette(CurrencyType type, Map<Integer, Integer> cassette) throws AtmException {
    if (!isCurrencySupported(type)) {
      throw new CurrencyNotSupportedException(
          String.format("Currency %s is not supported by ATM", type.name()));
    }

    AtmCaretaker caretaker = new AtmCaretaker();
    try {
      caretaker.save(this);
      acceptedCurrencies.get(type).uploadBanknotes(cassette);
    } catch (InvalidBanknoteNominationException | InvalidCassetteStateException e) {
      caretaker.undo(this);
      throw e;
    }
  }

  public AtmMomento save() {
    return new AtmMomento(acceptedCurrencies);
  }

  public void undo(Object obj) throws AtmException {
    Map<CurrencyType, Map<Integer, Integer>> state = ((AtmMomento) obj).getState();
    for (CurrencyType type : acceptedCurrencies.keySet()) {
      acceptedCurrencies.get(type).setCurrencyState(state.getOrDefault(type, new HashMap<>()));
    }
  }

  private class AtmMomento {

    private Map<CurrencyType, Map<Integer, Integer>> state = new HashMap<>();

    public AtmMomento(Map<CurrencyType, BaseCurrency> currencies) {
      state.putAll(currencies.entrySet()
          .stream()
          .collect(Collectors.toMap(Entry::getKey, x -> x.getValue().getCurrencyState())));
    }

    public Map<CurrencyType, Map<Integer, Integer>> getState() {
      return state;
    }
  }
}
