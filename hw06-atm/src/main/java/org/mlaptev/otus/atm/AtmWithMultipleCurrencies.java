package org.mlaptev.otus.atm;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mlaptev.otus.atm.operations.MinimumAmountOfBanknotes;
import org.mlaptev.otus.atm.operations.Withdraw;
import org.mlaptev.otus.currencies.Banknote;
import org.mlaptev.otus.currencies.CurrencyRepresentation;
import org.mlaptev.otus.currencies.CurrencyType;
import org.mlaptev.otus.exceptions.AtmException;
import org.mlaptev.otus.exceptions.CurrencyNotSupportedException;

public class AtmWithMultipleCurrencies implements Atm {

  private static final Logger logger = LogManager.getLogger(AtmWithMultipleCurrencies.class);

  private Map<CurrencyType, CurrencyRepresentation> acceptedCurrencies = new HashMap<>();

  @Setter
  private Withdraw withdrawApproach = new MinimumAmountOfBanknotes();

  private final UUID uuid = UUID.randomUUID();

  @Override
  public UUID getUuid() {
    return uuid;
  }

  public void addSupportOfCurrencyType(CurrencyType type) throws Exception {
    logger.info("Adding support of currency {}", type.name());
    acceptedCurrencies.put(type,
        (CurrencyRepresentation) type.getCurrency().getConstructor().newInstance());
  }

  private boolean isCurrencySupported(CurrencyType type) {
    return acceptedCurrencies.containsKey(type);
  }

  @Override
  public Map<Integer, Integer> withdraw(CurrencyType type, int amount) throws AtmException {
    if (!isCurrencySupported(type)) {
      throw new CurrencyNotSupportedException(
          String.format("Currency %s is not supported by ATM", type.name()));
    }

    AtmCaretaker caretaker = new AtmCaretaker();
    try {
      caretaker.save(this);
      Banknote topBanknote = acceptedCurrencies.get(type).getTopBanknote();
      return getDefinedWithdrawApproach(topBanknote).execute(amount);
    } catch (AtmException e) {
      caretaker.undo(this);
      throw e;
    }
  }

  private Withdraw getDefinedWithdrawApproach(Banknote banknote) {
    withdrawApproach.setBanknote(banknote);
    return withdrawApproach;
  }

  @Override
  public void resetWithdrawTypeToDefault() {
    withdrawApproach = new MinimumAmountOfBanknotes();
  }

  @Override
  public void loadCassette(CurrencyType type, Map<Integer, Integer> cassette) throws AtmException {
    if (!isCurrencySupported(type)) {
      throw new CurrencyNotSupportedException(
          String.format("Currency %s is not supported by ATM", type.name()));
    }

    AtmCaretaker caretaker = new AtmCaretaker();
    try {
      caretaker.save(this);
      acceptedCurrencies.get(type).uploadBanknotes(cassette);
    } catch (AtmException e) {
      caretaker.undo(this);
      throw e;
    }
  }

  @Override
  public AtmMemento save() {
    return new AtmMemento(acceptedCurrencies, withdrawApproach, uuid);
  }

  @Override
  public void undo(AtmMemento memento) throws AtmException {
    if (!memento.getUuid().equals(uuid)) {
      throw new AtmException("Cannot restore ATM from a snapshot that was not created from it.");
    }
    Map<CurrencyType, Map<Integer, Integer>> state = memento.getState();
    for (CurrencyType type : acceptedCurrencies.keySet()) {
      acceptedCurrencies.get(type).setCurrencyState(state.getOrDefault(type, new HashMap<>()));
    }
    withdrawApproach = memento.getWithdraw();
  }
}
