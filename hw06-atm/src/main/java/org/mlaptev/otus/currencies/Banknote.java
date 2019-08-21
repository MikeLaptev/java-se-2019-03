package org.mlaptev.otus.currencies;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.mlaptev.otus.exceptions.AtmException;
import org.mlaptev.otus.exceptions.CannotWithdrawException;
import org.mlaptev.otus.exceptions.InvalidBanknoteNominationException;
import org.mlaptev.otus.exceptions.InvalidCassetteStateException;

@Getter
public abstract class Banknote {

  // Reference on a banknote with lower nomination
  private Banknote lowerNominationBanknote = null;

  private int nomination;

  @Setter
  private int numberOfBanknotes;

  public Banknote(int nomination) {
    this.nomination = nomination;
  }

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
  void refillBanknoteFromCassette(Map<Integer, Integer> cassette) throws AtmException {
    if (cassette.containsKey(nomination)) {
      if (cassette.get(nomination) < 0) {
        throw new InvalidCassetteStateException("Number of banknotes to add should be positive");
      }
      numberOfBanknotes += cassette.remove(nomination);
    }

    if (lowerNominationBanknote != null) {
      lowerNominationBanknote.refillBanknoteFromCassette(cassette);
    } else if (!cassette.isEmpty()) {
      throw new InvalidBanknoteNominationException(
          "Not supported banknote nomination in cassette");
    }
  }

  void updateBanknoteState(Map<Integer, Integer> state) throws AtmException {
    if (state.containsKey(nomination)) {
      if (state.get(nomination) < 0) {
        throw new InvalidCassetteStateException("Number of banknotes to add should be positive");
      }
      numberOfBanknotes = state.remove(nomination);
    } else {
      numberOfBanknotes = 0;
    }

    if (lowerNominationBanknote != null) {
      lowerNominationBanknote.updateBanknoteState(state);
    } else if (!state.isEmpty()) {
      throw new InvalidBanknoteNominationException(
          "Not supported banknote nomination in cassette");
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
}
