package org.mlaptev.otus.currencies;

import java.util.Map;
import org.mlaptev.otus.exceptions.AtmException;

public class UsdRepresentation extends CurrencyRepresentation {

  private Banknote topBanknote = new UsdBanknote(100);

  public UsdRepresentation() {
    // Building chain
    Banknote usd50 = new UsdBanknote(50);
    topBanknote.setLowerNominationBanknote(usd50);

    Banknote usd20 = new UsdBanknote(20);
    usd50.setLowerNominationBanknote(usd20);

    Banknote usd10 = new UsdBanknote(10);
    usd20.setLowerNominationBanknote(usd10);

    Banknote usd5 = new UsdBanknote(5);
    usd10.setLowerNominationBanknote(usd5);

    Banknote usd2 = new UsdBanknote(2);
    usd5.setLowerNominationBanknote(usd2);

    Banknote usd1 = new UsdBanknote(1);
    usd2.setLowerNominationBanknote(usd1);
  }

  @Override
  public Banknote getTopBanknote() {
    return topBanknote;
  }

  private static class UsdBanknote extends Banknote {

    UsdBanknote(int nomination) {
      super(nomination);
    }
  }
}