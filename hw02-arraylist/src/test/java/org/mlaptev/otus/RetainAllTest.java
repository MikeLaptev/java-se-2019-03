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

public class RetainAllTest {

  private MyArrayList<Integer> myArrayList;

  @BeforeEach
  void setup() {
    myArrayList = new MyArrayList<>();
  }

  @Test
  void retainAllThrowsNullPointerExceptionIfSpecifiedCollectionIsNull() {
    // Arrange & Act & Assert
    assertThrows(NullPointerException.class, () -> myArrayList.retainAll(null));
  }

  @Test
  void retainAllReturnsFalseIfOriginalAndSpecifiedCollectionsAreEmpty() {
    // Arrange & Act & Assert
    assertFalse(myArrayList.retainAll(Collections.emptyList()));
  }

  @Test
  void retainAllReturnsFalseIfOriginalAndSpecifiedCollectionsAreTheSame() {
    // Arrange
    // Adding elements to the original collection
    myArrayList.add(0);
    myArrayList.add(1);
    myArrayList.add(2);
    // Adding elements to the specified collection
    List<Integer> collection = new ArrayList<>();
    collection.add(2);
    collection.add(1);
    collection.add(0);

    // Act & Assert
    assertAll(
        () -> assertFalse(myArrayList.retainAll(collection)),
        () -> assertEquals(0, myArrayList.get(0).intValue()),
        () -> assertEquals(1, myArrayList.get(1).intValue()),
        () -> assertEquals(2, myArrayList.get(2).intValue())
    );
  }

  @Test
  void retainAllReturnsTrueIfOriginalAndSpecifiedCollectionsIntersects() {
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
    boolean result = myArrayList.retainAll(collection);

    // Assert
    assertAll(
        () -> assertTrue(result),
        () -> assertEquals(1, myArrayList.get(0).intValue()),
        () -> assertEquals(2, myArrayList.get(1).intValue()),
        () -> assertEquals(2, myArrayList.size())
    );
  }
}
