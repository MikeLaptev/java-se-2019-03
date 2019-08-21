package org.mlaptev.otus.atm.operations.audit;

import java.util.Map;
import org.mlaptev.otus.currencies.CurrencyType;

public interface Auditable {

  Map<CurrencyType, Long> accept(Audit auditor);
}
