/**
 *
 */
package kr.lul.util;

import static kr.lul.util.RandomUtil.R;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigInteger;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Just Burrow
 * @since 2016. 8. 14.
 */
public class RandomUtilTest {
  private static final int COUNT = Integer.MAX_VALUE >> 11;

  private Random           rand;

  @Before
  public void setUp() throws Exception {
    this.rand = new Random();
  }

  @Test
  public void testBool() throws Exception {
    int t = 0;
    int f = 0;
    for (int i = 0; i < COUNT; i++) {
      if (R.bool()) {
        t++;
      } else {
        f++;
      }
    }

    assertThat((int) ((double) Math.abs(t - f) / (COUNT / 2))).isEqualTo(0);
    // assertEquals(format("true=%d, false=%d, diff=%d", t, f, Math.abs(t - f)), 0,
    // (int) ((double) Math.abs(t - f) / (COUNT / 2)));
  }

  @Test
  public void testNegative() throws Exception {
    for (int i = 0; i < COUNT; i++) {
      assertThat(R.negative()).isLessThan(0);
    }
  }

  @Test
  public void testNegativeLong() throws Exception {
    for (int i = 0; i < COUNT; i++) {
      assertThat(R.negativeLong()).isLessThan(0L);
    }
  }

  @Test
  public void testPositive() throws Exception {
    for (int i = 0; i < COUNT; i++) {
      assertThat(R.positive()).isGreaterThan(0);
    }
  }

  @Test
  public void testPositiveLong() throws Exception {
    for (int i = 0; i < COUNT; i++) {
      assertThat(R.positiveLong()).isGreaterThan(0L);
    }
  }

  @Test
  public void testNotNegative() throws Exception {
    for (int i = 0; i < COUNT; i++) {
      assertThat(R.notNegative()).isGreaterThanOrEqualTo(0);
    }
  }

  @Test
  public void testNotNegativeLong() throws Exception {
    for (int i = 0; i < COUNT; i++) {
      assertThat(R.notNegativeLong()).isGreaterThanOrEqualTo(0L);
    }
  }

  @Test
  public void testNotNegativeWithIntMax() throws Exception {
    for (int i = 0; i < COUNT; i++) {
      int max = 1 + this.rand.nextInt(Integer.MAX_VALUE);
      assertThat(R.notNegative(max)).isGreaterThanOrEqualTo(0)
          .isLessThan(max);
    }
  }

  @Test
  public void testNotNegativeWithLongMax() throws Exception {
    for (int i = 0; i < COUNT; i++) {
      long max;
      do {
        max = this.rand.nextLong();
      } while (0L >= max);

      assertThat(R.notNegative(max)).isGreaterThanOrEqualTo(0L)
          .isLessThan(max);
    }
  }

  @Test
  public void testNotZero() throws Exception {
    for (int i = 0; i < COUNT; i++) {
      assertThat(R.notZero()).isNotEqualTo(0);
    }
  }

  @Test
  public void testNotZeroLong() throws Exception {
    for (int i = 0; i < COUNT; i++) {
      assertThat(R.notZeroLong()).isNotEqualTo(0L);
    }
  }

  @Test
  public void testNotPositive() throws Exception {
    for (int i = 0; i < COUNT; i++) {
      assertThat(R.notPositive()).isLessThanOrEqualTo(0);
    }
  }

  @Test
  public void testNotPositiveLong() throws Exception {
    for (int i = 0; i < COUNT; i++) {
      assertThat(R.notPositiveLong()).isLessThanOrEqualTo(0L);
    }
  }

  @Test
  public void testInWithInt() throws Exception {
    for (int i = 0; i < COUNT; i++) {
      int min = this.rand.nextInt();
      int number = R.in(min, min + 1);
      assertThat(number).isEqualTo(min);

      int max = min + (int) Math.min(Integer.MAX_VALUE, (long) Integer.MAX_VALUE - min);
      assertThatThrownBy(() -> R.in(max, min)).isInstanceOf(IllegalArgumentException.class);

      number = R.in(min, max);
      assertThat(number).isGreaterThanOrEqualTo(min)
          .isLessThan(max);
    }
  }

  @Test
  public void testInWithLong() throws Exception {
    assertThatThrownBy(() -> R.in(-1L, Long.MAX_VALUE)).isInstanceOf(AssertionException.class);

    BigInteger longMax = BigInteger.valueOf(Long.MAX_VALUE);
    for (int i = 0; i < COUNT; i++) {
      long min = this.rand.nextLong();
      long number = R.in(min, min + 1L);
      assertThat(number).isEqualTo(min);

      long width;
      if (0 > longMax.compareTo(longMax.subtract(BigInteger.valueOf(min)))) {
        width = Long.MAX_VALUE;
      } else {
        width = Long.MAX_VALUE - min;
      }
      long max = min + 1L + R.notNegative(width);
      assertThatThrownBy(() -> R.in(max, min)).isInstanceOf(IllegalArgumentException.class);

      number = R.in(min, max);
      assertThat(number).isGreaterThanOrEqualTo(min)
          .isLessThan(max);
    }
  }

  @Test
  public void testNotInWithInt() throws Exception {
    for (int i = 0; i < COUNT; i++) {
      int min = this.rand.nextInt();
      int max = 0 > min ? min + 1 + this.rand.nextInt(Integer.MAX_VALUE)
          : min + 1 + this.rand.nextInt(Integer.MAX_VALUE - min);
      assertThatThrownBy(() -> R.notIn(max, min)).isInstanceOf(IllegalArgumentException.class);
      int number = R.notIn(min, max);

      assertThat(number).matches(n -> n < min || max <= n);
    }
  }

  @Test
  public void testNotInWithLong() throws Exception {
    assertThatThrownBy(() -> R.notIn(Long.MIN_VALUE, Long.MAX_VALUE)).isInstanceOf(AssertionException.class);

    for (int i = 0; i < COUNT; i++) {
      long min = this.rand.nextLong();
      long diff;
      do {
        diff = this.rand.nextLong();
      } while (0L == diff);
      long max = 0L > min ? min + Math.abs(diff) : min + Math.min(Long.MAX_VALUE - min - 1, Math.abs(diff));
      assertThatThrownBy(() -> R.notIn(max, min)).isInstanceOf(IllegalArgumentException.class);

      long number = R.notIn(min, max);
      assertThat(number).matches(n -> n < min || max <= n);

      assertThat(R.notIn(Long.MIN_VALUE, min)).isGreaterThanOrEqualTo(min);
      assertThat(R.notIn(max, Long.MAX_VALUE)).isLessThan(max);
    }
  }

  @Test
  public void testLtWithInt() throws Exception {
    assertThatThrownBy(() -> R.lt(Integer.MIN_VALUE)).isInstanceOf(AssertionException.class);
    assertThat(R.lt(Integer.MIN_VALUE + 1)).isEqualTo(Integer.MIN_VALUE);
    for (int i = 0; i < COUNT; i++) {
      int boundary = this.rand.nextInt();
      assertThat(R.lt(boundary)).isLessThan(boundary);
    }
  }

  @Test
  public void testLtWithLong() throws Exception {
    assertThatThrownBy(() -> R.lt(Long.MIN_VALUE)).isInstanceOf(AssertionException.class);
    assertThat(R.lt(Long.MIN_VALUE + 1L)).isEqualTo(Long.MIN_VALUE);
    for (int i = 0; i < COUNT; i++) {
      long boundary = this.rand.nextLong();
      assertThat(R.lt(boundary)).isLessThan(boundary);
    }
  }

  @Test
  public void testLeWithInt() throws Exception {
    assertThat(R.le(Integer.MIN_VALUE)).isEqualTo(Integer.MIN_VALUE);
    for (int i = 0; i < COUNT; i++) {
      int boundary = this.rand.nextInt();
      assertThat(R.le(boundary)).isLessThanOrEqualTo(boundary);
    }
  }

  @Test
  public void testLeWithLong() throws Exception {
    assertThat(R.le(Long.MIN_VALUE)).isEqualTo(Long.MIN_VALUE);
    for (int i = 0; i < COUNT; i++) {
      long boundary = this.rand.nextLong();
      assertThat(R.le(boundary)).isLessThanOrEqualTo(boundary);
    }
  }

  @Test
  public void testGtWithInt() throws Exception {
    assertThatThrownBy(() -> R.gt(Integer.MAX_VALUE)).isInstanceOf(AssertionException.class);
    assertThat(R.gt(Integer.MAX_VALUE - 1)).isEqualTo(Integer.MAX_VALUE);
    for (int i = 0; i < COUNT; i++) {
      int boundary = this.rand.nextInt();
      assertThat(R.gt(boundary)).isGreaterThan(boundary);
    }
  }

  @Test
  public void testGtWithLong() throws Exception {
    assertThatThrownBy(() -> R.gt(Long.MAX_VALUE)).isInstanceOf(AssertionException.class);
    assertThat(R.gt(Long.MAX_VALUE - 1L)).isEqualTo(Long.MAX_VALUE);
    for (int i = 0; i < COUNT; i++) {
      long boundary = this.rand.nextLong();
      assertThat(R.gt(boundary)).isGreaterThan(boundary);
    }
  }

  @Test
  public void testGeWithInt() throws Exception {
    assertThat(R.ge(Integer.MAX_VALUE)).isEqualTo(Integer.MAX_VALUE);
    for (int i = 0; i < COUNT; i++) {
      int boundary = this.rand.nextInt();
      assertThat(R.ge(boundary)).isGreaterThanOrEqualTo(boundary);
    }
  }

  @Test
  public void testGeWithLong() throws Exception {
    assertThat(R.ge(Long.MAX_VALUE)).isEqualTo(Long.MAX_VALUE);
    for (int i = 0; i < COUNT; i++) {
      long boundary = this.rand.nextLong();
      assertThat(R.gt(boundary)).isGreaterThanOrEqualTo(boundary);
    }
  }
}
