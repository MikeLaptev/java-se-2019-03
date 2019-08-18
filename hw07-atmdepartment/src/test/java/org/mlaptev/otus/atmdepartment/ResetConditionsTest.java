package org.mlaptev.otus.atmdepartment;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mlaptev.otus.atm.Atm;
import org.mlaptev.otus.atm.AtmWithMultipleCurrencies;
import org.mlaptev.otus.currencies.CurrencyType;

class ResetConditionsTest {

  private AtmDepartment department;

  @BeforeEach
  void setup() {
    department = new AtmDepartment();
  }

  @Test
  void resetConditionsOfAllTheAtmsIfNoWithdrawHasBeenMade() throws Exception {
    // Arrange
    Atm first = new AtmWithMultipleCurrencies();
    first.addSupportOfCurrencyType(CurrencyType.USD);
    first.loadCassette(CurrencyType.USD, new HashMap<>() {{
      put(1, 1);
      put(2, 1);
      put(5, 1);
      put(10, 1);
      put(20, 1);
      put(50, 1);
      put(100, 1);
    }});

    Atm second = new AtmWithMultipleCurrencies();
    second.addSupportOfCurrencyType(CurrencyType.GBP);
    second.loadCassette(CurrencyType.GBP, new HashMap<>() {{
      put(5, 1);
      put(10, 1);
      put(20, 1);
      put(50, 1);
      put(100, 1);
    }});
    second.addSupportOfCurrencyType(CurrencyType.USD);
    second.loadCassette(CurrencyType.USD, new HashMap<>() {{
      put(1, 1);
      put(2, 1);
      put(5, 1);
      put(10, 1);
      put(20, 1);
      put(50, 1);
      put(100, 1);
    }});

    department.addAtms(first, second);

    // Act
    department.resetConditionsOfAllTheAtms();

    // Assert
    Atm restoredFirst = department.getAtms().get(first.getUuid());
    Atm restoredSecond = department.getAtms().get(second.getUuid());
    assertAll(
        () -> assertNotNull(restoredFirst, "Department should contains first ATM"),
        () -> assertNotNull(restoredSecond, "Department should contains first ATM")
    );

    // TODO(mikhail.laptev): Implementation is required.
    throw new UnsupportedOperationException("Implementation is required.");
  }

  @Test
  void resetConditionsOfAllTheAtmsIfWithdrawHasBeenMade() throws Exception {
    // Arrange
    Atm first = new AtmWithMultipleCurrencies();
    first.addSupportOfCurrencyType(CurrencyType.USD);
    first.loadCassette(CurrencyType.USD, new HashMap<>() {{
      put(1, 1);
      put(2, 1);
      put(5, 1);
      put(10, 1);
      put(20, 1);
      put(50, 1);
      put(100, 1);
    }});

    Atm second = new AtmWithMultipleCurrencies();
    second.addSupportOfCurrencyType(CurrencyType.GBP);
    second.loadCassette(CurrencyType.GBP, new HashMap<>() {{
      put(5, 1);
      put(10, 1);
      put(20, 1);
      put(50, 1);
      put(100, 1);
    }});
    second.addSupportOfCurrencyType(CurrencyType.USD);
    second.loadCassette(CurrencyType.USD, new HashMap<>() {{
      put(1, 1);
      put(2, 1);
      put(5, 1);
      put(10, 1);
      put(20, 1);
      put(50, 1);
      put(100, 1);
    }});

    department.addAtms(first, second);

    // Act
    assertDoesNotThrow(() -> first.withdraw(CurrencyType.USD, 188),
        "It should be possible to withdraw.");
    assertDoesNotThrow(() -> second.withdraw(CurrencyType.GBP, 185),
        "It should be possible to withdraw.");

    department.resetConditionsOfAllTheAtms();

    // Assert
    Atm restoredFirst = department.getAtms().get(first.getUuid());
    Atm restoredSecond = department.getAtms().get(second.getUuid());
    assertAll(
        () -> assertNotNull(restoredFirst, "Department should contains first ATM"),
        () -> assertNotNull(restoredSecond, "Department should contains first ATM")
    );
    // TODO(mikhail.laptev): Implementation is required.
    throw new UnsupportedOperationException("Implementation is required.");
  }
}