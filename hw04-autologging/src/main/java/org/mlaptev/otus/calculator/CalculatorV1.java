package org.mlaptev.otus.calculator;

public class CalculatorV1 implements CalculatorInterface {

  @Override
  public int add(int a, int b) {
    return a + b;
  }

  @Override
  public int subtract(int a, int b) {
    return a - b;
  }

  @Override
  public int multiply(int a, int b) {
    return a * b;
  }
}
