package org.mlaptev.otus.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mlaptev.otus.framework.annotations.After;
import org.mlaptev.otus.framework.annotations.Before;
import org.mlaptev.otus.framework.annotations.Test;

public class TwoTests {

  private static Logger logger = LogManager.getLogger(TwoTests.class);

  public TwoTests() {
    logger.info("Constructor");
  }

  @Before
  public void setUp() {
    logger.info("Calling setup [1/1].");
  }

  @Test
  public void firstTest() {
    logger.info("Execution of the test [1/2]...");
  }

  @Test
  public void secondTest() {
    logger.info("Execution of the test [2/2]...");
  }

  @After
  public void cleanUp() {
    logger.info("Calling cleanup [1/1].");
  }
}
