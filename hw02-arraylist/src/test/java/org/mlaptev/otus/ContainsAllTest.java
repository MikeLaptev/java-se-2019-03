package org.mlaptev.otus;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContainsAllTest {

  private MyArrayList<Integer> myArrayList;

  @BeforeEach
  void setup() {
    myArrayList = new MyArrayList<>();
  }

  @Test
  void containsAllThrowsNullPointerExceptionIfSpecifiedCollectionIsNull() {
    // Arrange & Act & Assert
    assertThrows(NullPointerException.class, () -> myArrayList.containsAll(null));
  }

  @Test
  void containsAllReturnTrueIfSpecifiedCollectionIsEmpty() {
    // Arrange & Act & Assert
    assertTrue(myArrayList.containsAll(Collections.emptyList()));
  }

  @Test
  void containsAllReturnsFalseIfTypesAreDifferent() {
    // Arrange
    List<String> listOfStrings = new ArrayList<>();

    // Act
    listOfStrings.add("1");
    myArrayList.add(0);
    myArrayList.add(1);
    myArrayList.add(2);

    // Assert
    assertFalse(myArrayList.containsAll(listOfStrings));
  }

  @Test
  void containsAllReturnsFalseIfOneOrMoreElementsAreNotPresentedInInitialCollection() {
    // Arrange
    List<Integer> collection = new ArrayList<>();

    // Act
    // Adding elements into original list
    myArrayList.add(0);
    myArrayList.add(1);
    myArrayList.add(2);
    myArrayList.add(3);
    // Adding elements into specified list
    collection.add(2);
    collection.add(3);
    collection.add(4);
    collection.add(5);

    // Assert
    assertFalse(myArrayList.containsAll(collection));
  }

  @Test
  void containsAllReturnsTrueIfAllOfTheElementsArePresentedInInitialCollection() {
    // Arrange
    List<Integer> collection = new ArrayList<>();

    // Act
    // Adding elements into original list
    myArrayList.add(0);
    myArrayList.add(1);
    myArrayList.add(2);
    myArrayList.add(3);
    myArrayList.add(4);
    myArrayList.add(5);
    // Adding elements into specified list
    collection.add(0);
    collection.add(2);
    collection.add(4);

    // Assert
    assertTrue(myArrayList.containsAll(collection));
  }
}