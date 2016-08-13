package kr.lul.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.junit.Before;
import org.junit.Test;

public class SystemTimeProviderTest {
  private long         before;
  private TimeProvider timeProvider;

  @Before
  public void setUp() throws Exception {
    this.before = System.currentTimeMillis();
    this.timeProvider = new SystemTimeProvider();
  }

  @Test
  public void testNow() throws Exception {
    // When
    final Instant actual = this.timeProvider.now();

    // Then
    assertThat(actual).isNotNull();
    assertThat(actual.toEpochMilli()).isGreaterThanOrEqualTo(this.before)
        .isLessThanOrEqualTo(System.currentTimeMillis());
  }

  @Test
  public void testZoneId() throws Exception {
    // When
    final ZoneId zoneId = this.timeProvider.zoneId();

    // Then
    assertThat(zoneId).isNotNull()
        .isEqualTo(ZoneId.of(System.getProperty("user.timezone")));
    assertThat(zoneId.toString()).isEqualTo(System.getProperty("user.timezone"));
  }

  @Test
  public void testZoneOffset() throws Exception {
    // When
    ZoneOffset zoneOffset = this.timeProvider.zoneOffset();

    // Then
    assertThat(zoneOffset).isNotNull();
  }

  @Test
  public void testLocalDate() throws Exception {
    LocalDate localDate = this.timeProvider.localDate();

    assertThat(localDate).isNotNull()
        .isAfterOrEqualTo(Instant.ofEpochMilli(this.before).atZone(ZoneId.systemDefault()).toLocalDate());
  }

  @Test
  public void testLocalDateTime() throws Exception {
    LocalDateTime localDateTime = this.timeProvider.localDateTime();

    assertThat(localDateTime).isNotNull()
        .isAfterOrEqualTo(LocalDateTime.ofInstant(Instant.ofEpochMilli(this.before), ZoneId.systemDefault()));
  }

  @Test
  public void testZoneDateTime() throws Exception {
    ZonedDateTime zonedDateTime = this.timeProvider.zonedDateTime();

    assertThat(zonedDateTime).isNotNull()
        .isAfterOrEqualTo(Instant.ofEpochMilli(this.before).atZone(ZoneId.systemDefault()));
  }

  @Test
  public void testOffsetDateTime() throws Exception {
    OffsetDateTime offsetDateTime = this.timeProvider.offsetDateTime();

    assertThat(offsetDateTime).isNotNull()
        .isAfterOrEqualTo(Instant.ofEpochMilli(this.before).atZone(ZoneId.systemDefault()).toOffsetDateTime());
  }
}
