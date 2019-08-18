package org.mlaptev.otus.atm.operations;

import java.util.Map;
import org.mlaptev.otus.exceptions.AtmException;

public interface Withdraw {

  Map<Integer, Integer> execute(int amount) throws AtmException;
}
