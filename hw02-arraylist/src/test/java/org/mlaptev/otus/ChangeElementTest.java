package org.mlaptev.otus;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChangeElementTest {

  private MyArrayList<Integer> myArrayList;

  @BeforeEach
  void setup() {
    myArrayList = new MyArrayList<>();
  }

  @Test
  void setByNegativeIndexShouldThrowAnException() {
    // Arrange & Act & Assert
    assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.set(-1, -1));
  }

  @Test
  void setByPositiveIndexTheGreaterOrEqualSizeOfArrayShouldThrowAnException() {
    // Arrange
    myArrayList.add(0);
    myArrayList.add(1);

    // Act & Assert
    assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.set(2, 2));
  }

  @Test
  void setByValidIndexShouldUpdateRequiredElementAndReturnOldOne() {
    // Arrange
    myArrayList.add(0);
    myArrayList.add(1);
    myArrayList.add(2);

    // Act
    int previous = myArrayList.set(2, -2);

    // Assert
    assertAll(
        () -> assertEquals(2, previous),
        () -> assertEquals(-2, myArrayList.get(2).intValue())
    );
  }
}