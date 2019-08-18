package org.mlaptev.otus.atm.operations;

import java.util.HashMap;
import java.util.Map;
import org.mlaptev.otus.currencies.Banknote;
import org.mlaptev.otus.exceptions.AtmException;
import org.mlaptev.otus.exceptions.CannotWithdrawException;

public class MinimumAmountOfBanknotes implements Withdraw {

  private Banknote banknote;

  public MinimumAmountOfBanknotes(Banknote banknote) {
    this.banknote = banknote;
  }

  @Override
  public Map<Integer, Integer> execute(int amount) throws AtmException {
    Map<Integer, Integer> current = new HashMap<>();

    int numberOfBanknotes = banknote.getNumberOfBanknotes();
    MinimumAmountOfBanknotes nextInChain = null;
    if (banknote.getLowerNominationBanknote() != null) {
      nextInChain = new MinimumAmountOfBanknotes(banknote.getLowerNominationBanknote());
    }

    if (numberOfBanknotes != 0 && amount >= banknote.getNomination()) {
      int numberOfBanknotesToUse = amount / banknote.getNomination();

      if (numberOfBanknotesToUse > numberOfBanknotes) {
        numberOfBanknotesToUse = numberOfBanknotes;
      }

      int reminder = amount - numberOfBanknotesToUse * banknote.getNomination();

      current.put(banknote.getNomination(), numberOfBanknotesToUse);
      banknote.setNumberOfBanknotes(numberOfBanknotes - numberOfBanknotesToUse);

      if (reminder != 0) {
        if (nextInChain != null) {
          current.putAll(nextInChain.execute(reminder));
          return current;
        } else {
          throw new CannotWithdrawException("Cannot withdraw required amount of money from ATM.");
        }
      } else {
        return current;
      }
    } else {
      if (nextInChain != null) {
        return nextInChain.execute(amount);
      } else {
        throw new CannotWithdrawException("Cannot withdraw required amount of money from ATM.");
      }
    }
  }
}
