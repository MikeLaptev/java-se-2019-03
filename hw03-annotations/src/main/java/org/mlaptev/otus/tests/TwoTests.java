package org.mlaptev.otus.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mlaptev.otus.framework.annotations.After;
import org.mlaptev.otus.framework.annotations.Before;
import org.mlaptev.otus.framework.annotations.Test;

public class TwoTests {

  private static final Logger logger = LogManager.getLogger(TwoTests.class);

  public TwoTests() {
    logger.info("constructor");
  }

  @Before
  public void setUp() {
    logger.info("setUp");
  }

  @Test
  public void firstTest() {
    logger.info("firstTest");
  }

  @Test
  public void secondTest() {
    logger.info("secondTest");
  }

  @After
  public void cleanUp() {
    logger.info("cleanUp");
  }
}
