package org.mlaptev.otus;

import org.mlaptev.otus.proxy.LogProxy;

public class Application {

  public static void main(String[] args) {
    CalculatorInterface calculator = (CalculatorInterface) LogProxy.newInstance(new Calculator());

    System.out.println(calculator.add(1, 2));
    System.out.println(calculator.subtract(1, 2));
    System.out.println(calculator.multiply(1, 2));
  }
}
