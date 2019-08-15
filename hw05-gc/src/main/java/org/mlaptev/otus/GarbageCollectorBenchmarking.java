package org.mlaptev.otus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class GarbageCollectorBenchmarking {

  private final static List<ItemHolder> holder = new ArrayList<>();

  private static final Random random = new Random();
  private static final int LIST_SIZE = 10_000_000;
  private static final int ENTRIES_TO_HOLD = 1000;

  public static List<ItemHolder> generateList() {
    List<ItemHolder> generatedList = new ArrayList<>();
    IntStream.range(0, LIST_SIZE)
        .forEach(item -> generatedList.add(new ItemHolder(random.nextLong())));
    return generatedList;
  }

  public static void removeQuarterOfItemsInTheList(List<ItemHolder> generatedList) {
    IntStream.range(0, generatedList.size() >> 2)
        .forEach(item -> generatedList.remove(generatedList.size() - 1));
  }

  public static void main(String[] args) {
    IntStream.range(0, ENTRIES_TO_HOLD).forEach(value -> {
      List<ItemHolder> list = generateList();
      int index = random.nextInt(list.size() / 2);
      holder.add(list.get(index));
      removeQuarterOfItemsInTheList(list);

      // to observe behavior in visualvm
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
  }
}
