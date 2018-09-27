package kr.lul.commons.util.composer;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2018. 9. 24.
 */
public class LocalDateTimeComposerTest {
    private static final Logger log = getLogger(LocalDateTimeComposerTest.class);

    private LocalDateTimeComposer composer;

    @Before
    public void setUp() throws Exception {
        this.composer = new LocalDateTimeComposer();
    }

    @Test
    public void testConstructor() throws Exception {
        assertThat(this.composer)
                .isNotNull()
                .extracting(LocalDateTimeComposer::getConfig)
                .containsSequence(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    @Test
    public void testComposeWithNull() throws Exception {
        assertThat(this.composer.compose(null))
                .isNull();
    }

    @Test
    public void testCompose() throws Exception {
        // Given
        LocalDateTime expected = LocalDateTime.now();
        log.info("GIVEN - expected={}", expected);

        // When
        String actual = this.composer.compose(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotEmpty();
        assertThat(LocalDateTime.parse(actual, this.composer.getConfig()))
                .isEqualTo(expected);
    }
}
