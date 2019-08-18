package org.mlaptev.otus.currencies;

import java.util.Map;
import org.mlaptev.otus.exceptions.AtmException;

public class GbpRepresentation extends CurrencyRepresentation {

  private Banknote topBanknote = new GbpBanknote(100);

  public GbpRepresentation() {
    // Build chain
    Banknote gbp50 = new GbpBanknote(50);
    topBanknote.setLowerNominationBanknote(gbp50);

    Banknote gbp20 = new GbpBanknote(20);
    gbp50.setLowerNominationBanknote(gbp20);

    Banknote gbp10 = new GbpBanknote(10);
    gbp20.setLowerNominationBanknote(gbp10);

    Banknote gbp5 = new GbpBanknote(5);
    gbp10.setLowerNominationBanknote(gbp5);
  }

  @Override
  public Banknote getTopBanknote() {
    return topBanknote;
  }

  private static class GbpBanknote extends Banknote {

    GbpBanknote(int nomination) {
      super(nomination);
    }
  }
}
