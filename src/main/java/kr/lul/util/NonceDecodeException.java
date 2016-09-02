/**
 * @see https://github.com/JustBurrow/common
 */
package kr.lul.util;

/**
 * @author Just Burrow
 * @since 2016. 9. 2.
 */
public class NonceDecodeException extends Exception {
  /**
   * @author Just Burrow
   * @since 2016. 9. 2.
   */
  private static final long serialVersionUID = PackageConstants.SERIAL_VERSION_UID;

  private String            nonce;

  /**
   * @author Just Burrow
   * @since 2016. 9. 2.
   * @param message
   *          디코딩 에러 메시지.
   * @param nonce
   *          디코딩에 실패한 문자열.
   */
  public NonceDecodeException(String message, String nonce) {
    super(message);
    this.nonce = nonce;
  }

  /**
   * @author Just Burrow
   * @since 2016. 9. 2.
   * @param cause
   * @param nonce
   */
  public NonceDecodeException(Throwable cause, String nonce) {
    super(cause);
    this.nonce = nonce;
  }

  /**
   * @return
   * @author Just Burrow
   * @since 2016. 9. 2.
   */
  public String getNonce() {
    return this.nonce;
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Object
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  /*
   * (non-Javadoc)
   * @author Just Burrow
   * @since 2016. 9. 2.
   */
  @Override
  public String toString() {
    return String.format("%s : nonce=%s", super.toString(), this.nonce);
  }
}
