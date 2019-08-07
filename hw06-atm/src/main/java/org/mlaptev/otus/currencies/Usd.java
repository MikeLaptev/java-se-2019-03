package org.mlaptev.otus.currencies;

import java.util.Map;
import org.mlaptev.otus.exceptions.CannotWithdrawException;
import org.mlaptev.otus.exceptions.InvalidBanknoteNominationException;
import org.mlaptev.otus.exceptions.InvalidCassetteStateException;

public class Usd implements BaseCurrency {

  private Usd100Banknote usd100 = new Usd100Banknote();
  private Usd50Banknote usd50 = new Usd50Banknote();
  private Usd20Banknote usd20 = new Usd20Banknote();
  private Usd10Banknote usd10 = new Usd10Banknote();
  private Usd5Banknote usd5 = new Usd5Banknote();
  private Usd2Banknote usd2 = new Usd2Banknote();
  private Usd1Banknote usd1 = new Usd1Banknote();

  public Usd() {
    // Building chain
    usd100.setLowerNominationBanknote(usd50);
    usd50.setLowerNominationBanknote(usd20);
    usd20.setLowerNominationBanknote(usd10);
    usd10.setLowerNominationBanknote(usd5);
    usd5.setLowerNominationBanknote(usd2);
    usd2.setLowerNominationBanknote(usd1);
  }

  @Override
  public Map<Integer, Integer> withdraw(int amount) throws CannotWithdrawException {
    return usd100.withdraw(amount);
  }

  @Override
  public void uploadBanknotes(Map<Integer, Integer> cassette)
      throws InvalidBanknoteNominationException, InvalidCassetteStateException {
    usd100.refillBanknoteFromCassette(cassette);
  }

  @Override
  public Map<Integer, Integer> getCurrencyState() {
    return usd100.getBanknoteState();
  }

  @Override
  public void setCurrencyState(Map<Integer, Integer> state)
      throws InvalidCassetteStateException, InvalidBanknoteNominationException {
    usd100.updateBanknoteState(state);
  }

  private class Usd100Banknote extends Banknote {

    Usd100Banknote() {
      nomination = 100;
    }
  }

  private class Usd50Banknote extends Banknote {

    Usd50Banknote() {
      nomination = 50;
    }
  }

  private class Usd20Banknote extends Banknote {

    Usd20Banknote() {
      nomination = 20;
    }
  }

  private class Usd10Banknote extends Banknote {

    Usd10Banknote() {
      nomination = 10;
    }
  }

  private class Usd5Banknote extends Banknote {

    Usd5Banknote() {
      nomination = 5;
    }
  }

  private class Usd2Banknote extends Banknote {

    Usd2Banknote() {
      nomination = 2;
    }
  }

  private class Usd1Banknote extends Banknote {

    Usd1Banknote() {
      nomination = 1;
    }
  }
}