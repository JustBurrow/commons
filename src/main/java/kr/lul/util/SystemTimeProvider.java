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
}
