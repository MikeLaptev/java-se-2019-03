package org.mlaptev.otus;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyArrayList<T> implements List<T> {

  private static final Logger logger = LogManager.getLogger(MyArrayList.class);

  private int size;
  private int capacity;
  private T[] elements;

  public MyArrayList(int capacity) {
    if (capacity < 0) {
      throw new UnsupportedOperationException("Cannot create array list with invalid capacity.");
    }
    this.size = 0;
    this.capacity = capacity;
    this.elements = (T[]) new Object[capacity];
  }

  public MyArrayList() {
    this(0);
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean contains(Object o) {
    return Arrays.stream(elements)
        .limit(size())
        .anyMatch(t -> t.equals(o));
  }

  @Override
  public Object[] toArray() {
    return Arrays.copyOf(elements, size());
  }

  @Override
  public <T1> T1[] toArray(T1[] a) {
    for (int i = 0; i < a.length && i < size(); i++) {
      a[i] = (T1) elements[i];
    }
    return a;
  }

  @Override
  public void clear() {
    size = 0;
    elements = (T[]) new Object[capacity];
  }

  @Override
  public T get(int index) {
    evaluateIndex(index);

    return elements[index];
  }

  @Override
  public boolean add(T t) {
    if (elements.length - size < 1 && !extend()) {
      return false;
    }
    elements[size] = t;
    size++;
    return true;
  }

  @Override
  public T set(int index, T element) {
    evaluateIndex(index);

    T previous = elements[index];
    elements[index] = element;
    return previous;
  }

  @Override
  public void add(int index, T element) {
    evaluateIndex(index);

    if (size + 1 > elements.length && !extend()) {
      throw new OutOfMemoryError("Cannot allocate enough memory for adding an element.");
    }

    // Shift right tail of the array
    System.arraycopy(elements, index, elements, index + 1, size - index);

    // Inserting the element
    elements[index] = element;
    size++;
  }

  @Override
  public T remove(int index) {
    evaluateIndex(index);

    T element = elements[index];

    // Shift left tail of the array
    System.arraycopy(elements, index + 1, elements, index, size - 1 - index);

    // Cleanup
    elements[size - 1] = null;

    // Adjusting size
    size--;

    // Try to shrink if required
    shrink();

    return element;
  }

  @Override
  public boolean remove(Object o) {
    int itemPos = indexOf(o);
    if (itemPos != -1) {
      remove(itemPos);
      return true;
    }
    return false;
  }

  @Override
  public int indexOf(Object o) {
    for (int i = 0; i < size(); i++) {
      if ((get(i) == null && o == null) || get(i).equals(o)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public int lastIndexOf(Object o) {
    for (int i = size() - 1; i >= 0; i--) {
      if ((get(i) == null && o == null) || get(i).equals(o)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public boolean containsAll(Collection<?> collection) {
    if (collection == null) {
      throw new NullPointerException("Specified collection is null");
    }
    for (Object item : collection) {
      if (indexOf(item) == -1) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean removeAll(Collection<?> collection) {
    if (collection == null) {
      throw new NullPointerException("Specified collection is null");
    }

    boolean isChanged = false;

    for (Object item : collection) {
      int index = indexOf(item);
      if (index != -1) {
        remove(index);
        isChanged = true;
      }
    }

    return isChanged;
  }

  @Override
  public boolean retainAll(Collection<?> collection) {
    if (collection == null) {
      throw new NullPointerException("Specified collection is null");
    }

    boolean isChanged = false;

    if (!isEmpty()) {
      if (collection.isEmpty()) {
        clear();
        isChanged = true;
      } else {
        for (int i = size() - 1; i >= 0; i--) {
          if (!collection.contains(get(i))) {
            remove(i);
            isChanged = true;
          }
        }
      }
    }

    return isChanged;
  }

  @Override
  public List<T> subList(int fromIndex, int toIndex) {
    if (fromIndex < 0 || toIndex > size() || fromIndex > toIndex) {
      throw new IndexOutOfBoundsException(
          String.format("Invalid boundaries of sublist has been provided: [%d, %d]",
              fromIndex, toIndex));
    }

    throw new UnsupportedOperationException("subList operation currently is not supported.");
  }

  @Override
  public boolean addAll(Collection<? extends T> collection) {
    if (collection == null) {
      throw new NullPointerException("Specified collection is null.");
    }

    if (elements.length - size < collection.size() && !extend(size + collection.size())) {
      return false;
    }

    for (T item : collection) {
      elements[size] = item;
      size++;
    }
    return true;
  }

  @Override
  public boolean addAll(int index, Collection<? extends T> collection) {
    if (collection == null) {
      throw new NullPointerException("Specified collection is null.");
    }
    evaluateIndex(index);

    if (elements.length - size < collection.size() && !extend(size + collection.size())) {
      return false;
    }

    // Shift elements right
    for (int i = size() + collection.size() - 1; i > size(); i--) {
      elements[i] = elements[i - collection.size()];
    }

    // Insert elements from collection
    for (T item : collection) {
      elements[index] = item;
      index++;
      size++;
    }

    return true;
  }

  boolean extend() {
    // Let's check if it is possible or not to add the memory
    int currentCapacity = elements.length;

    if (Integer.MAX_VALUE == currentCapacity) {
      return false;
    } else if (Integer.MAX_VALUE - currentCapacity < ((currentCapacity + 1) >> 2)) {
      currentCapacity = Integer.MAX_VALUE;
    } else {
      currentCapacity++;
      // Extending array on ~25%
      currentCapacity += currentCapacity >> 2;
    }
    extendCapacity(currentCapacity);
    return true;
  }

  private boolean extend(int atLeast) {
    // Let's check if it is possible or not to add the memory
    int currentCapacity = elements.length;

    if (Integer.MAX_VALUE - currentCapacity < atLeast) {
      return false;
    } else if (Integer.MAX_VALUE - atLeast < (atLeast >> 2)) {
      currentCapacity = Integer.MAX_VALUE;
    } else {
      currentCapacity = atLeast;
      // Extending array on ~25%
      currentCapacity += currentCapacity >> 2;
    }
    extendCapacity(currentCapacity);
    return true;
  }

  private void extendCapacity(int currentCapacity) {
    logger.debug("Capacity increased to: {}", currentCapacity);
    // Creating new array
    T[] newElements = (T[]) new Object[currentCapacity];
    // Copy all the element into a new array
    System.arraycopy(elements, 0, newElements, 0, elements.length);
    // old elements are ready for GC
    elements = null;
    // old elements are replacing with copy of new elements
    elements = newElements;
  }

  private void shrink() {
    int currentCapacity = elements.length;

    if (size < currentCapacity - ((currentCapacity - 1) >> 2)) {
      // we can reduce size of the array
      currentCapacity--;
      currentCapacity -= (currentCapacity >> 2);
      logger.debug("Capacity decreased to: {}", currentCapacity);

      // Creating new array
      T[] newElements = (T[]) new Object[currentCapacity];

      // Copy all the element into a new array
      System.arraycopy(elements, 0, newElements, 0, size);

      // old elements are ready for GC
      elements = null;

      // old elements are replacing with copy of new elements
      elements = newElements;
    }
  }

  private void evaluateIndex(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException(String.format("Invalid index provided - %d", index));
    }
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<>() {
      private int current = -1;

      @Override
      public boolean hasNext() {
        return current < size() - 1;
      }

      @Override
      public T next() {
        if (!hasNext()) {
          throw new NoSuchElementException("End of the collection reached.");
        }
        return get(++current);
      }
    };
  }

  @Override
  public ListIterator<T> listIterator() {
    return listIterator(0);
  }

  @Override
  public ListIterator<T> listIterator(int index) {
    evaluateIndex(index);

    return new ListIterator<>() {
      private int current = index - 1;

      @Override
      public boolean hasNext() {
        return current < size() - 1;
      }

      @Override
      public T next() {
        if (!hasNext()) {
          throw new NoSuchElementException("End of the collection reached.");
        }
        return get(++current);
      }

      @Override
      public boolean hasPrevious() {
        return current > 0;
      }

      @Override
      public T previous() {
        if (!hasPrevious()) {
          throw new NoSuchElementException("Beginning of the collection reached.");
        }
        return get(--current);
      }

      @Override
      public int nextIndex() {
        return current + 1;
      }

      @Override
      public int previousIndex() {
        return current - 1;
      }

      @Override
      public void remove() {
        MyArrayList.this.remove(current);
      }

      @Override
      public void set(T t) {
        MyArrayList.this.set(current, t);
      }

      @Override
      public void add(T t) {
        MyArrayList.this.add(current, t);
      }
    };
  }
}