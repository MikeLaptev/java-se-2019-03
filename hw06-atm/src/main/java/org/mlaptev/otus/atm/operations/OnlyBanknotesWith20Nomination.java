package org.mlaptev.otus.atm.operations;

import java.util.HashMap;
import java.util.Map;
import lombok.Setter;
import org.mlaptev.otus.currencies.Banknote;
import org.mlaptev.otus.exceptions.AtmException;
import org.mlaptev.otus.exceptions.CannotWithdrawException;

public class OnlyBanknotesWith20Nomination implements Withdraw {

  private static final int EXPECTED_NOMINATION = 20;

  @Setter
  private Banknote banknote;

  @Override
  public Map<Integer, Integer> execute(int amount) throws AtmException {
    if (amount % EXPECTED_NOMINATION != 0) {
      throw new CannotWithdrawException(
          String.format("Cannot withdraw expected amount using banknotes with nomination %d",
              EXPECTED_NOMINATION));
    }

    Map<Integer, Integer> current = new HashMap<>();

    OnlyBanknotesWith20Nomination nextInChain = null;
    if (banknote.getLowerNominationBanknote() != null) {
      nextInChain = new OnlyBanknotesWith20Nomination();
      nextInChain.setBanknote(banknote.getLowerNominationBanknote());
    }

    if (banknote.getNomination() == EXPECTED_NOMINATION) {
      int numberOfBanknotes = banknote.getNumberOfBanknotes();
      if (amount <= numberOfBanknotes * EXPECTED_NOMINATION) {
        current.put(banknote.getNomination(), amount / EXPECTED_NOMINATION);
        banknote.setNumberOfBanknotes(numberOfBanknotes - amount / EXPECTED_NOMINATION);
        return current;
      } else {
        throw new CannotWithdrawException(
            String.format("No enough banknotes with nomination %d to withdraw expected amount",
                EXPECTED_NOMINATION));
      }
    } else {
      if (nextInChain == null) {
        throw new CannotWithdrawException(
            String.format("Cannot find banknote with expected nomination %d", EXPECTED_NOMINATION));
      }
      return nextInChain.execute(amount);
    }
  }
}
