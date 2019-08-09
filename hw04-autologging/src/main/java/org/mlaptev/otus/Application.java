package org.mlaptev.otus;

import org.mlaptev.otus.calculator.CalculatorInterface;
import org.mlaptev.otus.calculator.CalculatorV1;
import org.mlaptev.otus.calculator.CalculatorV2;
import org.mlaptev.otus.figure.Circle;
import org.mlaptev.otus.figure.FigureInterface;
import org.mlaptev.otus.figure.Square;
import org.mlaptev.otus.proxy.LogProxy;

public class Application {

  public static void main(String[] args) {

    System.out.println("Calculator");
    System.out.println("===== 1 =====");

    CalculatorInterface calculatorV1 =
        (CalculatorInterface) LogProxy.instanceOf(new CalculatorV1());

    System.out.println(calculatorV1.add(1, 2));
    System.out.println(calculatorV1.subtract(1, 2));
    System.out.println(calculatorV1.multiply(1, 2));

    System.out.println("===== 2 =====");

    CalculatorInterface calculatorV2 =
        (CalculatorInterface) LogProxy.instanceOf(new CalculatorV2());

    System.out.println(calculatorV2.add(2, 3));
    System.out.println(calculatorV2.subtract(2, 3));
    System.out.println(calculatorV2.multiply(2, 3));

    System.out.println("Figure");
    System.out.println("===== 1 =====");

    FigureInterface square =
        (FigureInterface) LogProxy.instanceOf(new Square(1.0));

    System.out.println(square.getArea());

    System.out.println("===== 2 =====");

    FigureInterface circle =
        (FigureInterface) LogProxy.instanceOf(new Circle(1.0));

    System.out.println(circle.getArea());
  }
}
