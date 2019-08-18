package org.mlaptev.otus.atm;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mlaptev.otus.atm.operations.OnlyBanknotesWith20Nomination;
import org.mlaptev.otus.currencies.CurrencyType;

public class AtmDifferentWithdrawApproachesTest {

  private AtmWithMultipleCurrencies atm;

  @BeforeEach
  void setup() {
    atm = new AtmWithMultipleCurrencies();
  }


  @Test
  void itShouldBePossibleToWithdrawUsingDifferentWays() throws Exception {
    // Arrange
    atm.addSupportOfCurrencyType(CurrencyType.USD);
    atm.loadCassette(CurrencyType.USD, new HashMap<>() {{
      put(1, 1);
      put(2, 2);
      put(5, 5);
      put(10, 10);
      put(20, 20);
      put(50, 50);
      put(100, 100);
    }});

    // Act & Assert
    Map<Integer, Integer> money = new HashMap<>();

    assertDoesNotThrow(() -> money.putAll(atm.withdraw(CurrencyType.USD, 80)),
        "It should be possible to withdraw.");

    assertAll(
        () -> assertEquals(3, money.size(), "Invalid amount of nominations of withdrawn money."),
        () -> assertEquals(1, money.get(10).intValue(), "Invalid amount of 10 USD banknotes"),
        () -> assertEquals(1, money.get(20).intValue(), "Invalid amount of 20 USD banknotes"),
        () -> assertEquals(1, money.get(50).intValue(), "Invalid amount of 50 USD banknotes")
    );

    atm.setCustomWithdrawType(OnlyBanknotesWith20Nomination.class);

    money.clear();

    assertDoesNotThrow(() -> money.putAll(atm.withdraw(CurrencyType.USD, 80)),
        "It should be possible to withdraw.");

    assertAll(
        () -> assertEquals(1, money.size(), "Invalid amount of nominations of withdrawn money."),
        () -> assertEquals(4, money.get(20).intValue(), "Invalid amount of 20 USD banknotes")
    );

    atm.resetWithdrawTypeToDefault();

    money.clear();

    assertDoesNotThrow(() -> money.putAll(atm.withdraw(CurrencyType.USD, 80)),
        "It should be possible to withdraw.");

    assertAll(
        () -> assertEquals(3, money.size(), "Invalid amount of nominations of withdrawn money."),
        () -> assertEquals(1, money.get(10).intValue(), "Invalid amount of 10 USD banknotes"),
        () -> assertEquals(1, money.get(20).intValue(), "Invalid amount of 20 USD banknotes"),
        () -> assertEquals(1, money.get(50).intValue(), "Invalid amount of 50 USD banknotes")
    );
  }
}
