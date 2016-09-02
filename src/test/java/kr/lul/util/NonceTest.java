/**
 * @see https://github.com/JustBurrow/common
 */
package kr.lul.util;

import static kr.lul.test.AssertAction.assertThese;
import static kr.lul.util.RandomUtil.R;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.Instant;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

/**
 * @author Just Burrow
 * @since 2016. 9. 1.
 */
public class NonceTest {
  private TimeProvider timeProvider = new SystemTimeProvider();

  @Test
  public void testContructor() throws Exception {
    // Given
    final Instant now = this.timeProvider.now();
    final int ttl = R.in(1, 300);
    final String token = RandomStringUtils.random(R.in(10, 20), NonceTestSuite.HEX_CHARACTERS);

    // When
    Nonce nonce = new Nonce(now, ttl, token);

    // Then
    assertThat(nonce).isNotNull()
        .extracting(Nonce::getIssued, Nonce::getTtl, Nonce::getSign).containsExactly(now, ttl, token);
  }

  @Test
  public void testConstructorWithNullInstant() throws Exception {
    assertThatThrownBy(() -> new Nonce(null, 1, RandomStringUtils.random(R.in(10, 20))))
        .isInstanceOf(AssertionException.class)
        .hasMessageContaining("issued");
  }

  @Test
  public void testConstructorWith0Ttl() throws Exception {
    assertThatThrownBy(() -> new Nonce(this.timeProvider.now(), 0, RandomStringUtils.random(R.in(5, 20))))
        .isInstanceOf(AssertionException.class).hasMessage("ttl");
  }

  @Test
  public void testConstructorWithIllegalToken() throws Exception {
    assertThese((callable) -> assertThatThrownBy(callable)
        .isInstanceOf(AssertionException.class)
        .hasMessage("sign"),
        () -> new Nonce(this.timeProvider.now(), R.in(1, 10), null),
        () -> new Nonce(this.timeProvider.now(), R.in(1, 10), ""));
  }
}
