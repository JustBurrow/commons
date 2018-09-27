package kr.lul.commons.util;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.time.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2018. 9. 27.
 */
public class LowPrecisionSystemTimeProviderTest {
    private static final Logger log = getLogger(LowPrecisionSystemTimeProviderTest.class);

    private TimeProvider timeProvider;

    @Before
    public void setUp() throws Exception {
        this.timeProvider = new LowPrecisionSystemTimeProvider();

        log.info("SETUP - timeProvider={}", this.timeProvider);
    }

    @Test
    public void testZoneId() throws Exception {
        assertThat(this.timeProvider.zoneId())
                .isNotNull();
    }

    @Test
    public void testNow() throws Exception {
        // When
        Instant actual = this.timeProvider.now();
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull();
        assertThat(actual.getNano() % 1000000)
                .isEqualTo(0);
    }

    @Test
    public void testZonedDateTime() throws Exception {
        // When
        ZonedDateTime actual = this.timeProvider.zonedDateTime();
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull();
        assertThat(actual.getNano() % 1000000)
                .isEqualTo(0);
    }

    @Test
    public void testOffsetDateTime() throws Exception {
        // When
        OffsetDateTime actual = this.timeProvider.offsetDateTime();
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull();
        assertThat(actual.getNano() % 1000000)
                .isEqualTo(0);
    }

    @Test
    public void testOffsetTime() throws Exception {
        // When
        OffsetTime actual = this.timeProvider.offsetTime();
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull();
        assertThat(actual.getNano() % 1000000)
                .isEqualTo(0);
    }

    @Test
    public void testLocalDateTime() throws Exception {
        // When
        LocalDateTime actual = this.timeProvider.localDateTime();
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull();
        assertThat(actual.getNano() % 1000000)
                .isEqualTo(0);
    }

    @Test
    public void testLocalDate() throws Exception {
        // When
        LocalDate actual = this.timeProvider.localDate();
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull();
    }

    @Test
    public void testLocalTime() throws Exception {
        // When
        LocalTime actual = this.timeProvider.localTime();
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull();
        assertThat(actual.getNano() % 1000000)
                .isEqualTo(0);
    }
}
