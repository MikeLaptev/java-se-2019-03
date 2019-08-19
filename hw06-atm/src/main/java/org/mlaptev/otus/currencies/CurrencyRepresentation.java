package org.mlaptev.otus.currencies;

import java.util.Map;
import org.mlaptev.otus.atm.operations.withdraw.Withdraw;
import org.mlaptev.otus.exceptions.AtmException;

public abstract class CurrencyRepresentation {

  public abstract Banknote getTopBanknote();

  public Map<Integer, Integer> withdraw(Withdraw type, int amount) throws AtmException {
    return type.execute(amount);
  }

  public void uploadBanknotes(Map<Integer, Integer> cassette) throws AtmException {
    getTopBanknote().refillBanknoteFromCassette(cassette);
  }

  public Map<Integer, Integer> getCurrencyState() {
    return getTopBanknote().getBanknoteState();
  }

  public void setCurrencyState(Map<Integer, Integer> state) throws AtmException {
    getTopBanknote().updateBanknoteState(state);
  }
}
