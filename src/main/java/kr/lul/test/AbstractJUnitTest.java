/**
 * @see https://github.com/JustBurrow/common
 */
package kr.lul.test;

import static kr.lul.util.Asserts.notNull;

import java.time.Instant;

import kr.lul.util.RandomUtil;
import kr.lul.util.SystemTimeProvider;
import kr.lul.util.TimeProvider;

/**
 * @author Just Burrow
 * @since 2016. 9. 26.
 */
public abstract class AbstractJUnitTest {
  /**
   * @author Just Burrow
   * @since 2016. 9. 26.
   */
  protected final RandomUtil rand = RandomUtil.R;
  /**
   * @author Just Burrow
   * @since 2016. 9. 26.
   */
  protected TimeProvider     timeProvider;
  /**
   * @author Just Burrow
   * @since 2016. 9. 26.
   */
  protected Instant          now;

  /**
   * @author Just Burrow
   * @since 2016. 9. 26.
   */
  protected void initialize() {
    this.timeProvider = new SystemTimeProvider();
    this.now = this.timeProvider.now();
  }

  /**
   * @param timeProvider
   * @author Just Burrow
   * @since 2016. 9. 26.
   */
  protected void initialize(TimeProvider timeProvider) {
    notNull(timeProvider, "timeProvider");
    this.timeProvider = timeProvider;
    this.now = timeProvider.now();
  }
}
