package org.mlaptev.otus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mlaptev.otus.calculator.CalculatorInterface;
import org.mlaptev.otus.calculator.CalculatorV1;
import org.mlaptev.otus.calculator.CalculatorV2;
import org.mlaptev.otus.figure.Circle;
import org.mlaptev.otus.figure.FigureInterface;
import org.mlaptev.otus.figure.Square;
import org.mlaptev.otus.proxy.LogProxy;

public class Application {

  private static Logger logger = LogManager.getLogger(Application.class);

  public static void main(String[] args) {

    logger.info("Calculator");
    logger.info("===== 1 =====");

    CalculatorInterface calculatorV1 =
        (CalculatorInterface) LogProxy.instanceOf(new CalculatorV1());

    logger.info(calculatorV1.add(1, 2));
    logger.info(calculatorV1.subtract(1, 2));
    logger.info(calculatorV1.multiply(1, 2));

    logger.info("===== 2 =====");

    CalculatorInterface calculatorV2 =
        (CalculatorInterface) LogProxy.instanceOf(new CalculatorV2());

    logger.info(calculatorV2.add(2, 3));
    logger.info(calculatorV2.subtract(2, 3));
    logger.info(calculatorV2.multiply(2, 3));

    logger.info("Figure");
    logger.info("===== 1 =====");

    FigureInterface square =
        (FigureInterface) LogProxy.instanceOf(new Square(1.0));

    logger.info(square.getArea());

    logger.info("===== 2 =====");

    FigureInterface circle =
        (FigureInterface) LogProxy.instanceOf(new Circle(1.0));

    logger.info(circle.getArea());
  }
}
