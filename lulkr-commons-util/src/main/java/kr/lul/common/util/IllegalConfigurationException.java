/**
 */
package kr.lul.common.util;

/**
 * 설정이 잘못된 경우 발생하는 예외.
 *
 * @author Just Burrow
 * @since 2016. 10. 19.
 */
public class IllegalConfigurationException extends RuntimeException {
  /**
   * @author Just Burrow
   * @since 2016. 10. 19.
   */
  private static final long  serialVersionUID = PackageConstants.SERIAL_VERSION_UID;

  public static final String UNKNOWN_PROPERTY = "[UNKNOWN]";

  private String             property;

  /**
   * @author Just Burrow
   * @since 2016. 10. 19.
   * @param message
   * @param cause
   */
  public IllegalConfigurationException(String message, Throwable cause) {
    super(message, cause);
    this.property = UNKNOWN_PROPERTY;
  }

  /**
   * @author Just Burrow
   * @since 2016. 10. 19.
   * @param message
   */
  public IllegalConfigurationException(String message) {
    super(message);
    this.property = UNKNOWN_PROPERTY;
  }

  /**
   * @author Just Burrow
   * @since 2016. 10. 19.
   * @param cause
   */
  public IllegalConfigurationException(Throwable cause) {
    super(cause);
    this.property = UNKNOWN_PROPERTY;
  }

  /**
   * @author Just Burrow
   * @since 2016. 10. 19.
   * @param message
   * @param cause
   * @param property
   *          설정 이름.
   */
  public IllegalConfigurationException(String message, Throwable cause, String property) {
    super(message, cause);
    this.property = property;
  }

  /**
   * @author Just Burrow
   * @since 2016. 10. 19.
   * @param message
   * @param property
   *          설정 이름.
   */
  public IllegalConfigurationException(String message, String property) {
    super(message);
    this.property = property;
  }

  /**
   * @author Just Burrow
   * @since 2016. 10. 19.
   * @param cause
   * @param property
   *          설정 이름.
   */
  public IllegalConfigurationException(Throwable cause, String property) {
    super(cause);
    this.property = property;
  }

  /**
   * @return 설정이 잘못된 설정의 이름.
   * @author Just Burrow
   * @since 2016. 10. 19.
   */
  public String getProperty() {
    return this.property;
  }
}
