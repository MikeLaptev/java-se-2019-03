package org.mlaptev.otus.exceptions;

public class InvalidWithdrawApproachException extends AtmException {

  public InvalidWithdrawApproachException(String message) {
    super(message);
  }

  public InvalidWithdrawApproachException(String message, Throwable cause) {
    super(message, cause);
  }
}
