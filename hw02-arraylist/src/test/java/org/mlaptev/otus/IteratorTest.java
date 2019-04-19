package org.mlaptev.otus;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.ListIterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IteratorTest {

  private MyArrayList<Integer> myArrayList;

  @BeforeEach
  void setup() {
    myArrayList = new MyArrayList<>();
  }

  @Test
  void smokeIteratorTest() {
    // Arrange
    myArrayList.add(0);
    myArrayList.add(1);
    myArrayList.add(2);
    myArrayList.add(3);
    myArrayList.add(4);

    // Act
    Iterator<Integer> iterator = myArrayList.iterator();

    // Assert
    // move forward
    int pos = 0;
    while (iterator.hasNext()) {
      assertEquals(myArrayList.get(pos++), iterator.next());
    }
    assertEquals(5, pos);
  }

  @Test
  void smokeListIteratorTest() {
    // Arrange
    myArrayList.add(0);
    myArrayList.add(1);
    myArrayList.add(2);
    myArrayList.add(3);
    myArrayList.add(4);

    // Act
    ListIterator<Integer> iterator = myArrayList.listIterator();

    // Assert
    // move forward
    int pos = -1;
    while (iterator.hasNext()) {
      assertEquals(myArrayList.get(++pos), iterator.next());
    }
    assertEquals(4, pos);
    // move back
    pos = 4;
    while (iterator.hasPrevious()) {
      assertEquals(myArrayList.get(--pos), iterator.previous());
    }
    assertEquals(0, pos);
    // move forward
    while (iterator.hasNext()) {
      assertEquals(myArrayList.get(++pos), iterator.next());
    }
    assertEquals(4, pos);
  }

  @Test
  void smokeListIteratorWithIndexTest() {
    // Arrange
    myArrayList.add(0);
    myArrayList.add(1);
    myArrayList.add(2);
    myArrayList.add(3);
    myArrayList.add(4);

    // Act
    ListIterator<Integer> iterator = myArrayList.listIterator(2);

    // Assert
    // move forward
    int pos = 1;
    while (iterator.hasNext()) {
      assertEquals(myArrayList.get(++pos), iterator.next());
    }
    assertEquals(4, pos);
    // move back
    pos = 4;
    while (iterator.hasPrevious()) {
      assertEquals(myArrayList.get(--pos), iterator.previous());
    }
    assertEquals(0, pos);
    // move forward
    while (iterator.hasNext()) {
      assertEquals(myArrayList.get(++pos), iterator.next());
    }
    assertEquals(4, pos);
  }
}
