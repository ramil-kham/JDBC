package tech.itpark.project.exception;

public class UnsupportedContentTypeException extends RuntimeException {
  // Ctrl + O - выбрать все конструкторы из RuntimeException
  public UnsupportedContentTypeException() {
    super();
  }

  public UnsupportedContentTypeException(String message) {
    super(message);
  }

  public UnsupportedContentTypeException(String message, Throwable cause) {
    super(message, cause);
  }

  public UnsupportedContentTypeException(Throwable cause) {
    super(cause);
  }

  protected UnsupportedContentTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
