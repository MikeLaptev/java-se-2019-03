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

  private static Logger logger = LogManager.getLogger(TwoTestsThreeBeforeAndAfterSameOrder.class);

  public TwoTestsThreeBeforeAndAfterSameOrder() {
    logger.info("Constructor");
  }

  @Before
  public void firstSetUp() {
    logger.info("Calling setup [1/3] - non-ordered.");
  }

  @Before
  public void secondSetUp() {
    logger.info("Calling setup [2/3] - non-ordered.");
  }

  @Before
  public void thirdSetUp() {
    logger.info("Calling setup [3/3] - non-ordered.");
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
  public void thirdCleanUp() {
    logger.info("Calling cleanup [1/3] - non-ordered.");
  }

  @After
  public void secondCleanUp() {
    logger.info("Calling cleanup [2/3] - non-ordered.");
  }

  @After
  public void firstCleanUp() {
    logger.info("Calling cleanup [3/3] - non-ordered.");
  }
}
