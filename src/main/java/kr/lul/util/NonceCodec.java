/**
 * @see https://github.com/JustBurrow/common
 */
package kr.lul.util;

/**
 * {@link Nonce}를 문자열로 상호 변환하는 도구.
 *
 * @author Just Burrow
 * @since 2016. 9. 2.
 */
public interface NonceCodec {
  /**
   * nonce 인스턴스를 문자열로 인코딩한다.
   *
   * @param nonce
   *          인코딩할 nonce.
   * @return 인코딩된 nonce 문자열.
   * @author Just Burrow
   * @since 2016. 9. 2.
   */
  public String encode(Nonce nonce);

  /**
   * nonce 문자열을 객체로 디코딩한다.
   *
   * @param nonce
   *          인코딩된 nonce 문자열.
   * @return 디코딩한 nonce.
   * @throws NonceDecodeException
   *           디코딩 실패시.
   * @author Just Burrow
   * @since 2016. 9. 2.
   */
  public Nonce decode(String nonce) throws NonceDecodeException;
}
