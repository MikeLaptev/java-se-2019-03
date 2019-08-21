package org.mlaptev.otus.currencies;

public enum CurrencyType {
  USD(UsdRepresentation.class),
  EURO(EurRepresentation.class),
  GBP(GbpRepresentation.class),
  RUBLE(RubRepresentation.class);

  private Class currency;

  CurrencyType(Class currency) {
    this.currency = currency;
  }

  public Class getCurrency() {
    return currency;
  }
}
