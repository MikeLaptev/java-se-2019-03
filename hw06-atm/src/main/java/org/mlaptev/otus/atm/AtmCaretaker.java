package org.mlaptev.otus.atm;

import org.mlaptev.otus.exceptions.AtmException;

class AtmCaretaker {

  private Object obj;

  void save(Atm atm) {
    this.obj = atm.save();
  }

  void undo(Atm atm) throws AtmException {
    atm.undo(this.obj);
  }
}