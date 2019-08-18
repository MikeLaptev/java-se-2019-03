package org.mlaptev.otus.atmdepartment;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mlaptev.otus.atm.Atm;
import org.mlaptev.otus.currencies.CurrencyType;

/**
 * 1) Department can contains more than one ATM.
 *
 * 2) Department can collect sum of reminders from all the ATMs.
 *
 * 3) Department can initialize an event - reset conditions of all the ATMs.
 */
public class AtmDepartment {

  private static final Logger logger = LogManager.getLogger(AtmDepartment.class);

  @Getter
  private Map<UUID, Atm> atms = new HashMap<>();

  public void addAtms(Atm... atmsToAdd) {
    for (Atm atmToAdd: atmsToAdd) {
      if (atms.containsKey(atmToAdd.getUuid())) {
        logger.error("Cannot add atm [{}]. It is already presented in the system.", atmToAdd);
      } else {
        atms.put(atmToAdd.getUuid(), atmToAdd);
      }
    }
  }

  public Map<CurrencyType, Long> getSumOfReminders() {
    return Map.of();
  }

  public void resetConditionsOfAllTheAtms() {

  }
}
