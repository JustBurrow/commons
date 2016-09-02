package kr.lul.util;

import static java.util.Arrays.asList;
import static kr.lul.util.Asserts.assignable;
import static kr.lul.util.Asserts.ge;
import static kr.lul.util.Asserts.gt;
import static kr.lul.util.Asserts.hasLength;
import static kr.lul.util.Asserts.in;
import static kr.lul.util.Asserts.isNull;
import static kr.lul.util.Asserts.le;
import static kr.lul.util.Asserts.length;
import static kr.lul.util.Asserts.longer;
import static kr.lul.util.Asserts.lt;
import static kr.lul.util.Asserts.matches;
import static kr.lul.util.Asserts.negative;
import static kr.lul.util.Asserts.notNegative;
import static kr.lul.util.Asserts.notNull;
import static kr.lul.util.Asserts.notPositive;
import static kr.lul.util.Asserts.positive;
import static kr.lul.util.Asserts.shorter;
import static kr.lul.util.Asserts.zero;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.Instant;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.Test;

/**
 * {@link Asserts} 테스트.
 *
 * @author just.burrow@lul.kr
 * @since 2016. 8. 3.
 */
public class AssertsTest {
  /**
   * 콜백 실행히 지정한 예외가 발생함을 확인한다.
   *
   * @param e
   * @param callables
   * @author just.burrow@lul.kr
   * @since 2016. 8. 2.
   */
  public static void assertThrowingCallables(Class<? extends Throwable> e, ThrowingCallable... callables) {
    notNull(e, "e");
    notNull(callables, "callables");

    asList(callables).forEach(c -> assertThatThrownBy(c).isInstanceOf(e));
  }

  /**
   * 콜백 실행히 지정한 예외가 발생하고, 예외가 지정한 메시지를 가지고 있는지 확인한다.
   *
   * @param e
   * @param message
   * @param callables
   * @author just.burrow@lul.kr
   * @since 2016. 8. 2.
   */
  public static void assertThrowingCallables(Class<? extends Throwable> e, String message,
      ThrowingCallable... callables) {
    notNull(e, "e");
    notNull(message, "message");
    notNull(callables, "callables");

    asList(callables).forEach(c -> assertThatThrownBy(c)
        .isInstanceOf(e)
        .hasMessage(message));
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  @Test(expected = UnsupportedOperationException.class)
  public void test() {
    new Asserts() {
    };
  }

  @Test
  public void testNegative() throws Exception {
    final String message = "expected message@" + Instant.now();

    negative((byte) -1);
    negative((short) -1);
    negative(-1);
    negative(-1L);
    negative(-0.1F);
    negative(-0.1);

    negative((byte) -1, null);
    negative((short) -1, null);
    negative(-1, null);
    negative(-1L, null);
    negative(-0.1F, null);
    negative(-0.1, null);

    negative((byte) -1, message);
    negative((short) -1, message);
    negative(-1, message);
    negative(-1L, message);
    negative(-0.1F, message);
    negative(-0.1, message);

    assertThrowingCallables(AssertionException.class,
        () -> negative((byte) 0),
        () -> negative((short) 0),
        () -> negative(0),
        () -> negative(0L),
        () -> negative(0.0F),
        () -> negative(0.0));
    assertThrowingCallables(AssertionException.class, message,
        () -> negative((byte) 0, message),
        () -> negative((short) 0, message),
        () -> negative(0, message),
        () -> negative(0L, message),
        () -> negative(0.0F, message),
        () -> negative(0.0, message));

    assertThrowingCallables(AssertionException.class,
        () -> negative((byte) 1),
        () -> negative((short) 1),
        () -> negative(1),
        () -> negative(1L),
        () -> negative(0.1F),
        () -> negative(0.1));
    assertThrowingCallables(AssertionException.class, message,
        () -> negative((byte) 1, message),
        () -> negative((short) 1, message),
        () -> negative(1, message),
        () -> negative(1L, message),
        () -> negative(0.1F, message),
        () -> negative(0.1, message));
  }

  @Test
  public void testZero() throws Exception {
    final String message = "expected message@" + Instant.now();

    assertThrowingCallables(AssertionException.class,
        () -> zero((byte) -1),
        () -> zero((short) -1),
        () -> zero(-1),
        () -> zero(-1L),
        () -> zero(-1.0F),
        () -> zero(-1.0));

    assertThrowingCallables(AssertionException.class, message,
        () -> zero((byte) -1, message),
        () -> zero((short) -1, message),
        () -> zero(-1, message),
        () -> zero(-1L, message),
        () -> zero(-1.0F, message),
        () -> zero(-1.0, message));

    zero((byte) 0);
    zero((short) 0);
    zero(0);
    zero(0L);
    zero(0.0F);
    zero(0.0);

    zero((byte) 0, null);
    zero((short) 0, null);
    zero(0, null);
    zero(0L, null);
    zero(0.0F, null);
    zero(0.0, null);

    zero((byte) 0, message);
    zero((short) 0, message);
    zero(0, message);
    zero(0L, message);
    zero(0.0F, message);
    zero(0.0, message);

    assertThrowingCallables(AssertionException.class,
        () -> zero((byte) 1),
        () -> zero((short) 1),
        () -> zero(1),
        () -> zero(1L),
        () -> zero(1.0F),
        () -> zero(1.0));

    assertThrowingCallables(AssertionException.class, message,
        () -> zero((byte) 1, message),
        () -> zero((short) 1, message),
        () -> zero(1, message),
        () -> zero(1L, message),
        () -> zero(1.0F, message),
        () -> zero(1.0, message));
  }

  @Test
  public void testPositive() throws Exception {
    final String message = "expected message@" + Instant.now();

    assertThrowingCallables(AssertionException.class,
        () -> positive((byte) -1),
        () -> positive((short) -1),
        () -> positive(-1),
        () -> positive(-1L),
        () -> positive(-1.0F),
        () -> positive(-1.0));

    assertThrowingCallables(AssertionException.class, message,
        () -> positive((byte) -1, message),
        () -> positive((short) -1, message),
        () -> positive(-1, message),
        () -> positive(-1L, message),
        () -> positive(-1.0F, message),
        () -> positive(-1.0, message));

    assertThrowingCallables(AssertionException.class,
        () -> positive((byte) 0),
        () -> positive((short) 0),
        () -> positive(0),
        () -> positive(0L),
        () -> positive(0.0F),
        () -> positive(0.0));

    assertThrowingCallables(AssertionException.class, message,
        () -> positive((byte) 0, message),
        () -> positive((short) 0, message),
        () -> positive(0, message),
        () -> positive(0L, message),
        () -> positive(0.0F, message),
        () -> positive(0.0, message));

    positive((byte) 1);
    positive((short) 1);
    positive(1);
    positive(1L);
    positive(0.1F);
    positive(0.1);

    positive((byte) 1, null);
    positive((short) 1, null);
    positive(1, null);
    positive(1L, null);
    positive(0.1F, null);
    positive(0.1, null);

    positive((byte) 1, message);
    positive((short) 1, message);
    positive(1, message);
    positive(1L, message);
    positive(0.1F, message);
    positive(0.1, message);
  }

  @Test
  public void testNotNegative() throws Exception {
    final String message = "expected message@" + Instant.now();

    assertThrowingCallables(AssertionException.class,
        () -> notNegative((byte) -1),
        () -> notNegative((short) -1),
        () -> notNegative(-1),
        () -> notNegative(-1L),
        () -> notNegative(-1.0F),
        () -> notNegative(-1.0));

    assertThrowingCallables(AssertionException.class, message,
        () -> notNegative((byte) -1, message),
        () -> notNegative((short) -1, message),
        () -> notNegative(-1, message),
        () -> notNegative(-1L, message),
        () -> notNegative(-1.0F, message),
        () -> notNegative(-1.0, message));

    notNegative((byte) 0);
    notNegative((short) 0);
    notNegative(0);
    notNegative(0L);
    notNegative(0.0F);
    notNegative(0.0);

    notNegative((byte) 0, null);
    notNegative((short) 0, null);
    notNegative(0, null);
    notNegative(0L, null);
    notNegative(0.0F, null);
    notNegative(0.0, null);

    notNegative((byte) 0, message);
    notNegative((short) 0, message);
    notNegative(0, message);
    notNegative(0L, message);
    notNegative(0.0F, message);
    notNegative(0.0, message);

    notNegative((byte) 1);
    notNegative((short) 1);
    notNegative(1);
    notNegative(1L);
    notNegative(0.1F);
    notNegative(0.1);

    notNegative((byte) 1, null);
    notNegative((short) 1, null);
    notNegative(1, null);
    notNegative(1L, null);
    notNegative(0.1F, null);
    notNegative(0.1, null);

    notNegative((byte) 1, message);
    notNegative((short) 1, message);
    notNegative(1, message);
    notNegative(1L, message);
    notNegative(0.1F, message);
    notNegative(0.1, message);
  }

  @Test
  public void testNotPositive() throws Exception {
    final String message = "expected message@" + Instant.now();

    notPositive((byte) -1);
    notPositive((short) -1);
    notPositive(-1);
    notPositive(-1L);
    notPositive(-0.1F);
    notPositive(-0.1);

    notPositive((byte) -1, null);
    notPositive((short) -1, null);
    notPositive(-1, null);
    notPositive(-1L, null);
    notPositive(-0.1F, null);
    notPositive(-0.1, null);

    notPositive((byte) -1, message);
    notPositive((short) -1, message);
    notPositive(-1, message);
    notPositive(-1L, message);
    notPositive(-0.1F, message);
    notPositive(-0.1, message);

    notPositive((byte) 0);
    notPositive((short) 0);
    notPositive(0);
    notPositive(0L);
    notPositive(0.0F);
    notPositive(0.0);

    notPositive((byte) 0, null);
    notPositive((short) 0, null);
    notPositive(0, null);
    notPositive(0L, null);
    notPositive(0.0F, null);
    notPositive(0.0, null);

    notPositive((byte) 0, message);
    notPositive((short) 0, message);
    notPositive(0, message);
    notPositive(0L, message);
    notPositive(0.0F, message);
    notPositive(0.0, message);

    assertThrowingCallables(AssertionException.class,
        () -> notPositive((byte) 1),
        () -> notPositive((short) 1),
        () -> notPositive(1),
        () -> notPositive(1L),
        () -> notPositive(1.0F),
        () -> notPositive(1.0));

    assertThrowingCallables(AssertionException.class, message,
        () -> notPositive((byte) 1, message),
        () -> notPositive((short) 1, message),
        () -> notPositive(1, message),
        () -> notPositive(1L, message),
        () -> notPositive(1.0F, message),
        () -> notPositive(1.0, message));
  }

  @Test
  public void testInForException() throws Exception {
    assertThrowingCallables(IllegalArgumentException.class,
        () -> in((byte) 0, (byte) 0, (byte) 0),
        () -> in((short) 0, (short) 0, (short) 0),
        () -> in(0, 0, 0),
        () -> in(0L, 0L, 0L),
        () -> in(0.0F, 0.0F, 0.0F),
        () -> in(0.0, 0.0, 0.0),

        () -> in((byte) -1, (byte) 0, (byte) -1),
        () -> in((short) -1, (short) 0, (short) -1),
        () -> in(-1, 0, -1),
        () -> in(-1L, 0L, -1L),
        () -> in(-1.0F, 0.0F, -1.0F),
        () -> in(-1.0, 0.0, -1.0),

        () -> in((byte) 0, (byte) 0, (byte) -1),
        () -> in((short) 0, (short) 0, (short) -1),
        () -> in(0, 0, -1),
        () -> in(0L, 0L, -1L),
        () -> in(0.0F, 0.0F, -1.0F),
        () -> in(0.0, 0.0, -1.0));
  }

  @Test
  public void testIn() throws Exception {
    final String message = "expected message@" + Instant.now();

    assertThrowingCallables(AssertionException.class,
        () -> in((byte) -1, (byte) 0, (byte) 1),
        () -> in((short) -1, (short) 0, (short) 1),
        () -> in(-1, 0, 1),
        () -> in(-1L, 0L, 1L),
        () -> in(-1.0F, 0.0F, 1.0F),
        () -> in(-1.0, 0.0, 1.0));

    assertThrowingCallables(AssertionException.class, message,
        () -> in((byte) -1, (byte) 0, (byte) 1, message),
        () -> in((short) -1, (short) 0, (short) 1, message),
        () -> in(-1, 0, 1, message),
        () -> in(-1L, 0L, 1L, message),
        () -> in(-1.0F, 0.0F, 1.0F, message),
        () -> in(-1.0, 0.0, 1.0, message));

    in((byte) 0, (byte) 0, (byte) 2);
    in((short) 0, (short) 0, (short) 2);
    in(0, 0, 2);
    in(0L, 0L, 2L);
    in(0.0F, 0.0F, 2.0F);
    in(0.0, 0.0, 2.0);

    in((byte) 0, (byte) 0, (byte) 2, null);
    in((short) 0, (short) 0, (short) 2, null);
    in(0, 0, 2, null);
    in(0L, 0L, 2L, null);
    in(0.0F, 0.0F, 2.0F, null);
    in(0.0, 0.0, 2.0, null);

    in((byte) 0, (byte) 0, (byte) 2, message);
    in((short) 0, (short) 0, (short) 2, message);
    in(0, 0, 2, message);
    in(0L, 0L, 2L, message);
    in(0.0F, 0.0F, 2.0F, message);
    in(0.0, 0.0, 2.0, message);

    in((byte) 1, (byte) 0, (byte) 2);
    in((short) 1, (short) 0, (short) 2);
    in(1, 0, 2);
    in(1L, 0L, 2L);
    in(1.0F, 0.0F, 2.0F);
    in(1.0, 0.0, 2.0);

    in((byte) 1, (byte) 0, (byte) 2, null);
    in((short) 1, (short) 0, (short) 2, null);
    in(1, 0, 2, null);
    in(1L, 0L, 2L, null);
    in(1.0F, 0.0F, 2.0F, null);
    in(1.0, 0.0, 2.0, null);

    in((byte) 1, (byte) 0, (byte) 2, message);
    in((short) 1, (short) 0, (short) 2, message);
    in(1, 0, 2, message);
    in(1L, 0L, 2L, message);
    in(1.0F, 0.0F, 2.0F, message);
    in(1.0, 0.0, 2.0, message);

    assertThrowingCallables(AssertionException.class,
        () -> in((byte) 2, (byte) 0, (byte) 2),
        () -> in((short) 2, (short) 0, (short) 2),
        () -> in(2, 0, 2),
        () -> in(2L, 0L, 2L),
        () -> in(2.0F, 0.0F, 2.0F),
        () -> in(2.0, 0.0, 2.0));

    assertThrowingCallables(AssertionException.class, message,
        () -> in((byte) 2, (byte) 0, (byte) 2, message),
        () -> in((short) 2, (short) 0, (short) 2, message),
        () -> in(2, 0, 2, message),
        () -> in(2L, 0L, 2L, message),
        () -> in(2.0F, 0.0F, 2.0F, message),
        () -> in(2.0, 0.0, 2.0, message));
  }

  @Test
  public void testLt() throws Exception {
    final String message = "expected message@" + Instant.now();

    lt((byte) -1, (byte) 0);
    lt((short) -1, (short) 0);
    lt(-1, 0);
    lt(-1L, 0L);
    lt(-1.0F, 0.0F);
    lt(-1.0, 0.0);

    lt((byte) -1, (byte) 0, null);
    lt((short) -1, (short) 0, null);
    lt(-1, 0, null);
    lt(-1L, 0L, null);
    lt(-1.0F, 0.0F, null);
    lt(-1.0, 0.0, null);

    lt((byte) -1, (byte) 0, message);
    lt((short) -1, (short) 0, message);
    lt(-1, 0, message);
    lt(-1L, 0L, message);
    lt(-1.0F, 0.0F, message);
    lt(-1.0, 0.0, message);

    assertThrowingCallables(AssertionException.class,
        () -> lt((byte) 0, (byte) 0),
        () -> lt((short) 0, (short) 0),
        () -> lt(0, 0),
        () -> lt(0L, 0L),
        () -> lt(0.0F, 0.0F),
        () -> lt(0.0, 0.0));

    assertThrowingCallables(AssertionException.class, message,
        () -> lt((byte) 0, (byte) 0, message),
        () -> lt((short) 0, (short) 0, message),
        () -> lt(0, 0, message),
        () -> lt(0L, 0L, message),
        () -> lt(0.0F, 0.0F, message),
        () -> lt(0.0, 0.0, message));

    assertThrowingCallables(AssertionException.class,
        () -> lt((byte) 1, (byte) 0),
        () -> lt((short) 1, (short) 0),
        () -> lt(1, 0),
        () -> lt(1L, 0L),
        () -> lt(1.0F, 0.0F),
        () -> lt(1.0, 0.0));

    assertThrowingCallables(AssertionException.class, message,
        () -> lt((byte) 1, (byte) 0, message),
        () -> lt((short) 1, (short) 0, message),
        () -> lt(1, 0, message),
        () -> lt(1L, 0L, message),
        () -> lt(1.0F, 0.0F, message),
        () -> lt(1.0, 0.0, message));
  }

  @Test
  public void testLe() throws Exception {
    final String message = "expected message@" + Instant.now();

    le((byte) -1, (byte) 0);
    le((short) -1, (short) 0);
    le(-1, 0);
    le(-1L, 0L);
    le(-1.0F, 0.0F);
    le(-1.0, 0.0);

    le((byte) -1, (byte) 0, null);
    le((short) -1, (short) 0, null);
    le(-1, 0, null);
    le(-1L, 0L, null);
    le(-1.0F, 0.0F, null);
    le(-1.0, 0.0, null);

    le((byte) -1, (byte) 0, message);
    le((short) -1, (short) 0, message);
    le(-1, 0, message);
    le(-1L, 0L, message);
    le(-1.0F, 0.0F, message);
    le(-1.0, 0.0, message);

    le((byte) 0, (byte) 0);
    le((short) 0, (short) 0);
    le(0, 0);
    le(0L, 0L);
    le(0.0F, 0.0F);
    le(0.0, 0.0);

    le((byte) 0, (byte) 0, null);
    le((short) 0, (short) 0, null);
    le(0, 0, null);
    le(0L, 0L, null);
    le(0.0F, 0.0F, null);
    le(0.0, 0.0, null);

    le((byte) 0, (byte) 0, message);
    le((short) 0, (short) 0, message);
    le(0, 0, message);
    le(0L, 0L, message);
    le(0.0F, 0.0F, message);
    le(0.0, 0.0, message);

    assertThrowingCallables(AssertionException.class,
        () -> le((short) 1, (short) 0),
        () -> le((byte) 1, (byte) 0),
        () -> le(1, 0),
        () -> le(1L, 0L),
        () -> le(1.0F, 0.0F),
        () -> le(1.0, 0.0));

    assertThrowingCallables(AssertionException.class, message,
        () -> le((short) 1, (short) 0, message),
        () -> le((byte) 1, (byte) 0, message),
        () -> le(1, 0, message),
        () -> le(1L, 0L, message),
        () -> le(1.0F, 0.0F, message),
        () -> le(1.0, 0.0, message));
  }

  @Test
  public void testGt() throws Exception {
    final String message = "expected message@" + Instant.now();

    assertThrowingCallables(AssertionException.class,
        () -> gt((short) -1, (short) 0),
        () -> gt((byte) -1, (byte) 0),
        () -> gt(-1, 0),
        () -> gt(-1L, 0L),
        () -> gt(-1.0F, 0.0F),
        () -> gt(-1.0, 0.0));

    assertThrowingCallables(AssertionException.class, message,
        () -> gt((short) -1, (short) 0, message),
        () -> gt((byte) -1, (byte) 0, message),
        () -> gt(-1, 0, message),
        () -> gt(-1L, 0L, message),
        () -> gt(-1.0F, 0.0F, message),
        () -> gt(-1.0, 0.0, message));

    assertThrowingCallables(AssertionException.class,
        () -> gt((short) 0, (short) 0),
        () -> gt((byte) 0, (byte) 0),
        () -> gt(0, 0),
        () -> gt(0L, 0L),
        () -> gt(0.0F, 0.0F),
        () -> gt(0.0, 0.0));

    assertThrowingCallables(AssertionException.class, message,
        () -> gt((short) 0, (short) 0, message),
        () -> gt((byte) 0, (byte) 0, message),
        () -> gt(0, 0, message),
        () -> gt(0L, 0L, message),
        () -> gt(0.0F, 0.0F, message),
        () -> gt(0.0, 0.0, message));

    gt((byte) 1, (byte) 0);
    gt((short) 1, (short) 0);
    gt(1, 0);
    gt(1L, 0L);
    gt(1.0F, 0.0F);
    gt(1.0, 0.0);

    gt((byte) 1, (byte) 0, null);
    gt((short) 1, (short) 0, null);
    gt(1, 0, null);
    gt(1L, 0L, null);
    gt(1.0F, 0.0F, null);
    gt(1.0, 0.0, null);

    gt((byte) 1, (byte) 0, message);
    gt((short) 1, (short) 0, message);
    gt(1, 0, message);
    gt(1L, 0L, message);
    gt(1.0F, 0.0F, message);
    gt(1.0, 0.0, message);
  }

  @Test
  public void testGe() throws Exception {
    final String message = "expected message@" + Instant.now();

    assertThrowingCallables(AssertionException.class,
        () -> ge((short) -1, (short) 0),
        () -> ge((byte) -1, (byte) 0),
        () -> ge(-1, 0),
        () -> ge(-1L, 0L),
        () -> ge(-1.0F, 0.0F),
        () -> ge(-1.0, 0.0));

    assertThrowingCallables(AssertionException.class, message,
        () -> ge((short) -1, (short) 0, message),
        () -> ge((byte) -1, (byte) 0, message),
        () -> ge(-1, 0, message),
        () -> ge(-1L, 0L, message),
        () -> ge(-1.0F, 0.0F, message),
        () -> ge(-1.0, 0.0, message));

    ge((byte) 0, (byte) 0);
    ge((short) 0, (short) 0);
    ge(0, 0);
    ge(0L, 0L);
    ge(0.0F, 0.0F);
    ge(0.0, 0.0);

    ge((byte) 0, (byte) 0, null);
    ge((short) 0, (short) 0, null);
    ge(0, 0, null);
    ge(0L, 0L, null);
    ge(0.0F, 0.0F, null);
    ge(0.0, 0.0, null);

    ge((byte) 0, (byte) 0, message);
    ge((short) 0, (short) 0, message);
    ge(0, 0, message);
    ge(0L, 0L, message);
    ge(0.0F, 0.0F, message);
    ge(0.0, 0.0, message);

    ge((byte) 1, (byte) 0);
    ge((short) 1, (short) 0);
    ge(1, 0);
    ge(1L, 0L);
    ge(1.0F, 0.0F);
    ge(1.0, 0.0);

    ge((byte) 1, (byte) 0, null);
    ge((short) 1, (short) 0, null);
    ge(1, 0, null);
    ge(1L, 0L, null);
    ge(1.0F, 0.0F, null);
    ge(1.0, 0.0, null);

    ge((byte) 1, (byte) 0, message);
    ge((short) 1, (short) 0, message);
    ge(1, 0, message);
    ge(1L, 0L, message);
    ge(1.0F, 0.0F, message);
    ge(1.0, 0.0, message);
  }

  @Test
  public void testIsNull() throws Exception {
    final String message = "expected message@" + Instant.now();

    isNull(null);
    isNull(null, null);
    isNull(null, message);

    assertThrowingCallables(AssertionException.class, () -> isNull(new Object()));
    assertThrowingCallables(AssertionException.class, message, () -> isNull(new Object(), message));
  }

  @Test
  public void testNotNull() throws Exception {
    final String message = "expected message@" + Instant.now();

    notNull(new Object());
    notNull(new Object(), null);
    notNull(new Object(), message);

    assertThrowingCallables(AssertionException.class, () -> notNull(null));
    assertThrowingCallables(AssertionException.class, message, () -> notNull(null, message));
  }

  @Test
  public void testAssignableForException() throws Exception {
    assertThrowingCallables(NullPointerException.class,
        () -> assignable(null, null),
        () -> assignable(new Object(), null),
        () -> assignable("", null));
  }

  @Test
  public void testAssignable() throws Exception {
    class A {
    }
    class B {
    }
    final String message = "expected message@" + Instant.now();

    assignable(new A(), Object.class);
    assignable(null, Object.class);
    assignable(null, A.class);

    assignable(new A(), Object.class, null);
    assignable(null, Object.class, null);
    assignable(null, A.class, null);

    assignable(new A(), Object.class, message);
    assignable(null, Object.class, message);
    assignable(null, A.class, message);

    assertThrowingCallables(AssertionException.class,
        () -> assignable(new Object(), A.class),
        () -> assignable(new B(), A.class));

    assertThrowingCallables(AssertionException.class, message,
        () -> assignable(new Object(), A.class, message),
        () -> assignable(new B(), A.class, message));
  }

  @Test
  public void testHasLength() throws Exception {
    final String message = "expected message@" + Instant.now();

    hasLength(".");
    hasLength(".", null);
    hasLength(".", message);

    assertThrowingCallables(AssertionException.class,
        () -> hasLength(null),
        () -> hasLength(""));

    assertThrowingCallables(AssertionException.class, message,
        () -> hasLength(null, message),
        () -> hasLength("", message));
  }

  @Test
  public void testLengthForException() throws Exception {
    final String message = "expected message@" + Instant.now();

    assertThrowingCallables(NullPointerException.class,
        () -> length(null, -1),
        () -> length(null, 0),
        () -> length(null, 1),
        () -> length(null, 0, -1),
        () -> length(null, 0, 0),
        () -> length(null, 1, -1),
        () -> length(null, 1, 0),
        () -> length(null, -1, message),
        () -> length(null, 0, message),
        () -> length(null, 1, message),
        () -> length(null, 0, -1, message),
        () -> length(null, 0, 0, message),
        () -> length(null, 1, -1, message),
        () -> length(null, 1, 0, message));

    assertThrowingCallables(IllegalArgumentException.class,
        () -> length("", -1),
        () -> length(".", -1),
        () -> length("", 0, -1),
        () -> length("", 1, -1),
        () -> length("", 1, 0),
        () -> length("", -1, message),
        () -> length(".", -1, message),
        () -> length("", 0, -1, message),
        () -> length("", 1, -1, message),
        () -> length("", 1, 0, message));
  }

  @Test
  public void testLengthWithStringAndLength() throws Exception {
    final String message = "expected message@" + Instant.now();

    length("", 0);
    length(".", 1);

    length("", 0, null);
    length(".", 1, null);

    length("", 0, message);
    length(".", 1, message);

    assertThrowingCallables(AssertionException.class,
        () -> length(".", 0),
        () -> length("", 1));

    assertThrowingCallables(AssertionException.class, message,
        () -> length(".", 0, message),
        () -> length("", 1, message));
  }

  @Test
  public void testLengthWithStringAndMinAndMax() throws Exception {
    final String message = "expected message@" + Instant.now();

    length("", 0, 1);
    length(".", 0, 1);

    length("", 0, 1, null);
    length(".", 0, 1, null);

    length("", 0, 1, message);
    length(".", 0, 1, message);

    assertThrowingCallables(AssertionException.class,
        () -> length("", 1, 2),
        () -> length("111", 1, 2));

    assertThrowingCallables(AssertionException.class, message,
        () -> length("", 1, 2, message),
        () -> length("111", 1, 2, message));
  }

  @Test
  public void testShorterForException() throws Exception {
    final String message = "expected message@" + Instant.now();

    assertThrowingCallables(NullPointerException.class,
        () -> shorter(null, -1),
        () -> shorter(null, 0),
        () -> shorter(null, 1),
        () -> shorter(null, -1, message),
        () -> shorter(null, 0, message),
        () -> shorter(null, 1, message));

    assertThrowingCallables(IllegalArgumentException.class,
        () -> shorter("", -1),
        () -> shorter("1", -1),
        () -> shorter("", -1, message),
        () -> shorter("1", -1, message));
  }

  @Test
  public void testShorter() throws Exception {
    final String message = "expected message@" + Instant.now();

    shorter("", 0);
    shorter("", 1);
    shorter("1", 1);
    shorter("1", 2);

    shorter("", 0, null);
    shorter("", 1, null);
    shorter("1", 1, null);
    shorter("1", 2, null);

    shorter("", 0, message);
    shorter("", 1, message);
    shorter("1", 1, message);
    shorter("1", 2, message);

    assertThrowingCallables(AssertionException.class,
        () -> shorter("1", 0),
        () -> shorter("11", 1));

    assertThrowingCallables(AssertionException.class, message,
        () -> shorter("1", 0, message),
        () -> shorter("11", 1, message));
  }

  @Test
  public void testLongerForException() throws Exception {
    final String message = "expected message@" + Instant.now();

    assertThrowingCallables(NullPointerException.class,
        () -> longer(null, -1),
        () -> longer(null, 0),
        () -> longer(null, 1),
        () -> longer(null, -1, message),
        () -> longer(null, 0, message),
        () -> longer(null, 1, message));

    assertThrowingCallables(IllegalArgumentException.class,
        () -> longer("", -1),
        () -> longer(".", -1),
        () -> longer("", -1, message),
        () -> longer(".", -1, message));
  }

  @Test
  public void testLonger() throws Exception {
    final String message = "expected message@" + Instant.now();

    longer("", 0);
    longer("1", 0);
    longer("1", 1);

    longer("", 0, null);
    longer("1", 0, null);
    longer("1", 1, null);

    longer("", 0, message);
    longer("1", 0, message);
    longer("1", 1, message);

    assertThrowingCallables(AssertionException.class,
        () -> longer("", 1),
        () -> longer("1", 2));

    assertThrowingCallables(AssertionException.class, message,
        () -> longer("", 1, message),
        () -> longer("1", 2, message));
  }

  @Test
  public void testMatchesForException() throws Exception {
    final String message = "expected message@" + Instant.now();

    assertThrowingCallables(NullPointerException.class,
        () -> matches(null, null),
        () -> matches(null, "["),
        () -> matches("", null),
        () -> matches(null, ".*"),
        () -> matches(null, ".*"),
        () -> matches(null, null, message),
        () -> matches(null, "[", message),
        () -> matches("", null, message),
        () -> matches(null, ".*", message),
        () -> matches(null, ".*", message));

    assertThrowingCallables(IllegalArgumentException.class,
        () -> matches("", "["),
        () -> matches("", "[", message));
  }

  @Test
  public void testMatches() throws Exception {
    final String message = "expected message@" + Instant.now();

    matches("", ".*");
    matches("0", "\\d*");

    matches("", ".*", null);
    matches("0", "\\d*", null);

    matches("", ".*", message);
    matches("0", "\\d*", message);

    assertThrowingCallables(AssertionException.class,
        () -> matches("", ".+"),
        () -> matches("0", "\\D+"),
        () -> matches("a", "\\d+"));

    assertThrowingCallables(AssertionException.class, message,
        () -> matches("", ".+", message),
        () -> matches("0", "\\D+", message),
        () -> matches("a", "\\d+", message));
  }
}
