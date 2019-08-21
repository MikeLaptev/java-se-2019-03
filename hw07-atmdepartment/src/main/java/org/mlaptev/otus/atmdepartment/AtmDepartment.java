package org.mlaptev.otus.atmdepartment;

import java.util.Map;
import org.mlaptev.otus.atm.Atm;
import org.mlaptev.otus.atm.operations.audit.Audit;
import org.mlaptev.otus.currencies.CurrencyType;
import org.mlaptev.otus.exceptions.AtmException;

/**
 * 1) Department can contains more than one ATM.
 *
 * 2) Department can collect sum of reminders from all the ATMs.
 *
 * 3) Department can initialize an event - reset conditions of all the ATMs.
 */
public interface AtmDepartment extends Audit {

  /**
   * 1) Department can contains more than one ATM.
   */
  void addAtms(Atm... atmsToAdd);

  /**
   * 2) Department can collect sum of reminders from all the ATMs.
   */
  Map<CurrencyType, Long> getSumOfReminders();

  /**
   * 3) Department can initialize an event - reset conditions of all the ATMs.
   */
  void resetConditionsOfAllTheAtms() throws AtmException;
}
