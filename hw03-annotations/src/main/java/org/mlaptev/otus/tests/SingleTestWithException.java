package org.mlaptev.otus.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mlaptev.otus.framework.annotations.After;
import org.mlaptev.otus.framework.annotations.Before;
import org.mlaptev.otus.framework.annotations.Test;

public class SingleTestWithException {

  private static final Logger logger = LogManager.getLogger(SingleTestWithException.class);

  public SingleTestWithException() {
    logger.info("constructor");
  }

  @Before
  public void setUp() {
    logger.info("setUp");
  }

  @Test
  public void firstTest() {
    throw new NullPointerException("Example of exception.");
  }

  @After
  public void cleanUp() {
    logger.info("cleanUp");
  }
}

