package kr.lul.commons.util.converter;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2018. 9. 24.
 */
public class LocalDateComposerTest {
    private static final Logger log = getLogger(LocalDateComposerTest.class);

    private LocalDateComposer composer;

    @Before
    public void setUp() throws Exception {
        this.composer = new LocalDateComposer();
    }

    @Test
    public void testConstructor() throws Exception {
        assertThat(this.composer)
                .isNotNull()
                .extracting(LocalDateComposer::getConfig)
                .containsSequence(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    @Test
    public void testComposeWithNull() throws Exception {
        assertThat(this.composer.compose(null))
                .isNull();
    }

    @Test
    public void testCompose() throws Exception {
        // Given
        LocalDate expected = LocalDate.now();
        log.info("GIVEN - expected={}", expected);

        // When
        String actual = this.composer.compose(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotEmpty();
        assertThat(LocalDate.parse(actual, this.composer.getConfig()))
                .isEqualTo(expected);
    }
}
