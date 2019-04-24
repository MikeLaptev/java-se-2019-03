package org.mlaptev.otus.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mlaptev.otus.framework.annotations.After;
import org.mlaptev.otus.framework.annotations.Before;
import org.mlaptev.otus.framework.annotations.Test;

/**
 * Both before and after have the same order
 */
public class TwoTestsThreeBeforeAndAfterSameOrder {

  private final Logger logger = LogManager.getLogger(TwoTestsThreeBeforeAndAfterSameOrder.class);

  public TwoTestsThreeBeforeAndAfterSameOrder() {
    logger.info("constructor");
  }

  @Before
  public void firstSetUp() {
    logger.info("firstSetUp");
  }

  @Before
  public void secondSetUp() {
    logger.info("secondSetUp");
  }

  @Before
  public void thirdSetUp() {
    logger.info("thirdSetUp");
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
  public void thirdCleanUp() {
    logger.info("thirdCleanUp");
  }

  @After
  public void secondCleanUp() {
    logger.info("secondCleanUp");
  }

  @After
  public void firstCleanUp() {
    logger.info("firstCleanUp");
  }
}
