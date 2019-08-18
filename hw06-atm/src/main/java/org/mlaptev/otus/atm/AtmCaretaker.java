package org.mlaptev.otus.atm;

import org.mlaptev.otus.exceptions.AtmException;

class AtmCaretaker {

  private AtmMemento memento;

  void save(Atm atm) {
    this.memento = atm.save();
  }

  void undo(Atm atm) throws AtmException {
    atm.undo(this.memento);
  }
}