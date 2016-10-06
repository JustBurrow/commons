/**
 * @see https://github.com/JustBurrow/common
 */
package kr.lul.common.util;

import static kr.lul.common.util.RandomUtil.R;
import static org.assertj.core.api.Assertions.assertThat;

import java.nio.charset.Charset;
import java.time.Instant;
import java.util.Base64;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Just Burrow
 * @since 2016. 9. 2.
 */
public class Base64UrlNonceCodecTest {
  private NonceCodec codec;

  @Before
  public void setUp() throws Exception {
    this.codec = new Base64UrlNonceCodec();
  }

  @Test
  public void testEncode() throws Exception {
    // Given
    final Nonce nonce = NonceGeneratorTest.randomNonce();

    // When
    final String token = this.codec.encode(nonce);

    // Then
    assertThat(token).isNotEmpty();
    assertThat(new String(Base64.getDecoder().decode(token), Charset.forName("UTF-8")))
        .matches("\\d+\\:\\d+\\:[\\da-fA-F]+");
  }

  @Test
  public void testDecode() throws Exception {
    // Given
    final Instant issued = Instant.now();
    final int ttl = R.positive();
    final String sign = RandomStringUtils.random(R.in(10, 30), NonceTestSuite.HEX_CHARACTERS);
    final String nonce = Base64.getUrlEncoder()
        .encodeToString(String.format("%d:%d:%s", issued.toEpochMilli(), ttl, sign)
            .getBytes(Charset.forName("UTF-8")));

    // When
    Nonce decoded = this.codec.decode(nonce);

    // Then
    assertThat(decoded).isNotNull()
        .extracting(Nonce::getIssued, Nonce::getTtl, Nonce::getSign)
        .containsExactly(issued, ttl, sign);
  }

  @Test
  public void testViceVersa() throws Exception {
    // Given
    final Nonce expected = NonceGeneratorTest.randomNonce();

    // When
    final Nonce actual = this.codec.decode(this.codec.encode(expected));

    // Then
    assertThat(actual).isNotNull()
        .isNotSameAs(expected)
        .isEqualTo(expected);
  }
}
