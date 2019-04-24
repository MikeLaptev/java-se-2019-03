package org.mlaptev.otus.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mlaptev.otus.framework.annotations.After;
import org.mlaptev.otus.framework.annotations.Before;
import org.mlaptev.otus.framework.annotations.Test;

public class SingleTest {

  private final Logger logger = LogManager.getLogger(SingleTest.class);

  public SingleTest() {
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

  @After
  public void cleanUp() {
    logger.info("cleanUp");
  }
}
