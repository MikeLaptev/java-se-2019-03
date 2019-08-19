package org.mlaptev.otus.currencies;

public class RubRepresentation extends CurrencyRepresentation {

  private Banknote topBanknote = new RubBanknote(5000);

  public RubRepresentation() {
    // Build chain
    Banknote rub2000 = new RubBanknote(2000);
    topBanknote.setLowerNominationBanknote(rub2000);

    Banknote rub1000 = new RubBanknote(1000);
    rub2000.setLowerNominationBanknote(rub1000);

    Banknote rub500 = new RubBanknote(500);
    rub1000.setLowerNominationBanknote(rub500);

    Banknote rub100 = new RubBanknote(100);
    rub500.setLowerNominationBanknote(rub100);

    Banknote rub50 = new RubBanknote(50);
    rub100.setLowerNominationBanknote(rub50);

    Banknote rub10 = new RubBanknote(10);
    rub50.setLowerNominationBanknote(rub10);
  }

  @Override
  public Banknote getTopBanknote() {
    return topBanknote;
  }

  private static class RubBanknote extends Banknote {

    RubBanknote(int nomination) {
      super(nomination);
    }
  }
}
