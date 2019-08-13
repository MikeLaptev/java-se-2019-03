package org.mlaptev.otus;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

public class CapacityTest {

  @Test
  void attemptToCreateAListWithAnInvalidCapacityShouldThrowAnException() {
    // Arrange
    final int invalidCapacity = -1;

    // Act & Assert
    assertThrows(UnsupportedOperationException.class,
        () -> new MyArrayList<>(invalidCapacity));
  }

  @Test
  void itShouldBePossibleToAddElementUpToDefinedCapacityWithoutIncreasingTheCapacity() {
    // Arrange
    final int predefinedCapacity = 24;
    MyArrayList<Integer> myArrayList = spy(new MyArrayList<>(predefinedCapacity));

    // Act & Assert
    for (int i = 0; i < predefinedCapacity; i++) {
      myArrayList.add(i);
    }
    verify(myArrayList, times(0)).extend();

    myArrayList.add(predefinedCapacity);
    verify(myArrayList, times(1)).extend();
  }
}
