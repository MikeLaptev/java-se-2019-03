package org.mlaptev.otus.atm;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.mlaptev.otus.currencies.BaseCurrency;
import org.mlaptev.otus.currencies.CurrencyType;

class AtmMomento {

  private Map<CurrencyType, Map<Integer, Integer>> state = new HashMap<>();

  AtmMomento(Map<CurrencyType, BaseCurrency> currencies) {
    state.putAll(currencies.entrySet()
        .stream()
        .collect(Collectors.toMap(Entry::getKey, x -> x.getValue().getCurrencyState())));
  }

  Map<CurrencyType, Map<Integer, Integer>> getState() {
    return state;
  }
}