package org.mlaptev.otus;

import org.mlaptev.otus.annotations.Log;

public interface CalculatorInterface {

  @Log
  int add(int a, int b);

  @Log
  int subtract(int a, int b);

  int multiply(int a, int b);
}
