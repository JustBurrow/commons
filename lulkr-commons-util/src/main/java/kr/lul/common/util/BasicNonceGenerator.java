/**
 * @see https://github.com/JustBurrow/common
 */
package kr.lul.common.util;

/**
 * @author Just Burrow
 * @since 2016. 9. 4.
 */
public class BasicNonceGenerator implements NonceGenerator {
  private TimeProvider timeProvider;

  /**
   * @author Just Burrow
   * @since 2016. 9. 4.
   */
  public BasicNonceGenerator(TimeProvider timeProvider) {
    this.timeProvider = timeProvider;
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // <I>NonceGenerator
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  /*
   * (non-Javadoc)
   * @author Just Burrow
   * @since 2016. 9. 4.
   */
  @Override
  public TimeProvider getTimeProvider() {
    return this.timeProvider;
  }
}
