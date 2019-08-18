package org.mlaptev.otus.exceptions;

public class AtmException extends Exception {

  public AtmException() { }

  public AtmException(String message) {
    super(message);
  }

  public AtmException(String message, Throwable cause) {
    super(message, cause);
  }

  public AtmException(Throwable cause) {
    super(cause);
  }

  public AtmException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
