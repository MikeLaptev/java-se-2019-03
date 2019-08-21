package org.mlaptev.otus.atm.operations.audit;

import java.util.Map;
import org.mlaptev.otus.currencies.CurrencyType;

public interface Audit {

  Map<CurrencyType, Long> audit(Map<CurrencyType, Map<Integer, Integer>> atmState);
}
