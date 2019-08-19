package org.mlaptev.otus.atm;

import java.util.Map;
import java.util.UUID;
import org.mlaptev.otus.atm.operations.audit.Auditable;
import org.mlaptev.otus.currencies.CurrencyType;
import org.mlaptev.otus.exceptions.AtmException;

public interface Atm extends Auditable {

  UUID getUuid();

  void addSupportOfCurrencyType(CurrencyType type) throws Exception;

  Map<Integer, Integer> withdraw(CurrencyType type, int amount) throws AtmException;

  void resetWithdrawTypeToDefault();

  void loadCassette(CurrencyType type, Map<Integer, Integer> cassette) throws AtmException;

  AtmMemento save();

  void undo(AtmMemento memento) throws AtmException;
}
