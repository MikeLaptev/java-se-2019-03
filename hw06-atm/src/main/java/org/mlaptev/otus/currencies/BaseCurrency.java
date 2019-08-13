package org.mlaptev.otus.currencies;

import java.util.Map;
import org.mlaptev.otus.exceptions.AtmException;

public interface BaseCurrency {

  Map<Integer, Integer> withdraw(int amount) throws AtmException;

  void uploadBanknotes(Map<Integer, Integer> cassette) throws AtmException;

  Map<Integer, Integer> getCurrencyState();

  void setCurrencyState(Map<Integer, Integer> state) throws AtmException;
}
