package org.mlaptev.otus.atmdepartment;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mlaptev.otus.atm.Atm;
import org.mlaptev.otus.atm.AtmWithMultipleCurrencies;
import org.mlaptev.otus.currencies.CurrencyType;
import org.mlaptev.otus.exceptions.AtmException;

class ResetConditionsTest {

  private SimpleAtmDepartment department;

  @BeforeEach
  void setup() {
    department = new SimpleAtmDepartment();
  }

  @Test
  void resetConditionsOfAllTheAtmsIfNoWithdrawHasBeenMade() throws Exception {
    // Arrange
    Atm first = new AtmWithMultipleCurrencies();
    first.addSupportOfCurrencyType(CurrencyType.USD);
    first.loadCassette(CurrencyType.USD, new HashMap<>() {{
      put(20, 1);
    }});

    Atm second = new AtmWithMultipleCurrencies();
    second.addSupportOfCurrencyType(CurrencyType.GBP);
    second.loadCassette(CurrencyType.GBP, new HashMap<>() {{
      put(10, 1);
    }});
    second.addSupportOfCurrencyType(CurrencyType.USD);
    second.loadCassette(CurrencyType.USD, new HashMap<>() {{
      put(50, 1);
    }});

    department.addAtms(first, second);

    // Act
    department.resetConditionsOfAllTheAtms();

    // Assert
    assertAll(
        () -> assertDoesNotThrow(() -> first.withdraw(CurrencyType.USD, 20),
            "It should be possible to withdraw."),
        () -> assertDoesNotThrow(() -> second.withdraw(CurrencyType.GBP, 10),
            "It should be possible to withdraw."),
        () -> assertDoesNotThrow(() -> second.withdraw(CurrencyType.USD, 50),
            "It should be possible to withdraw.")
    );

    assertAll(
        () -> assertThrows(AtmException.class, () -> first.withdraw(CurrencyType.USD, 20),
            "It should not be possible to withdraw."),
        () -> assertThrows(AtmException.class, () -> second.withdraw(CurrencyType.GBP, 10),
            "It should not be possible to withdraw."),
        () -> assertThrows(AtmException.class, () -> second.withdraw(CurrencyType.USD, 50),
            "It should not be possible to withdraw.")
    );
  }

  @Test
  void resetConditionsOfAllTheAtmsIfWithdrawHasBeenMade() throws Exception {
    // Arrange
    Atm first = new AtmWithMultipleCurrencies();
    first.addSupportOfCurrencyType(CurrencyType.USD);
    first.loadCassette(CurrencyType.USD, new HashMap<>() {{
      put(20, 1);
    }});

    Atm second = new AtmWithMultipleCurrencies();
    second.addSupportOfCurrencyType(CurrencyType.GBP);
    second.loadCassette(CurrencyType.GBP, new HashMap<>() {{
      put(10, 1);
    }});
    second.addSupportOfCurrencyType(CurrencyType.USD);
    second.loadCassette(CurrencyType.USD, new HashMap<>() {{
      put(50, 1);
    }});

    department.addAtms(first, second);

    // Act & Assert
    assertAll(
        () -> assertDoesNotThrow(() -> first.withdraw(CurrencyType.USD, 20),
            "It should be possible to withdraw."),
        () -> assertDoesNotThrow(() -> second.withdraw(CurrencyType.GBP, 10),
            "It should be possible to withdraw."),
        () -> assertDoesNotThrow(() -> second.withdraw(CurrencyType.USD, 50),
            "It should be possible to withdraw.")
    );

    assertAll(
        () -> assertThrows(AtmException.class, () -> first.withdraw(CurrencyType.USD, 20),
            "It should not be possible to withdraw."),
        () -> assertThrows(AtmException.class, () -> second.withdraw(CurrencyType.GBP, 10),
            "It should not be possible to withdraw."),
        () -> assertThrows(AtmException.class, () -> second.withdraw(CurrencyType.USD, 50),
            "It should not be possible to withdraw.")
    );

    department.resetConditionsOfAllTheAtms();

    assertAll(
        () -> assertDoesNotThrow(() -> first.withdraw(CurrencyType.USD, 20),
            "It should be possible to withdraw."),
        () -> assertDoesNotThrow(() -> second.withdraw(CurrencyType.GBP, 10),
            "It should be possible to withdraw."),
        () -> assertDoesNotThrow(() -> second.withdraw(CurrencyType.USD, 50),
            "It should be possible to withdraw.")
    );

    assertAll(
        () -> assertThrows(AtmException.class, () -> first.withdraw(CurrencyType.USD, 20),
            "It should not be possible to withdraw."),
        () -> assertThrows(AtmException.class, () -> second.withdraw(CurrencyType.GBP, 10),
            "It should not be possible to withdraw."),
        () -> assertThrows(AtmException.class, () -> second.withdraw(CurrencyType.USD, 50),
            "It should not be possible to withdraw.")
    );
  }
}