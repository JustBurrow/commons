/**
 * @see https://github.com/JustBurrow/common
 */
package kr.lul.common.util;

import static kr.lul.common.util.RandomUtil.R;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.Instant;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Just Burrow
 * @since 2016. 9. 1.
 */
public class NonceGeneratorTest {
  /**
   * 임의의 시각부터 임의의 시간동안 유효하고, 임의의 알고리즘으로 사인한 nonce를 만든다.
   *
   * @return
   * @author Just Burrow
   * @since 2016. 9. 2.
   */
  public static Nonce randomNonce() {
    Instant issued = Instant.ofEpochMilli(R.positiveLong());
    int ttl = R.positive();
    String sign = RandomStringUtils.random(40, "0123456789abcdef");
    return new Nonce(issued, ttl, sign);
  }

  private Instant        before;
  private NonceGenerator nonceGenerator;

  @Before
  public void setUp() throws Exception {
    this.before = Instant.now();
    TimeProvider tp = new SystemTimeProvider() {
      @Override
      public Instant now() {
        return NonceGeneratorTest.this.before;
      }
    };
    this.nonceGenerator = new NonceGenerator() {
      @Override
      public TimeProvider getTimeProvider() {
        return tp;
      }
    };
  }

  @Test
  public void testGenerateWithoutExtras() throws Exception {
    // Given
    final int ttl = R.positive();

    // When
    Nonce nonce = this.nonceGenerator.generate(ttl);

    // Then
    assertThat(nonce).isNotNull()
        .extracting(Nonce::getTtl).containsExactly(ttl);
    assertThat(nonce.getIssued()).isGreaterThanOrEqualTo(this.before);
    assertThat(nonce.getSign()).matches("[\\da-fA-F]{40}");
  }

  @Test
  public void testGenerateWithIllegalTtl() throws Exception {
    assertThatThrownBy(() -> this.nonceGenerator.generate(-1))
        .isInstanceOf(AssertionException.class)
        .hasMessage("ttl");
    assertThatThrownBy(() -> this.nonceGenerator.generate(0))
        .isInstanceOf(AssertionException.class)
        .hasMessage("ttl");
  }

  /**
   * nonce 발급 시각이 고정되어 있으므로, TTL이 같으면 같은 nonce가 생성됨을 확인한다.
   */
  @Test
  public void testGenerateForPredicte() throws Exception {
    // Given
    final int ttl = R.in(1, 100);
    final Nonce expected = this.nonceGenerator.generate(ttl);

    // When
    final Nonce actual = this.nonceGenerator.generate(ttl);

    // Then
    assertThat(actual).isNotNull()
        .isEqualTo(expected)
        .extracting(Nonce::getIssued, Nonce::getTtl, Nonce::getSign)
        .containsExactly(expected.getIssued(), expected.getTtl(), expected.getSign());
  }

  /**
   * TTL 변화로 다른 토큰 생성을 테스트한다.
   */
  @Test
  public void testGenerateForTtlImpact() throws Exception {
    // Given
    final int ttl = R.in(1, 10);
    final Nonce expected = this.nonceGenerator.generate(ttl);

    // When
    final Nonce actual = this.nonceGenerator.generate(ttl + 1);

    // Then
    assertThat(actual).isNotNull()
        .isNotEqualTo(expected)
        .extracting(Nonce::getIssued, Nonce::getTtl).containsExactly(expected.getIssued(), ttl + 1);
    assertThat(actual.getSign()).isNotEmpty()
        .isNotEqualTo(expected.getSign());
  }
}
