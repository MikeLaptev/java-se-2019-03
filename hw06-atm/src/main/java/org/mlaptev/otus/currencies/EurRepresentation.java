package org.mlaptev.otus.currencies;

import java.util.Map;
import lombok.Getter;
import org.mlaptev.otus.atm.operations.Withdraw;
import org.mlaptev.otus.exceptions.AtmException;

public class EurRepresentation extends CurrencyRepresentation {

  private Banknote topBanknote = new EurBanknote(500);

  public EurRepresentation() {
    // Build chain
    Banknote eur200 = new EurBanknote(200);
    topBanknote.setLowerNominationBanknote(eur200);

    Banknote eur100 = new EurBanknote(100);
    eur200.setLowerNominationBanknote(eur100);

    Banknote eur50 = new EurBanknote(50);
    eur100.setLowerNominationBanknote(eur50);

    Banknote eur20 = new EurBanknote(20);
    eur50.setLowerNominationBanknote(eur20);

    Banknote eur10 = new EurBanknote(10);
    eur20.setLowerNominationBanknote(eur10);

    Banknote eur5 = new EurBanknote(5);
    eur10.setLowerNominationBanknote(eur5);
  }

  @Override
  public Banknote getTopBanknote() {
    return topBanknote;
  }

  @Override
  public Map<Integer, Integer> withdraw(Withdraw type, int amount) throws AtmException {
    return type.execute(amount);
  }

  private static class EurBanknote extends Banknote {

    EurBanknote(int nomination) {
      super(nomination);
    }
  }
}
