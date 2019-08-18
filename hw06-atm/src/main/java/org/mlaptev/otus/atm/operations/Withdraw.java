package org.mlaptev.otus.atm.operations;

import java.util.Map;
import org.mlaptev.otus.currencies.Banknote;
import org.mlaptev.otus.exceptions.AtmException;

/**
 * Implementation of Command pattern
 */
public interface Withdraw {

  void setBanknote(Banknote banknote);

  Map<Integer, Integer> execute(int amount) throws AtmException;
}
