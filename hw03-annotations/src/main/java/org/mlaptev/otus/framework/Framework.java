package org.mlaptev.otus.framework;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Framework {

  private static Logger logger = LogManager.getLogger(Framework.class);

  public void run(Class<?> clazz) {

    logger.info("Executing tests from class [{}]", clazz.getName());

    // List of all the methods
    List<Method> methods = Arrays.asList(clazz.getDeclaredMethods());

    // List of before steps
    List<Method> beforeSteps = Helper.getBeforeSteps(methods);

    // List of tests
    List<Method> tests = Helper.getTests(methods);

    // List of after steps
    List<Method> afterSteps = Helper.getAfterSteps(methods);

    for (Method test : tests) {
      executeSingleTest(clazz, beforeSteps, afterSteps, test);
    }
  }

  @SneakyThrows
  private void executeSingleTest(Class<?> clazz, List<Method> beforeSteps, List<Method> afterSteps,
      Method test) {
    // Creating a new instance of the test class
    Constructor<?> constructor = clazz.getConstructor();
    Object instance = constructor.newInstance();

    try {
      // Calling before method(s)
      for (Method beforeStep : beforeSteps) {
        beforeStep.invoke(instance);
      }

      // Calling the test
      try {
        test.invoke(instance);
      } catch (Exception e) {
        logger.error("Exception occurs during test execution...", e);
      }
    } catch (Exception e) {
      logger.error("Exception occurs during execution of pre-test steps... Exiting...", e);
    }

    // Calling the after method(s)
    for (Method afterStep : afterSteps) {
      try {
        afterStep.invoke(instance);
      } catch (Exception e) {
        logger.error("Exception occurs during execution of post-test steps...", e);
      }
    }
  }
}
