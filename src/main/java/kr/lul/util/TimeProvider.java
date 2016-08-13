package kr.lul.util;

import static kr.lul.util.Asserts.notNull;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 * 시간 정보 제공.
 *
 * @author justburrow
 * @since 2016. 8. 3.
 */
public interface TimeProvider {
  /**
   * 현재 시각.
   *
   * @return
   * @author Just Burrow
   * @since 2016. 8. 3.
   */
  public Instant now();

  /**
   * 기준 시간대.
   *
   * @return
   * @author Just Burrow
   * @since 2016. 8. 3.
   */
  public ZoneId zoneId();

  /**
   * 기준 시간대와 그리니치 표준시의 차이.
   *
   * @return
   * @author Just Burrow
   * @since 2016. 8. 11.
   */
  default public ZoneOffset zoneOffset() {
    return now().atZone(zoneId()).getOffset();
  }

  /**
   * 현재의 지역 날짜.
   *
   * @return
   * @author Just Burrow
   * @since 2016. 8. 3.
   */
  default public LocalDate localDate() {
    return now().atZone(zoneId()).toLocalDate();
  }

  /**
   * 현재의 지역 시각.
   *
   * @return
   * @author Just Burrow
   * @since 2016. 8. 3.
   */
  default public LocalTime localTime() {
    return now().atZone(zoneId()).toLocalTime();
  }

  /**
   * 현재의 지역 날짜와 시각.
   *
   * @return
   * @author Just Burrow
   * @since 2016. 8. 3.
   */
  default public LocalDateTime localDateTime() {
    return now().atZone(zoneId()).toLocalDateTime();
  }

  /**
   * @return
   * @author Just Burrow
   * @since 2016. 8. 11.
   */
  default public ZonedDateTime zonedDateTime() {
    return now().atZone(zoneId());
  }

  /**
   * @return
   * @author Just Burrow
   * @since 2016. 8. 11.
   */
  default public OffsetDateTime offsetDateTime() {
    return now().atZone(zoneId()).toOffsetDateTime();
  }

  /**
   * 초 단위의 기간을 구한다.
   *
   * @param endExclusive
   *          종료 시각(미포함).
   * @return
   * @author Just Burrow
   * @since 2016. 8. 10.
   */
  default public Duration duration(Instant endExclusive) {
    notNull(endExclusive, "endExclusive");
    return Duration.between(now(), endExclusive);
  }

  /**
   * 날짜 단위의 기간을 구한다.
   *
   * @param endExclusive
   *          종료일(미포함).
   * @return
   * @author Just Burrow
   * @since 2016. 8. 10.
   */
  default public Period period(Instant endExclusive) {
    notNull(endExclusive, "endExclusive");
    return Period.between(localDate(), LocalDate.from(endExclusive));
  }
}
