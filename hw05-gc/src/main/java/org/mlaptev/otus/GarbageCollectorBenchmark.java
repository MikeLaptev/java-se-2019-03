package org.mlaptev.otus;

import com.sun.management.GarbageCollectionNotificationInfo;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;
import javax.management.NotificationEmitter;
import javax.management.NotificationListener;
import javax.management.openmbean.CompositeData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GarbageCollectorBenchmark {

  private static Logger logger = LogManager.getLogger(GarbageCollectorBenchmark.class);

  private final static List<List<ItemHolder>> holder = new ArrayList<>();

  private static final Random random = new Random();
  private static final int LIST_SIZE = 128_000;
  private static final int ENTRIES_TO_HOLD = 1000;

  private static AtomicLong gcTotalExecutionTime = new AtomicLong();
  private static AtomicInteger gcTotalAmountOfExecutions = new AtomicInteger();

  public static List<ItemHolder> generateList() {
    List<ItemHolder> generatedList = new ArrayList<>();
    IntStream.range(0, LIST_SIZE)
        .forEach(item -> generatedList.add(new ItemHolder(random.nextLong())));
    return generatedList;
  }

  public static void removeHalfOfItemsInTheList(List<ItemHolder> generatedList) {
    IntStream.range(0, (generatedList.size() >> 1) + (generatedList.size() & 1))
        .forEach(item -> generatedList.remove(generatedList.size() - 1));
  }

  public static void main(String[] args) {
    enableGcMonitoring();
    long startTime = Instant.now().toEpochMilli();
    IntStream.range(0, ENTRIES_TO_HOLD).forEach(value -> {
      List<ItemHolder> list = generateList();
      holder.add(list);
      removeHalfOfItemsInTheList(list);
    });
    long endTime = Instant.now().toEpochMilli();
    logger.info("Execution time in milliseconds: {}", endTime - startTime);
    logger.info("GC. Total execution time in milliseconds: {}", gcTotalExecutionTime.get());
    logger.info("GC. Total amount of executions: {}", gcTotalAmountOfExecutions.get());
  }

  private static void enableGcMonitoring() {
    List<GarbageCollectorMXBean> gcBeans = ManagementFactory.getGarbageCollectorMXBeans();

    for (var bean : gcBeans) {
      NotificationEmitter emitter = (NotificationEmitter) bean;
      NotificationListener listener = (notification, handback) -> {
        if (notification.getType().equals(
            GarbageCollectionNotificationInfo.GARBAGE_COLLECTION_NOTIFICATION)) {
          var info = GarbageCollectionNotificationInfo.from(
              (CompositeData) notification.getUserData());
          gcTotalExecutionTime.getAndAdd(info.getGcInfo().getDuration());
          gcTotalAmountOfExecutions.incrementAndGet();
        }
      };

      emitter.addNotificationListener(listener, null, null);
    }
  }
}
