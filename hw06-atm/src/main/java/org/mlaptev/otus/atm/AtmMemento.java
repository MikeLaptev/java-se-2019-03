package org.mlaptev.otus.atm;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.Getter;
import org.mlaptev.otus.atm.operations.Withdraw;
import org.mlaptev.otus.currencies.CurrencyRepresentation;
import org.mlaptev.otus.currencies.CurrencyType;

@Getter
class AtmMemento {

  private Map<CurrencyType, Map<Integer, Integer>> state = new HashMap<>();
  private Withdraw withdraw;
  private UUID uuid;

  AtmMemento(Map<CurrencyType, CurrencyRepresentation> currencies, Withdraw withdraw, UUID uuid) {
    state.putAll(currencies.entrySet()
        .stream()
        .collect(Collectors.toMap(Entry::getKey, x -> x.getValue().getCurrencyState())));
    this.withdraw = withdraw;
    this.uuid = uuid;
  }
}