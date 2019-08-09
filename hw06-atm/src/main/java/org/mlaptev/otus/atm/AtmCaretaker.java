package org.mlaptev.otus.atm;

import org.mlaptev.otus.exceptions.AtmException;

public class AtmCaretaker {

  private Object obj;

  public void save(Atm atm) {
    this.obj = atm.save();
  }

  public void undo(Atm atm) throws AtmException {
    atm.undo(this.obj);
  }
}