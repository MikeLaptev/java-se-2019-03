package org.mlaptev.otus;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class AddElementTest {

  private MyArrayList<Integer> myArrayList;

  @BeforeEach
  void setup() {
    myArrayList = new MyArrayList<>();
  }

  @ParameterizedTest
  @MethodSource(value = "listOfIntegers")
  void addElementFunctionShouldAddElementProperly(Integer... elementsToAdd) {
    // Arrange & Act
    for (Integer element: elementsToAdd) {
      myArrayList.add(element);
    }

    // Assert
    for (int i = 0; i < elementsToAdd.length; i++) {
      assertEquals(elementsToAdd[i], myArrayList.get(i));
    }
  }

  @ParameterizedTest
  @MethodSource(value = "listOfIntegers")
  void addElementFunctionReturnReturnsTrueWhenItIsEnoughMemory(Integer... elementsToAdd) {
    // Arrange & Act & Assert
    for (Integer element: elementsToAdd) {
      assertTrue(myArrayList.add(element));
    }
  }

  @ParameterizedTest
  @MethodSource(value = "listOfIntegers")
  void addElementFunctionShouldUpdateSizeOfTheArray(Integer... elementsToAdd) {
    // Arrange & Act & Assert
    int currentSize = myArrayList.size();
    for (Integer element: elementsToAdd) {
      myArrayList.add(element);
      assertEquals(++currentSize, myArrayList.size());
    }
  }

  @ParameterizedTest
  @MethodSource(value = "listOfIntegers")
  void arrayShouldNotBeEmptyIfItContainsOneOrMoreElements(Integer... elementsToAdd) {
    // Arrange & Act & Assert
    for (Integer element: elementsToAdd) {
      myArrayList.add(element);
      assertFalse(myArrayList.isEmpty());
    }
  }

  private static Stream<Arguments> listOfIntegers() {
    return Stream.of(
        Arguments.of((Object[]) new Integer[][]{new Integer[]{20, 3, 6}}),
        Arguments.of((Object[]) new Integer[][]{new Integer[]{13, 33, 17, 85, 7, 18, 19, 31}})
    );
  }

  @Test
  void addElementIntoANegativePositionOfArrayShouldThrowAnException() {
    // Arrange & Act & Assert
    assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.add(-1, -1));
  }

  @Test
  void addElementIntoAPositionOfArrayGreaterOrEqualSizeOfArrayShouldThrowAnException() {
    // Arrange
    myArrayList.add(0);
    myArrayList.add(1);

    // Act & Assert
    assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.add(2, 2));
  }

  @Test
  void addElementIntoAPositionOfArrayIncreaseSizeOfTheArray() {
    // Arrange
    myArrayList.add(0);
    myArrayList.add(1);
    myArrayList.add(3);

    // Act
    myArrayList.add(2, 2);

    // Assert
    assertEquals(4, myArrayList.size(), "Size of the array is incorrect");
  }

  @Test
  void addElementIntoAPositionOfArrayShouldShiftAllElementsAfterThePositionToRight() {
    // Arrange
    myArrayList.add(0);
    myArrayList.add(1);
    myArrayList.add(3);
    myArrayList.add(4);

    // Act
    myArrayList.add(2, 2);

    // Assert
    assertAll(
        () -> assertEquals(0, myArrayList.get(0).intValue(), "Element at position 0 is invalid"),
        () -> assertEquals(1, myArrayList.get(1).intValue(), "Element at position 1 is invalid"),
        () -> assertEquals(2, myArrayList.get(2).intValue(), "Element at position 2 is invalid"),
        () -> assertEquals(3, myArrayList.get(3).intValue(), "Element at position 3 is invalid"),
        () -> assertEquals(4, myArrayList.get(4).intValue(), "Element at position 4 is invalid")
    );
  }
}