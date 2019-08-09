package org.mlaptev.otus.calculator;

public class CalculatorV2 implements CalculatorInterface {

  public int add(int a, int b) {
    return -(a + b);
  }

  public int subtract(int a, int b) {
    return -(a - b);
  }

  public int multiply(int a, int b) {
    return -(a * b);
  }
}
