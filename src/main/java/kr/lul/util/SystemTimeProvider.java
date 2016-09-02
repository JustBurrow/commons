package kr.lul.util;

import java.time.Instant;
import java.time.ZoneId;

/**
 * 시스템 시각 정보를 사용해 시각 정보를 제공한다.
 *
 * @author Just Burrow
 * @since 2016. 8. 10.
 */
public class SystemTimeProvider implements TimeProvider {
  private final Instant initInstant;

  /**
   * @author Just Burrow
   * @since 2016. 9. 2.
   */
  public SystemTimeProvider() {
    this.initInstant = this.now();
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // <I>TimeProvider
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public Instant now() {
    return Instant.now();
  }

  @Override
  public ZoneId zoneId() {
    return ZoneId.systemDefault();
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Object
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  /*
   * (non-Javadoc)
   * @author Just Burrow
   * @since 2016. 9. 2.
   */
  @Override
  public String toString() {
    return new StringBuilder(SystemTimeProvider.class.getSimpleName())
        .append(" [initInstant=").append(this.initInstant)
        .append(", zoneId=").append(this.zoneId())
        .append(']').toString();
  }
}
