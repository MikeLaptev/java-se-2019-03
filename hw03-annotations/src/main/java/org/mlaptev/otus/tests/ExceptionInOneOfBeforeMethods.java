package org.mlaptev.otus.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mlaptev.otus.framework.annotations.After;
import org.mlaptev.otus.framework.annotations.Before;
import org.mlaptev.otus.framework.annotations.Test;

public class ExceptionInOneOfBeforeMethods {

  private final Logger logger = LogManager.getLogger(ExceptionInOneOfBeforeMethods.class);

  public ExceptionInOneOfBeforeMethods() {
    logger.info("Constructor");
  }

  @Before
  public void firstSetUp() {
    logger.info("Calling setup [1/3] - ordered.");
  }

  @Before(order = 1)
  public void secondSetUp() {
    logger.info("Calling setup [2/3] - be ready for exception.");
    throw new RuntimeException("Exception in one of the before methods...");
  }

  @Before(order = 2)
  public void thirdSetUp() {
    logger.error("Calling setup [3/3] - WTF?");
  }

  @Test
  public void test() {
    logger.error("Execution of that test should never happen!");
  }

  @After
  public void thirdCleanUp() {
    logger.info("Calling cleanup [1/3] - ordered.");
  }

  @After(order = 1)
  public void secondCleanUp() {
    logger.info("Calling cleanup [2/3] - ordered.");
  }

  @After(order = 2)
  public void firstCleanUp() {
    logger.info("Calling cleanup [3/3] - ordered.");
  }
}
