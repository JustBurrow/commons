/**
 * @see https://github.com/JustBurrow/common
 */
package kr.lul.common.util;

import java.nio.charset.Charset;
import java.time.Instant;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 해시 함수를 사용해 nonce를 생성는 유틸리티.
 *
 * @author Just Burrow
 * @since 2016. 9. 1.
 */
public interface NonceGenerator {
  public static final String DELIMITER = ":";

  /**
   * nonce 발행 시각을 제공할 시각 정보.
   *
   * @return
   * @author Just Burrow
   * @since 2016. 9. 1.
   */
  public TimeProvider getTimeProvider();

  /**
   * @param ttl
   *          nonce의 유효시간. seconds.
   * @param extras
   *          해시 생성용 추가 데이터.
   * @return
   * @author Just Burrow
   * @since 2016. 9. 1.
   */
  default public Nonce generate(int ttl, Object... extras) {
    Instant now = getTimeProvider().now();

    StringBuilder sb = new StringBuilder(now.toEpochMilli() + DELIMITER).append(ttl);
    for (Object extra : extras) {
      sb.append(DELIMITER).append(extra);
    }

    String token = DigestUtils.sha1Hex(sb.toString().getBytes(Charset.forName("UTF-8")));
    return new Nonce(now, ttl, token);
  }
}
