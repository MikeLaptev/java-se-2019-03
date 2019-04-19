package org.mlaptev.otus;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SubListTest {

  private MyArrayList<Integer> myArrayList;

  @BeforeEach
  void setup() {
    myArrayList = new MyArrayList<>();
  }

  @Test
  void subListThrowsIndexOutOfBoundsIfFromIndexIsNegative() {
    // Arrange & Act & Assert
    assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.subList(-1, 1));
  }

  @Test
  void subListThrowsIndexOutOfBoundsIfToIndexIsGreaterThanSize() {
    // Arrange & Act
    myArrayList.add(0);
    myArrayList.add(1);

    // Assert
    assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.subList(1, 3));
  }

  @Test
  void subListThrowsIndexOutOfBoundsIfToIndexIsGreaterThanFromIndex() {
    // Arrange & Act & Assert
    assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.subList(2, 1));
  }
}
