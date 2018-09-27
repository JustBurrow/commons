package kr.lul.commons.test;

import org.junit.Test;
import org.slf4j.Logger;

import java.time.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2018. 9. 25.
 */
public class TimeUtilsTest {
    private static final Logger log = getLogger(TimeUtilsTest.class);
    public static final int LOOP_COUNT = 1000;

    @Test
    public void testInstant() throws Exception {
        for (int i = 0; i < LOOP_COUNT; i++) {
            // When
            Instant actual = TimeUtils.instant();
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull();
        }
    }

    @Test
    public void testZoneId() throws Exception {
        for (int i = 0; i < LOOP_COUNT; i++) {
            // When
            ZoneId actual = TimeUtils.zoneId();
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull();
        }
    }

    @Test
    public void testZoneOffset() throws Exception {
        for (int i = 0; i < LOOP_COUNT; i++) {
            // When
            ZoneOffset actual = TimeUtils.zoneOffset();
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull();
        }
    }

    @Test
    public void testZonedDateTime() throws Exception {
        for (int i = 0; i < LOOP_COUNT; i++) {
            // When
            ZonedDateTime actual = TimeUtils.zonedDateTime();
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull();
        }
    }

    @Test
    public void testOffsetDateTime() throws Exception {
        for (int i = 0; i < LOOP_COUNT; i++) {
            // When
            OffsetDateTime actual = TimeUtils.offsetDateTime();
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull();
        }
    }

    @Test
    public void testOffsetTime() throws Exception {
        for (int i = 0; i < LOOP_COUNT; i++) {
            // When
            OffsetTime actual = TimeUtils.offsetTime();
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull();
        }
    }

    @Test
    public void testLocalDateTime() throws Exception {
        for (int i = 0; i < LOOP_COUNT; i++) {
            // When
            LocalDate actual = TimeUtils.localDate();
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull();
        }
    }

    @Test
    public void testLocalDate() throws Exception {
        for (int i = 0; i < LOOP_COUNT; i++) {
            // When
            LocalDate actual = TimeUtils.localDate();
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull();
        }
    }

    @Test
    public void testLocalTime() throws Exception {
        for (int i = 0; i < LOOP_COUNT; i++) {
            // When
            LocalTime actual = TimeUtils.localTime();
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull();
        }
    }

    @Test
    public void testPeriod() throws Exception {
        for (int i = 0; i < LOOP_COUNT; i++) {
            // When
            Period actual = TimeUtils.period();
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull();
        }
    }

    @Test
    public void testDuration() throws Exception {
        for (int i = 0; i < LOOP_COUNT; i++) {
            // When
            Duration actual = TimeUtils.duration();
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull();
        }
    }
}
