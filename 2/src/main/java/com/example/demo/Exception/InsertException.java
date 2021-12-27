package com.example.demo.Exception;

public class InsertException extends ServiceException {

  private static final long serialVersionUID = 7991875652328476596L;

  public InsertException() {
    super();
  }

  public InsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public InsertException(String message, Throwable cause) {
    super(message, cause);
  }

  public InsertException(String message) {
    super(message);
  }

  public InsertException(Throwable cause) {
    super(cause);
  }

}
