package org.mlaptev.otus;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RemoveAllTest {

  private MyArrayList<Integer> myArrayList;

  @BeforeEach
  void setup() {
    myArrayList = new MyArrayList<>();
  }

  @Test
  void removeAllThrowsNullPointerExceptionIfSpecifiedCollectionIsNull() {
    // Arrange & Act & Assert
    assertThrows(NullPointerException.class, () -> myArrayList.removeAll(null));
  }

  @Test
  void removeAllDoesNotChangeCollectionIfSpecifiedCollectionIsEmpty() {
    // Arrange
    myArrayList.add(0);
    myArrayList.add(1);
    myArrayList.add(2);

    // Act
    boolean result = myArrayList.removeAll(Collections.emptyList());

    // Assert
    assertAll(
        () -> assertFalse(result),
        () -> assertEquals(0, myArrayList.get(0).intValue()),
        () -> assertEquals(1, myArrayList.get(1).intValue()),
        () -> assertEquals(2, myArrayList.get(2).intValue())
    );
  }

  @Test
  void removeAllDoesNotChangeCollectionIfThereIsNotIntersectionWithSpecifiedCollection() {
    // Arrange
    // Specified Collection
    List<Integer> collection = new ArrayList<>();
    collection.add(-1);
    collection.add(-2);
    collection.add(-3);
    // Original Collection
    myArrayList.add(1);
    myArrayList.add(2);
    myArrayList.add(3);

    // Act
    boolean result = myArrayList.removeAll(collection);

    // Assert
    assertAll(
        () -> assertFalse(result),
        () -> assertEquals(1, myArrayList.get(0).intValue()),
        () -> assertEquals(2, myArrayList.get(1).intValue()),
        () -> assertEquals(3, myArrayList.get(2).intValue())
    );
  }

  @Test
  void removeAllReturnsTrueIfOriginalAndSpecifiedCollectionsIntersects() {
    // Arrange
    // Adding elements to the original collection
    myArrayList.add(0);
    myArrayList.add(1);
    myArrayList.add(2);
    // Adding elements to the specified collection
    List<Integer> collection = new ArrayList<>();
    collection.add(1);
    collection.add(2);
    collection.add(3);

    // Act
    boolean result = myArrayList.removeAll(collection);

    // Assert
    assertAll(
        () -> assertTrue(result),
        () -> assertEquals(0, myArrayList.get(0).intValue()),
        () -> assertEquals(1, myArrayList.size())
    );
  }
}
