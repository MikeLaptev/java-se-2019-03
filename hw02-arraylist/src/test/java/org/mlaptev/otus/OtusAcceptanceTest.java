package org.mlaptev.otus;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.Comparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Collections.addAll(Collection<? super T> c, T... elements) Collections.static <T> void
 * copy(List<? super T> dest, List<? extends T> src) Collections.static <T> void sort(List<T> list,
 * Comparator<? super T> c)
 */
public class OtusAcceptanceTest {

  private MyArrayList<Integer> myArrayList;

  @BeforeEach
  void setup() {
    myArrayList = new MyArrayList<>();
  }

  @Test
  void collectionsAddAll() {
    // Arrange
    final Integer[] elementsToAdd = new Integer[]{1, 3, 5};

    // Act
    Collections.addAll(myArrayList, elementsToAdd);

    // Assert
    assertAll(
        () -> assertEquals(myArrayList.get(0), 1, "First element was added incorrectly"),
        () -> assertEquals(myArrayList.get(1), 3, "Second element was added incorrectly"),
        () -> assertEquals(myArrayList.get(2), 5, "Third element was added incorrectly")
    );
  }

  @Test
  void collectionsCopyTest() {
    // Arrange
    final Integer[] elementsToAdd = new Integer[]{1, 3, 5};
    Collections.addAll(myArrayList, elementsToAdd);

    final Integer[] elementsToInitialize = new Integer[]{0, 0, 0};
    MyArrayList<Integer> copyOfMyArrayList = new MyArrayList<>();
    Collections.addAll(copyOfMyArrayList, elementsToInitialize);

    // Act
    Collections.copy(copyOfMyArrayList, myArrayList);

    // Assert
    assertAll(
        () -> assertEquals(copyOfMyArrayList.get(0), 1, "First element was copied incorrectly"),
        () -> assertEquals(copyOfMyArrayList.get(1), 3, "Second element was copied incorrectly"),
        () -> assertEquals(copyOfMyArrayList.get(2), 5, "Third element was copied incorrectly")
    );
  }

  @Test
  void collectionsSortTest() {
    // Arrange
    final Integer[] elementsToAdd = new Integer[]{1, 3, 5};
    Collections.addAll(myArrayList, elementsToAdd);

    // Act
    Collections.sort(myArrayList, Comparator.reverseOrder());

    // Assert
    assertAll(
        () -> assertEquals(myArrayList.get(0), 5,
            "Sorting of the collection works wrong, first element is incorrect."),
        () -> assertEquals(myArrayList.get(1), 3,
            "Sorting of the collection works wrong, second element is incorrect."),
        () -> assertEquals(myArrayList.get(2), 1,
            "Sorting of the collection works wrong, third element is incorrect.")
    );
  }
}
