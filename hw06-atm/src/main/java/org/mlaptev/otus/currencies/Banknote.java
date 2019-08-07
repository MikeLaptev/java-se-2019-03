package org.mlaptev.otus.currencies;

import java.util.HashMap;
import java.util.Map;
import org.mlaptev.otus.exceptions.CannotWithdrawException;
import org.mlaptev.otus.exceptions.InvalidBanknoteNominationException;
import org.mlaptev.otus.exceptions.InvalidCassetteStateException;

abstract class Banknote {

  // Reference on a banknote with lower nomination
  private Banknote lowerNominationBanknote = null;

  int nomination;
  private int numberOfBanknotes;

  void setLowerNominationBanknote(Banknote banknote) {
    this.lowerNominationBanknote = banknote;
  }

  /**
   * Refill banknotes from provided cassette
   *
   * @param cassette - a cassette that contains details how many banknotes certain nomination is
   * present and should be added to current state
   * @throws InvalidCassetteStateException - if amount of banknotes of certain nomination is not
   * positive
   * @throws InvalidBanknoteNominationException - if cassette contains banknotes of invalid
   * nomination
   */
  void refillBanknoteFromCassette(Map<Integer, Integer> cassette)
      throws InvalidCassetteStateException, InvalidBanknoteNominationException {
    if (cassette.containsKey(nomination)) {
      if (cassette.get(nomination) < 0) {
        throw new InvalidCassetteStateException(
            "Number of banknotes to add should be not negative");
      }

      numberOfBanknotes += cassette.remove(nomination);

      if (lowerNominationBanknote != null) {
        lowerNominationBanknote.refillBanknoteFromCassette(cassette);
      } else if (!cassette.isEmpty()) {
        throw new InvalidBanknoteNominationException(
            "Not supported banknote nomination in cassette");
      }
    }
  }

  void updateBanknoteState(Map<Integer, Integer> state)
      throws InvalidCassetteStateException, InvalidBanknoteNominationException {
    if (state.containsKey(nomination)) {
      if (state.get(nomination) < 0) {
        throw new InvalidCassetteStateException("Number of banknotes to add should be positive");
      }

      numberOfBanknotes = state.remove(nomination);

      if (lowerNominationBanknote != null) {
        lowerNominationBanknote.refillBanknoteFromCassette(state);
      } else if (!state.isEmpty()) {
        throw new InvalidBanknoteNominationException(
            "Not supported banknote nomination in cassette");
      }
    } else {
      numberOfBanknotes = 0;
    }
  }

  Map<Integer, Integer> getBanknoteState() {
    Map<Integer, Integer> current = new HashMap<>();
    current.put(nomination, numberOfBanknotes);

    if (lowerNominationBanknote != null) {
      current.putAll(lowerNominationBanknote.getBanknoteState());
    }

    return current;
  }

  Map<Integer, Integer> withdraw(int amount) throws CannotWithdrawException {
    Map<Integer, Integer> current = new HashMap<>();

    if (numberOfBanknotes != 0 && amount >= nomination) {
      int numberOfBanknotesToUse = amount / nomination;

      if (numberOfBanknotesToUse > numberOfBanknotes) {
        numberOfBanknotesToUse = numberOfBanknotes;
      }

      int reminder = amount - numberOfBanknotesToUse * nomination;

      current.put(nomination, numberOfBanknotesToUse);
      numberOfBanknotes -= numberOfBanknotesToUse;

      if (reminder != 0) {
        if (lowerNominationBanknote != null) {
          current.putAll(lowerNominationBanknote.withdraw(reminder));
          return current;
        } else {
          throw new CannotWithdrawException("Cannot withdraw required amount of money from ATM.");
        }
      } else {
        return current;
      }
    } else {
      if (lowerNominationBanknote != null) {
        return lowerNominationBanknote.withdraw(amount);
      } else {
        throw new CannotWithdrawException("Cannot withdraw required amount of money from ATM.");
      }
    }
  }
}
