package org.mlaptev.otus;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NewListTest {

  private MyArrayList<Integer> myArrayList;

  @BeforeEach
  void setup() {
    myArrayList = new MyArrayList<>();
  }

  @Test
  void newListShouldHaveSizeZeroAndShouldBeEmpty() {
    // Arrange & Act & Assert
    assertAll(
        () -> assertEquals(0, myArrayList.size()),
        () -> assertTrue(myArrayList.isEmpty())
    );
  }

  @Test
  void accessToItemOfEmptyListShouldThrowsAnException() {
    // Arrange & Act & Assert
    assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.get(0));
  }

  @Test
  void accessToANegativeIndexShouldThrowsAnException() {
    // Arrange & Act & Assert
    assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.get(-1));
  }

  @Test
  void conversionToArrayShouldReturnsEmptyArray() {
    // Arrange & Act
    Object[] actualArray = myArrayList.toArray();

    // Assert
    assertAll(
        () -> assertNotNull(actualArray),
        () -> assertEquals(0, actualArray.length)
    );
  }
}
