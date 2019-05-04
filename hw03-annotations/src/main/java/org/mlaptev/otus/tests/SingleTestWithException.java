package org.mlaptev.otus.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mlaptev.otus.framework.annotations.After;
import org.mlaptev.otus.framework.annotations.Before;
import org.mlaptev.otus.framework.annotations.Test;

public class SingleTestWithException {

  private final Logger logger = LogManager.getLogger(SingleTestWithException.class);

  public SingleTestWithException() {
    logger.info("Constructor");
  }

  @Before
  public void setUp() {
    logger.info("Calling setup [1/1].");
  }

  @Test
  public void test() {
    logger.info("Execution of the test [1/1] - be ready for exception...");
    throw new RuntimeException("Exception in the test...");
  }

  @After
  public void cleanUp() {
    logger.info("Calling cleanup [1/1].");
  }
}

