package org.mlaptev.otus;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RemoveElementTest {

  private MyArrayList<Integer> myArrayList;

  @BeforeEach
  void setup() {
    myArrayList = new MyArrayList<>();
  }

  @Test
  void removeAtNegativeIndexShouldThrowAnException() {
    // Arrange
    int initialSize = myArrayList.size();

    // Act & Assert

    assertAll(
        () -> assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.remove(-1)),
        () -> assertEquals(initialSize, myArrayList.size())
    );
  }

  @Test
  void removeAtPositiveIndexThatGreaterOrEqualSizeOfArrayShouldThrowAnException() {
    // Arrange
    myArrayList.add(0);
    myArrayList.add(1);
    int initialSize = myArrayList.size();

    // Act & Assert
    assertAll(
        () -> assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.remove(2)),
        () -> assertEquals(initialSize, myArrayList.size())
    );
  }

  @Test
  void removeAtPositiveIndexThatLessThanSizeOfArrayShouldReturnRemovedElement() {
    // Arrange
    myArrayList.add(0);
    myArrayList.add(1);
    myArrayList.add(2);
    myArrayList.add(3);
    int initialSize = myArrayList.size();

    // Act
    int removedElement = myArrayList.remove(2);

    // Assert
    assertAll(
        () -> assertEquals(2, removedElement),
        () -> assertEquals(initialSize - 1, myArrayList.size()),
        () -> assertEquals(0, myArrayList.get(0)),
        () -> assertEquals(1, myArrayList.get(1)),
        () -> assertEquals(3, myArrayList.get(2))
    );
  }

  @Test
  void removeOfNullElementFromEmptyArrayListShouldReturnFalse() {
    // Arrange
    int initialSize = myArrayList.size();

    // Act & Assert
    assertAll(
        () -> assertFalse(myArrayList.remove(null)),
        () -> assertEquals(initialSize, myArrayList.size())
    );
  }

  @Test
  void removeOfNullElementFromAnArrayListWithoutNullElementsShouldReturnFalse() {
    // Arrange
    myArrayList.add(0);
    myArrayList.add(1);
    myArrayList.add(2);
    int initialSize = myArrayList.size();

    // Act & Assert
    assertAll(
        () -> assertFalse(myArrayList.remove(null)),
        () -> assertEquals(initialSize, myArrayList.size())
    );
  }

  @Test
  void removeOfNullElementFromAnArrayListWithNullElementsShouldReturnTrue() {
    // Arrange
    myArrayList.add(0);
    myArrayList.add(null);
    myArrayList.add(1);
    int initialSize = myArrayList.size();

    // Act & Assert
    assertAll(
        () -> assertTrue(myArrayList.remove(null)),
        () -> assertEquals(initialSize - 1, myArrayList.size())
    );
  }

  @Test
  void removeOfNotNullElementFromEmptyArrayListShouldReturnFalse() {
    // Arrange
    int initialSize = myArrayList.size();

    // Act & Assert
    assertAll(
        () -> assertFalse(myArrayList.remove(Integer.valueOf(-1))),
        () -> assertEquals(initialSize, myArrayList.size())
    );
  }

  @Test
  void removeOfNotNullElementFromAnArrayListWithoutThisElementShouldReturnFalse() {
    // Arrange
    myArrayList.add(0);
    myArrayList.add(1);
    myArrayList.add(2);
    int initialSize = myArrayList.size();

    // Act & Assert
    assertAll(
        () -> assertFalse(myArrayList.remove(Integer.valueOf(-1))),
        () -> assertEquals(initialSize, myArrayList.size())
    );
  }

  @Test
  void removeOfNotNullElementFromAnArrayListWithoutThisElementShouldReturnTrue() {
    // Arrange
    myArrayList.add(0);
    myArrayList.add(1);
    myArrayList.add(2);
    int initialSize = myArrayList.size();

    // Act & Assert
    assertAll(
        () -> assertTrue(myArrayList.remove(Integer.valueOf(1))),
        () -> assertEquals(initialSize - 1, myArrayList.size())
    );
  }

  @Test
  void itShouldBePossibleToAddAndRemoveAllTheAddedItemsFromArray() {
    // Arrange
    int numberOfItemsToAdd = 100;

    // Act & Assert
    for (int item = 0; item < numberOfItemsToAdd; item++) {
      assertTrue(myArrayList.add(item));
    }

    for (int size = numberOfItemsToAdd - 1; size >= 0; size--) {
      myArrayList.remove(0);
      assertEquals(size, myArrayList.size());
    }
  }
}
