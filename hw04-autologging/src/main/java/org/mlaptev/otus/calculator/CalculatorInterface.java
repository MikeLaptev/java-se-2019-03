package org.mlaptev.otus.calculator;

import org.mlaptev.otus.annotations.Log;

public interface CalculatorInterface {

  int add(int a, int b);

  @Log
  int subtract(int a, int b);

  int multiply(int a, int b);
}
