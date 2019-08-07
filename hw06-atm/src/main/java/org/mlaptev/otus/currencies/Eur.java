package org.mlaptev.otus.currencies;

import java.util.Map;
import org.mlaptev.otus.exceptions.CannotWithdrawException;
import org.mlaptev.otus.exceptions.InvalidBanknoteNominationException;
import org.mlaptev.otus.exceptions.InvalidCassetteStateException;

public class Eur implements BaseCurrency {

  private Eur500Banknote eur500 = new Eur500Banknote();
  private Eur200Banknote eur200 = new Eur200Banknote();
  private Eur100Banknote eur100 = new Eur100Banknote();
  private Eur50Banknote eur50 = new Eur50Banknote();
  private Eur20Banknote eur20 = new Eur20Banknote();
  private Eur10Banknote eur10 = new Eur10Banknote();
  private Eur5Banknote eur5 = new Eur5Banknote();

  public Eur() {
    // Build chain
    eur500.setLowerNominationBanknote(eur200);
    eur200.setLowerNominationBanknote(eur100);
    eur100.setLowerNominationBanknote(eur50);
    eur50.setLowerNominationBanknote(eur20);
    eur20.setLowerNominationBanknote(eur10);
    eur10.setLowerNominationBanknote(eur5);
  }

  @Override
  public Map<Integer, Integer> withdraw(int amount) throws CannotWithdrawException {
    return eur500.withdraw(amount);
  }

  @Override
  public void uploadBanknotes(Map<Integer, Integer> cassette)
      throws InvalidBanknoteNominationException, InvalidCassetteStateException {
    eur500.refillBanknoteFromCassette(cassette);
  }

  @Override
  public Map<Integer, Integer> getCurrencyState() {
    return eur500.getBanknoteState();
  }

  @Override
  public void setCurrencyState(Map<Integer, Integer> state)
      throws InvalidCassetteStateException, InvalidBanknoteNominationException {
    eur500.updateBanknoteState(state);
  }

  private class Eur500Banknote extends Banknote {

    Eur500Banknote() {
      nomination = 500;
    }
  }

  private class Eur200Banknote extends Banknote {

    Eur200Banknote() {
      nomination = 200;
    }
  }

  private class Eur100Banknote extends Banknote {

    Eur100Banknote() {
      nomination = 100;
    }
  }

  private class Eur50Banknote extends Banknote {

    Eur50Banknote() {
      nomination = 50;
    }
  }

  private class Eur20Banknote extends Banknote {

    Eur20Banknote() {
      nomination = 20;
    }
  }

  private class Eur10Banknote extends Banknote {

    Eur10Banknote() {
      nomination = 10;
    }
  }

  private class Eur5Banknote extends Banknote {

    Eur5Banknote() {
      nomination = 5;
    }
  }
}
