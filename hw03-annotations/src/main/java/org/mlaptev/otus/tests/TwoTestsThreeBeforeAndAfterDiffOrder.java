package org.mlaptev.otus.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mlaptev.otus.framework.annotations.After;
import org.mlaptev.otus.framework.annotations.Before;
import org.mlaptev.otus.framework.annotations.Test;

/**
 * Before and after have different orders.
 *
 * Execution pipeline is:
 * - before (0) - ex. initialising something like A
 *  - before (1) - ex. initialising something like B, that depends on A
 *   - test
 *  - after (1) - ex. cleanup something like B, that still depends on A
 * - after (0) - ex. cleanup something like A, it should be Ok now, since B already cleaned up
 */
public class TwoTestsThreeBeforeAndAfterDiffOrder {

  private static final Logger logger = LogManager
      .getLogger(TwoTestsThreeBeforeAndAfterDiffOrder.class);

  public TwoTestsThreeBeforeAndAfterDiffOrder() {
    logger.info("constructor");
  }

  @Before
  public void firstSetUp() {
    logger.info("firstSetUp");
  }

  @Before(order = 1)
  public void secondSetUp() {
    logger.info("secondSetUp");
  }

  @Before(order = 2)
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

  @After(order = 1)
  public void secondCleanUp() {
    logger.info("secondCleanUp");
  }

  @After(order = 2)
  public void firstCleanUp() {
    logger.info("firstCleanUp");
  }
}
