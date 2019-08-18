package org.mlaptev.otus.atm;

import java.util.Map;
import org.mlaptev.otus.currencies.CurrencyType;
import org.mlaptev.otus.exceptions.AtmException;

public interface Atm {

  Map<Integer, Integer> withdraw(CurrencyType type, int amount) throws AtmException;

  void resetWithdrawTypeToDefault();

  AtmMemento save();

  void undo(Object obj) throws AtmException;
}
