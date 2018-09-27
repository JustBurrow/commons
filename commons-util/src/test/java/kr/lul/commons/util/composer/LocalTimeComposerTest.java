package kr.lul.commons.util.composer;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2018. 9. 24.
 */
public class LocalTimeComposerTest {
    private static final Logger log = getLogger(LocalTimeComposerTest.class);

    private LocalTimeComposer composer;

    @Before
    public void setUp() throws Exception {
        this.composer = new LocalTimeComposer();
    }

    @Test
    public void testConstructor() throws Exception {
        assertThat(this.composer)
                .isNotNull()
                .extracting(LocalTimeComposer::getConfig)
                .containsSequence(DateTimeFormatter.ISO_LOCAL_TIME);
    }

    @Test
    public void testComposeWithNull() throws Exception {
        assertThat(this.composer.compose(null))
                .isNull();
    }

    @Test
    public void testCompose() throws Exception {
        // Given
        LocalTime expected = LocalTime.now();
        log.info("GIVEN - expected={}", expected);

        // When
        String actual = this.composer.compose(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotEmpty();
        assertThat(LocalTime.parse(actual, this.composer.getConfig()))
                .isEqualTo(expected);
    }
}
