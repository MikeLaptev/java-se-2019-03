package org.mlaptev.otus.atm;

import com.google.common.reflect.TypeToken;
import com.google.common.reflect.TypeToken.TypeSet;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mlaptev.otus.atm.operations.MinimumAmountOfBanknotes;
import org.mlaptev.otus.atm.operations.Withdraw;
import org.mlaptev.otus.currencies.Banknote;
import org.mlaptev.otus.currencies.CurrencyRepresentation;
import org.mlaptev.otus.currencies.CurrencyType;
import org.mlaptev.otus.exceptions.AtmException;
import org.mlaptev.otus.exceptions.CannotWithdrawException;
import org.mlaptev.otus.exceptions.CurrencyNotSupportedException;
import org.mlaptev.otus.exceptions.InvalidBanknoteNominationException;
import org.mlaptev.otus.exceptions.InvalidCassetteStateException;
import org.mlaptev.otus.exceptions.InvalidWithdrawApproachException;

public class AtmWithMultipleCurrencies implements Atm {

  private static final Logger logger = LogManager.getLogger(AtmWithMultipleCurrencies.class);

  private Map<CurrencyType, CurrencyRepresentation> acceptedCurrencies = new HashMap<>();
  private Class withdrawType = MinimumAmountOfBanknotes.class;

  public void addSupportOfCurrencyType(CurrencyType type) throws Exception {
    logger.info("Adding support of currency {}", type.name());
    acceptedCurrencies.put(type, (CurrencyRepresentation) type.getCurrency().getConstructor().newInstance());
  }

  public boolean isCurrencySupported(CurrencyType type) {
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

  private Withdraw getDefinedWithdrawApproach(Banknote banknote)
      throws InvalidWithdrawApproachException {
    try {
      Constructor constructor = withdrawType.getDeclaredConstructor(Banknote.class);
      constructor.setAccessible(true);
      return (Withdraw) constructor.newInstance(banknote);
    } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
      throw new InvalidWithdrawApproachException(
          String.format("Cannot apply current approach %s for banknote %s",
              withdrawType.getName(), banknote.getClass()), e);
    }
  }

  @Override
  public void setCustomWithdrawType(Class clazz) throws AtmException {
    final TypeSet interfaces = TypeToken.of(clazz).getTypes().interfaces();

    if (interfaces.contains(Withdraw.class)) {
      withdrawType = clazz;
    } else {
      throw new InvalidWithdrawApproachException(
          String.format(
              "Cannot use %s as a withdraw provider. It should implement the %s interface",
              clazz.getName(), interfaces));
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

  @Override
  public AtmMomento save() {
    return new AtmMomento(acceptedCurrencies);
  }

  @Override
  public void undo(Object obj) throws AtmException {
    Map<CurrencyType, Map<Integer, Integer>> state = ((AtmMomento) obj).getState();
    for (CurrencyType type : acceptedCurrencies.keySet()) {
      acceptedCurrencies.get(type).setCurrencyState(state.getOrDefault(type, new HashMap<>()));
    }
  }
}
