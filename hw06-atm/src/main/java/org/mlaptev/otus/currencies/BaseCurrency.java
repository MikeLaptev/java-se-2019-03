package org.mlaptev.otus.currencies;

import java.util.Map;
import org.mlaptev.otus.exceptions.CannotWithdrawException;
import org.mlaptev.otus.exceptions.InvalidBanknoteNominationException;
import org.mlaptev.otus.exceptions.InvalidCassetteStateException;

public interface BaseCurrency {

  Map<Integer, Integer> withdraw(int amount) throws CannotWithdrawException;

  void uploadBanknotes(Map<Integer, Integer> cassette)
      throws InvalidBanknoteNominationException, InvalidCassetteStateException;

  Map<Integer, Integer> getCurrencyState();

  void setCurrencyState(Map<Integer, Integer> state)
      throws InvalidCassetteStateException, InvalidBanknoteNominationException;
}
