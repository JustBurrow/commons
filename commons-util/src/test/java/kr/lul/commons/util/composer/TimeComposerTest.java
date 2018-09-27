package kr.lul.commons.util.composer;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.time.*;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;
import static kr.lul.commons.util.composer.DurationComposerTest.durations;
import static kr.lul.commons.util.composer.PeriodComposerTest.periods;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2018. 9. 24.
 */
@SuppressWarnings("Duplicates")
public class TimeComposerTest {
    private static final Logger log = getLogger(TimeComposerTest.class);
    private static final int LOOP_MAX_COUNT = 100;

    private TimeComposer composer;

    private ThreadLocalRandom random;

    @Before
    public void setUp() throws Exception {
        this.composer = new TimeComposer();

        if (null == this.random) {
            this.random = ThreadLocalRandom.current();
        } else {
            this.random.setSeed(this.random.nextLong());
        }
    }

    @Test
    public void testComposeWithNull() throws Exception {
        assertThat(this.composer.compose(null))
                .isNull();
    }

    @Test
    public void testComposeWithInstant() throws Exception {
        // Given
        Instant expected = Instant.now();
        log.info("GIVEN - expected={}", expected);

        // When
        String actual = this.composer.compose(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotEmpty();
        assertThat(Instant.parse(actual))
                .isEqualTo(expected);
    }

    @Test
    public void testComposeWithZonedDateTime() throws Exception {
        // Given
        ZonedDateTime expected = ZonedDateTime.now();
        log.info("GIVEN - expected={}", expected);

        // When
        String actual = this.composer.compose(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotEmpty();
        assertThat(ZonedDateTime.parse(actual, ZonedDateTimeComposer.DEFAULT_FORMATTER))
                .isEqualTo(expected);
    }

    @Test
    public void testComposeWithOffsetDateTime() throws Exception {
        // Given
        OffsetDateTime expected = OffsetDateTime.now();
        log.info("GIVEN - expected={}", expected);

        // When
        String actual = this.composer.compose(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotEmpty();
        assertThat(OffsetDateTime.parse(actual, ZonedDateTimeComposer.DEFAULT_FORMATTER))
                .isEqualTo(expected);
    }

    @Test
    public void testComposeWithLocalDateTime() throws Exception {
        // Given
        LocalDateTime expected = LocalDateTime.now();
        log.info("GIVEN - expected={}", expected);

        // When
        String actual = this.composer.compose(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotEmpty();
        assertThat(LocalDateTime.parse(actual, LocalDateTimeComposer.DEFAULT_FORMATTER))
                .isEqualTo(expected);
    }

    @Test
    public void testComposeWithLocalDate() throws Exception {
        // Given
        LocalDate expected = LocalDate.now();
        log.info("GIVEN - expected={}", expected);

        // When
        String actual = this.composer.compose(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotEmpty();
        assertThat(LocalDate.parse(actual, LocalDateComposer.DEFAULT_FORMATTER))
                .isEqualTo(expected);
    }

    @Test
    public void testComposeWithLocalTime() throws Exception {
        // Given
        LocalTime expected = LocalTime.now();
        log.info("GIVEN - expected={}", expected);

        // When
        String actual = this.composer.compose(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotEmpty();
        assertThat(LocalTime.parse(actual, LocalTimeComposer.DEFAULT_FORMATTER))
                .isEqualTo(expected);
    }

    @Test
    public void testComposeWithPeriod() throws Exception {
        asList(periods(this.random.nextInt(1, LOOP_MAX_COUNT))).forEach(expected -> {
            // Given
            log.info("GIVEN - expected={}", expected);

            // When
            String actual = this.composer.compose(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotEmpty();
            assertThat(Period.parse(actual))
                    .isEqualTo(expected);
        });
    }

    @Test
    public void testComposeWithDuration() throws Exception {
        asList(durations(this.random.nextInt(1, LOOP_MAX_COUNT))).forEach(expected -> {
            log.info("GIVEN - expected={}", expected);

            // When
            String actual = this.composer.compose(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotEmpty();
            assertThat(Duration.parse(actual))
                    .isEqualTo(expected);
        });
    }
}
