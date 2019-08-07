package org.mlaptev.otus.atm;

import org.mlaptev.otus.exceptions.InvalidBanknoteNominationException;
import org.mlaptev.otus.exceptions.InvalidCassetteStateException;

public class AtmCaretaker {

  private Object obj;

  public void save(Atm atm) {
    this.obj = atm.save();
  }

  public void undo(Atm atm)
      throws InvalidCassetteStateException, InvalidBanknoteNominationException {
    atm.undo(this.obj);
  }
}