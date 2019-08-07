package org.mlaptev.otus.currencies;

public enum CurrencyType {
  USD(Usd.class),
  EURO(Eur.class),
  GBP(Gbp.class),
  RUBLE(Rub.class);

  private Class currency;

  CurrencyType(Class currency) {
    this.currency = currency;
  }

  public Class getCurrency() {
    return currency;
  }
}
