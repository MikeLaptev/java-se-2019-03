package org.mlaptev.otus.atmdepartment;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mlaptev.otus.atm.Atm;
import org.mlaptev.otus.atm.AtmMemento;
import org.mlaptev.otus.currencies.CurrencyType;
import org.mlaptev.otus.exceptions.AtmException;

public class SimpleAtmDepartment implements AtmDepartment {

  private static final Logger logger = LogManager.getLogger(SimpleAtmDepartment.class);

  @Getter
  private Map<UUID, Atm> atms = new HashMap<>();

  private Map<UUID, AtmMemento> initialStates = new HashMap<>();

  @Override
  public void addAtms(Atm... atmsToAdd) {
    for (Atm atmToAdd : atmsToAdd) {
      if (atms.containsKey(atmToAdd.getUuid())) {
        logger.error("Cannot add atm [{}]. It is already presented in the system.", atmToAdd);
      } else {
        atms.put(atmToAdd.getUuid(), atmToAdd);
        initialStates.put(atmToAdd.getUuid(), atmToAdd.save());
      }
    }
  }

  @Override
  public Map<CurrencyType, Long> getSumOfReminders() {
    return Map.of();
  }

  @Override
  public void resetConditionsOfAllTheAtms() throws AtmException {
    for (Map.Entry<UUID, Atm> atm : atms.entrySet()) {
      atm.getValue().undo(initialStates.get(atm.getKey()));
    }
  }
}
