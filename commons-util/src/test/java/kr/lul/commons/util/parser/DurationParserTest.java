package kr.lul.commons.util.parser;

import kr.lul.commons.util.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.time.Duration;
import java.time.format.DateTimeParseException;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class DurationParserTest {
    private static final Logger log = getLogger(DurationParserTest.class);

    private DurationParser parser;

    private ThreadLocalRandom random;

    @Before
    public void setUp() throws Exception {
        this.parser = new DurationParser();
        this.random = ThreadLocalRandom.current();
    }

    @Test
    public void testParseWithNull() throws Exception {
        assertThat(this.parser.parse(null))
                .isNull();
    }

    @Test
    public void testParseWithEmpty() throws Exception {
        assertThatThrownBy(() -> this.parser.parse(""))
                .isInstanceOf(ParseException.class)
                .hasCauseInstanceOf(DateTimeParseException.class);
    }

    @Test
    public void testParse() throws Exception {
        for (int i = 0; i < 100; i++) {
            // Given
            Duration expected = Duration.ofSeconds(this.random.nextLong(), this.random.nextLong());
            String text = expected.toString();
            log.info("GIVEN - expected={}", expected);

            // When
            Duration actual = this.parser.parse(text);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull()
                    .isEqualTo(expected);
        }
    }
}
