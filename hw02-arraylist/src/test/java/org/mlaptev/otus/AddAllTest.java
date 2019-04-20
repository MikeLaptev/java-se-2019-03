package org.mlaptev.otus;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddAllTest {

  private MyArrayList<Integer> myArrayList;

  @BeforeEach
  void setup() {
    myArrayList = new MyArrayList<>();
  }

  @Test
  void addAllThrowsNullPointerExceptionWhenSpecifiedCollectionIsNull() {
    // Arrange & Act & Assert
    assertAll(
        () -> assertThrows(NullPointerException.class, () -> myArrayList.addAll(null)),
        () -> assertThrows(NullPointerException.class, () -> myArrayList.addAll(0, null))
    );
  }

  @Test
  void addAllThrowsIndexOutOfBoundExceptionIfIndexIsInvalid() {
    // Arrange & Act & Assert
    assertAll(
        () -> assertThrows(IndexOutOfBoundsException.class,
            () -> myArrayList.addAll(-1, Collections.emptyList())),
        () -> assertThrows(IndexOutOfBoundsException.class,
            () -> myArrayList.addAll(1, Collections.emptyList()))
    );
  }

  @Test
  void addAllInsertAllTheElementsAtTheEndOfTheList() {
    // Arrange
    myArrayList.add(-2);
    myArrayList.add(-1);
    myArrayList.add(-0);

    List<Integer> collection = new ArrayList<>();
    collection.add(1);
    collection.add(2);

    // Act
    myArrayList.addAll(collection);

    // Assert
    assertAll(
        () -> assertEquals(5, myArrayList.size()),
        () -> assertEquals(-2, myArrayList.get(0).intValue()),
        () -> assertEquals(-1, myArrayList.get(1).intValue()),
        () -> assertEquals(0, myArrayList.get(2).intValue()),
        () -> assertEquals(1, myArrayList.get(3).intValue()),
        () -> assertEquals(2, myArrayList.get(4).intValue())
    );
  }

  @Test
  void addAllInsertAllTheElementsAtTheSpecificPositionOfTheList() {
    // Arrange
    myArrayList.add(-2);
    myArrayList.add(2);

    List<Integer> collection = new ArrayList<>();
    collection.add(-1);
    collection.add(0);
    collection.add(1);

    // Act
    myArrayList.addAll(1, collection);

    // Assert
    assertAll(
        () -> assertEquals(5, myArrayList.size()),
        () -> assertEquals(-2, myArrayList.get(0).intValue()),
        () -> assertEquals(-1, myArrayList.get(1).intValue()),
        () -> assertEquals(0, myArrayList.get(2).intValue()),
        () -> assertEquals(1, myArrayList.get(3).intValue()),
        () -> assertEquals(2, myArrayList.get(4).intValue())
    );
  }
}
