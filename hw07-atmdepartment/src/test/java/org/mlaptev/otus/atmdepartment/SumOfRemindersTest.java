package org.mlaptev.otus.atmdepartment;

import static org.junit.jupiter.api.Assertions.assertAll;
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

  private AtmDepartment department;

  @BeforeEach
  void setup() {
    department = new AtmDepartment();
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
    Map<CurrencyType, Long> reminder = department.getSumOfReminders();

    // Assert
    assertAll(
        () -> assertEquals(2, reminder.size(), "Two currencies should be presented in the system"),
        () -> assertAll(
            () -> assertTrue(reminder.containsKey(CurrencyType.USD), "USD currency should be presented"),
            () -> assertTrue(reminder.containsKey(CurrencyType.GBP), "GBP currency should be presented")
        ),
        () -> assertAll(
            () -> assertEquals(376, reminder.get(CurrencyType.USD), "Invalid reminder of USD"),
            () -> assertEquals(185, reminder.get(CurrencyType.GBP), "Invalid reminder of GBP")
        )
    );
  }
}