package org.mlaptev.otus.atm;

import org.mlaptev.otus.exceptions.AtmException;

public interface Atm {

  AtmMomento save();

  void undo(Object obj) throws AtmException;
}
