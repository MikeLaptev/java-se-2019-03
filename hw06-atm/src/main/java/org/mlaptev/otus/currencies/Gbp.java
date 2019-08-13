package org.mlaptev.otus.currencies;

import java.util.Map;
import org.mlaptev.otus.exceptions.AtmException;

public class Gbp implements BaseCurrency {

  private Gbp100Banknote gbp100 = new Gbp100Banknote();
  private Gbp50Banknote gbp50 = new Gbp50Banknote();
  private Gbp20Banknote gbp20 = new Gbp20Banknote();
  private Gbp10Banknote gbp10 = new Gbp10Banknote();
  private Gbp5Banknote gbp5 = new Gbp5Banknote();

  public Gbp() {
    // Build chain
    gbp100.setLowerNominationBanknote(gbp50);
    gbp50.setLowerNominationBanknote(gbp20);
    gbp20.setLowerNominationBanknote(gbp10);
    gbp10.setLowerNominationBanknote(gbp5);
  }

  @Override
  public Map<Integer, Integer> withdraw(int amount) throws AtmException {
    return gbp100.withdraw(amount);
  }

  @Override
  public void uploadBanknotes(Map<Integer, Integer> cassette) throws AtmException {
    gbp100.refillBanknoteFromCassette(cassette);
  }

  @Override
  public Map<Integer, Integer> getCurrencyState() {
    return gbp100.getBanknoteState();
  }

  @Override
  public void setCurrencyState(Map<Integer, Integer> state) throws AtmException {
    gbp100.updateBanknoteState(state);
  }

  private class Gbp100Banknote extends Banknote {

    Gbp100Banknote() {
      nomination = 100;
    }
  }

  private class Gbp50Banknote extends Banknote {

    Gbp50Banknote() {
      nomination = 50;
    }
  }

  private class Gbp20Banknote extends Banknote {

    Gbp20Banknote() {
      nomination = 20;
    }
  }

  private class Gbp10Banknote extends Banknote {

    Gbp10Banknote() {
      nomination = 10;
    }
  }

  private class Gbp5Banknote extends Banknote {

    Gbp5Banknote() {
      nomination = 5;
    }
  }
}
