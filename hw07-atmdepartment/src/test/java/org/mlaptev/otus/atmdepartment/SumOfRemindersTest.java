package org.mlaptev.otus.atmdepartment;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mlaptev.otus.atm.Atm;
import org.mlaptev.otus.atm.AtmWithMultipleCurrencies;
import org.mlaptev.otus.currencies.CurrencyType;

class SumOfRemindersTest {

  private SimpleAtmDepartment department;

  @BeforeEach
  void setup() {
    department = new SimpleAtmDepartment();
  }

  @Test
  void getSumOfRemindersForEmptyAtms() throws Exception {
    // Arrange
    Atm first = new AtmWithMultipleCurrencies();
    first.addSupportOfCurrencyType(CurrencyType.USD);
    first.loadCassette(CurrencyType.USD, Map.of());

    Atm second = new AtmWithMultipleCurrencies();
    second.addSupportOfCurrencyType(CurrencyType.GBP);
    second.loadCassette(CurrencyType.GBP, Map.of());
    second.addSupportOfCurrencyType(CurrencyType.USD);
    second.loadCassette(CurrencyType.USD, Map.of());

    department.addAtms(first, second);

    // Act
    Map<CurrencyType, Long> reminder = department.getSumOfReminders();

    // Assert
    assertAll(
        () -> assertEquals(2, reminder.size(), "Two currencies should be presented in the system"),
        () -> assertAll(
            () -> assertTrue(reminder.containsKey(CurrencyType.USD), "USD currency should be presented"),
            () -> assertTrue(reminder.containsKey(CurrencyType.GBP), "GBP currency should be presented")
        ),
        () -> assertAll(
            () -> assertEquals(0, reminder.get(CurrencyType.USD), "Invalid reminder of USD"),
            () -> assertEquals(0, reminder.get(CurrencyType.GBP), "Invalid reminder of GBP")
        )
    );
  }

  @Test
  void getSumOfRemindersForNonEmptyAtms() throws Exception {
    // Arrange
    Atm first = new AtmWithMultipleCurrencies();
    first.addSupportOfCurrencyType(CurrencyType.USD);
    first.loadCassette(CurrencyType.USD, new HashMap<>() {{
      put(50, 1);
      put(100, 1);
    }});

    Atm second = new AtmWithMultipleCurrencies();
    second.addSupportOfCurrencyType(CurrencyType.GBP);
    second.loadCassette(CurrencyType.GBP, new HashMap<>() {{
      put(50, 1);
      put(100, 1);
    }});
    second.addSupportOfCurrencyType(CurrencyType.USD);
    second.loadCassette(CurrencyType.USD, new HashMap<>() {{
      put(50, 1);
      put(100, 1);
    }});

    department.addAtms(first, second);

    // Act
    Map<CurrencyType, Long> reminder = department.getSumOfReminders();

    // Assert
    assertAll(
        () -> assertEquals(2, reminder.size(), "Two currencies should be presented in the system"),
        () -> assertAll(
            () -> assertTrue(reminder.containsKey(CurrencyType.USD), "USD currency should be presented"),
            () -> assertTrue(reminder.containsKey(CurrencyType.GBP), "GBP currency should be presented")
        ),
        () -> assertAll(
            () -> assertEquals(300, reminder.get(CurrencyType.USD), "Invalid reminder of USD"),
            () -> assertEquals(150, reminder.get(CurrencyType.GBP), "Invalid reminder of GBP")
        )
    );
  }

  @Test
  void getSumOfRemindersForNonEmptyAtmsAfterWithdrawal() throws Exception {
    // Arrange
    Atm first = new AtmWithMultipleCurrencies();
    first.addSupportOfCurrencyType(CurrencyType.USD);
    first.loadCassette(CurrencyType.USD, new HashMap<>() {{
      put(50, 1);
      put(100, 1);
    }});

    Atm second = new AtmWithMultipleCurrencies();
    second.addSupportOfCurrencyType(CurrencyType.GBP);
    second.loadCassette(CurrencyType.GBP, new HashMap<>() {{
      put(50, 1);
      put(100, 1);
    }});
    second.addSupportOfCurrencyType(CurrencyType.USD);
    second.loadCassette(CurrencyType.USD, new HashMap<>() {{
      put(50, 1);
      put(100, 1);
    }});

    department.addAtms(first, second);

    // Act
    assertAll(
        () -> assertDoesNotThrow(() -> first.withdraw(CurrencyType.USD, 50),
            "It should be possible to withdraw."),
        () -> assertDoesNotThrow(() -> second.withdraw(CurrencyType.GBP, 50),
            "It should be possible to withdraw."),
        () -> assertDoesNotThrow(() -> second.withdraw(CurrencyType.USD, 50),
            "It should be possible to withdraw.")
    );

    Map<CurrencyType, Long> reminder = department.getSumOfReminders();

    // Assert
    assertAll(
        () -> assertEquals(2, reminder.size(), "Two currencies should be presented in the system"),
        () -> assertAll(
            () -> assertTrue(reminder.containsKey(CurrencyType.USD), "USD currency should be presented"),
            () -> assertTrue(reminder.containsKey(CurrencyType.GBP), "GBP currency should be presented")
        ),
        () -> assertAll(
            () -> assertEquals(200, reminder.get(CurrencyType.USD), "Invalid reminder of USD"),
            () -> assertEquals(100, reminder.get(CurrencyType.GBP), "Invalid reminder of GBP")
        )
    );
  }
}