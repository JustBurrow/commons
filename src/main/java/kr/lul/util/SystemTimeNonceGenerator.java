/**
 * @see https://github.com/JustBurrow/common
 */
package kr.lul.util;

/**
 * @author Just Burrow
 * @since 2016. 9. 2.
 */
public class SystemTimeNonceGenerator implements NonceGenerator {
  private TimeProvider timeProvider = new SystemTimeProvider();

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // <I>NonceGenerator
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  /*
   * (non-Javadoc)
   * @author Just Burrow
   * @since 2016. 9. 2.
   */
  @Override
  public TimeProvider getTimeProvider() {
    return this.timeProvider;
  }
}
