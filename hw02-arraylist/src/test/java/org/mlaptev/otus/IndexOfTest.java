package org.mlaptev.otus;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IndexOfTest {

  private MyArrayList<Integer> myArrayList;

  @BeforeEach
  void setup() {
    myArrayList = new MyArrayList<>();
  }

  @Test
  void noIndexShouldBeReturnedForAnyObjectsForEmptyArray() {
    // Arrange & Act & Assert
    assertAll(
        () -> assertEquals(-1, myArrayList.indexOf(null)),
        () -> assertEquals(-1, myArrayList.indexOf(0)),
        () -> assertEquals(-1, myArrayList.lastIndexOf(null)),
        () -> assertEquals(-1, myArrayList.lastIndexOf(0))
    );
  }

  @Test
  void noIndexShouldBeReturnedForAnyObjectsForNonEmptyArrayIfNoSuchElementInArray() {
    // Arrange
    myArrayList.add(0);
    myArrayList.add(1);
    myArrayList.add(2);

    // Act & Assert
    assertAll(
        () -> assertEquals(-1, myArrayList.indexOf(null)),
        () -> assertEquals(-1, myArrayList.indexOf(-1)),
        () -> assertEquals(-1, myArrayList.lastIndexOf(null)),
        () -> assertEquals(-1, myArrayList.lastIndexOf(-1))
    );
  }

  @Test
  void firstIndexShouldBeReturnedForExistedElementForInArrayIfIndexOfIsUsed() {
    // Arrange
    myArrayList.add(0);
    myArrayList.add(1);
    myArrayList.add(2);
    myArrayList.add(null);
    myArrayList.add(4);
    myArrayList.add(null);
    myArrayList.add(2);
    myArrayList.add(1);
    myArrayList.add(0);

    // Act & Assert
    assertAll(
        () -> assertEquals(0, myArrayList.indexOf(0)),
        () -> assertEquals(1, myArrayList.indexOf(1)),
        () -> assertEquals(2, myArrayList.indexOf(2)),
        () -> assertEquals(3, myArrayList.indexOf(null))
    );
  }

  @Test
  void lastIndexShouldBeReturnedForExistedElementForInArrayIfLastIndexOfIsUsed() {
    // Arrange
    myArrayList.add(0);
    myArrayList.add(1);
    myArrayList.add(2);
    myArrayList.add(null);
    myArrayList.add(4);
    myArrayList.add(null);
    myArrayList.add(2);
    myArrayList.add(1);
    myArrayList.add(0);

    // Act & Assert
    assertAll(
        () -> assertEquals(8, myArrayList.lastIndexOf(0)),
        () -> assertEquals(7, myArrayList.lastIndexOf(1)),
        () -> assertEquals(6, myArrayList.lastIndexOf(2)),
        () -> assertEquals(5, myArrayList.lastIndexOf(null))
    );
  }
}
