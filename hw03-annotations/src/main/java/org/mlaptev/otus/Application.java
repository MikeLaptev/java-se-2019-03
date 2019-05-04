package org.mlaptev.otus;

import org.mlaptev.otus.framework.Framework;
import org.mlaptev.otus.tests.ExceptionInOneOfAfterMethods;
import org.mlaptev.otus.tests.ExceptionInOneOfBeforeMethods;
import org.mlaptev.otus.tests.SingleTest;
import org.mlaptev.otus.tests.SingleTestWithException;
import org.mlaptev.otus.tests.TwoTests;
import org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder;
import org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder;

public class Application {

  public static void main(String[] args) {
    final Framework framework = new Framework();

    framework.run(SingleTest.class);
    framework.run(TwoTests.class);
    framework.run(TwoTestsThreeBeforeAndAfterSameOrder.class);
    framework.run(TwoTestsThreeBeforeAndAfterDiffOrder.class);
    framework.run(SingleTestWithException.class);
    framework.run(ExceptionInOneOfAfterMethods.class);
    framework.run(ExceptionInOneOfBeforeMethods.class);
  }
}
