/**
 * @see https://github.com/JustBurrow/common
 */
package kr.lul.util;

import static kr.lul.util.Asserts.hasLength;
import static kr.lul.util.Asserts.matches;
import static kr.lul.util.Asserts.notNull;
import static kr.lul.util.Asserts.positive;

import java.time.Instant;
import java.util.Objects;

/**
 * 시간 정보를 기반으로 생성하는 1회용 문자열.
 *
 * @author Just Burrow
 * @since 2016. 9. 1.
 */
public class Nonce {
  private Instant issued;
  private int     ttl;
  private String  sign;

  /**
   * @author Just Burrow
   * @since 2016. 9. 1.
   * @param issued
   *          nonce 발행 시각.
   * @param ttl
   *          nonce 유효기간. seconds.
   * @param sign
   *          HEX 문자열.
   */
  public Nonce(Instant issued, int ttl, String sign) {
    notNull(issued, "issued");
    positive(ttl, "ttl");
    hasLength(sign, "sign");
    matches(sign, "[\\da-fA-F]+", "sign");

    this.issued = issued;
    this.ttl = ttl;
    this.sign = sign;
  }

  /**
   * @return 발급 시각.
   * @author Just Burrow
   * @since 2016. 9. 2.
   */
  public Instant getIssued() {
    return this.issued;
  }

  /**
   * @return 유효기간(초, seconds, 秒).
   * @author Just Burrow
   * @since 2016. 9. 2.
   */
  public int getTtl() {
    return this.ttl;
  }

  /**
   * @return 검증용 사인.
   * @author Just Burrow
   * @since 2016. 9. 2.
   */
  public String getSign() {
    return this.sign;
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Object
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  /*
   * (non-Javadoc)
   * @author Just Burrow
   * @since 2016. 9. 1.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.issued, this.ttl, this.sign);
  }

  /*
   * (non-Javadoc)
   * @author Just Burrow
   * @since 2016. 9. 1.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    } else if (null != obj && obj instanceof Nonce) {
      Nonce that = (Nonce) obj;
      return this.issued.equals(that.issued)
          && this.ttl == that.ttl
          && this.sign.equals(that.sign);
    } else {
      return false;
    }
  }

  /*
   * (non-Javadoc)
   * @author Just Burrow
   * @since 2016. 9. 1.
   */
  @Override
  public String toString() {
    return String.format("[issued=%s, ttl=%d, token=%s]", this.issued, this.ttl, this.sign);
  }
}
