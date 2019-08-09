package org.mlaptev.otus.exceptions;

public class CurrencyNotSupportedException extends AtmException {

  public CurrencyNotSupportedException(String message) {
    super(message);
  }
}