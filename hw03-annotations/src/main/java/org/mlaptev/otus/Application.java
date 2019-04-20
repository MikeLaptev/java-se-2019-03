package org.mlaptev.otus;

import java.lang.reflect.InvocationTargetException;
import org.mlaptev.otus.framework.Framework;
import org.mlaptev.otus.tests.SingleTest;
import org.mlaptev.otus.tests.SingleTestWithException;
import org.mlaptev.otus.tests.TwoTests;
import org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder;
import org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder;

public class Application {

  public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
      InvocationTargetException, InstantiationException, IllegalAccessException {
    Framework.executeTest(SingleTest.class);
    Framework.executeTest(TwoTests.class);
    Framework.executeTest(TwoTestsThreeBeforeAndAfterSameOrder.class);
    Framework.executeTest(TwoTestsThreeBeforeAndAfterDiffOrder.class);
    Framework.executeTest(SingleTestWithException.class);
  }
}
