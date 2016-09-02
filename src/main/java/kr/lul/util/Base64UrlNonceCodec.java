/**
 * @see https://github.com/JustBurrow/common
 */
package kr.lul.util;

import static kr.lul.util.Asserts.hasLength;
import static kr.lul.util.Asserts.notNull;

import java.nio.charset.Charset;
import java.time.Instant;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.StringTokenizer;

/**
 * BASE64 URL 인코딩을 사용해 {@link Nonce}를 문자열로 인코딩, 디코딩한다.
 *
 * @author Just Burrow
 * @since 2016. 9. 2.
 */
public class Base64UrlNonceCodec implements NonceCodec {
  private static final String TOKEN_FORMAT = "%d:%d:%s";

  private Encoder             encoder      = Base64.getUrlEncoder();
  private Decoder             decoder      = Base64.getUrlDecoder();

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // <I>NonceCodec
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  /*
   * (non-Javadoc)
   * @author Just Burrow
   * @since 2016. 9. 2.
   */
  @Override
  public String encode(Nonce nonce) {
    notNull(nonce, "nonce");

    String source = String.format(TOKEN_FORMAT, nonce.getIssued().toEpochMilli(), nonce.getTtl(), nonce.getSign());
    String token = this.encoder.encodeToString(source.getBytes(Charset.forName("UTF-8")));

    return token;
  }

  /*
   * (non-Javadoc)
   * @author Just Burrow
   * @since 2016. 9. 2.
   */
  @Override
  public Nonce decode(String nonce) throws NonceDecodeException {
    hasLength(nonce, "nonce");

    try {
      String decoded = new String(this.decoder.decode(nonce));
      StringTokenizer st = new StringTokenizer(decoded, ":");
      Instant issued = Instant.ofEpochMilli(Long.parseLong(st.nextToken()));
      int ttl = Integer.parseInt(st.nextToken());
      return new Nonce(issued, ttl, st.nextToken());
    } catch (Exception e) {
      throw new NonceDecodeException(e, nonce);
    }
  }
}
