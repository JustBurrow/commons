package kr.lul.commons.util.parser;

import kr.lul.commons.util.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class BigIntegerParserTest {
    private static final Logger log = getLogger(BigIntegerParserTest.class);

    private BigIntegerParser parser;

    private ThreadLocalRandom random;

    @Before
    public void setUp() throws Exception {
        parser = new BigIntegerParser();

        random = ThreadLocalRandom.current();
    }

    @Test
    public void testParseWithNull() throws Exception {
        assertThat(parser.parse(null))
                .isNull();
    }

    @Test
    public void testParseWithEmpty() throws Exception {
        assertThatThrownBy(() -> parser.parse(""))
                .isInstanceOf(ParseException.class)
                .hasCauseInstanceOf(NumberFormatException.class);
    }

    @Test
    public void testParseWithFloatingPointNumber() throws Exception {
        assertThatThrownBy(() -> parser.parse(Double.toString(random.nextDouble() * random.nextLong())))
                .isInstanceOf(ParseException.class)
                .hasCauseInstanceOf(NumberFormatException.class);
    }

    @Test
    public void testParse() throws Exception {
        for (int i = 0; i < 100; i++) {
            // Given
            long l = random.nextLong();
            String input = Long.toString(l);
            log.info("GIVEN - l={}, input={}", l, input);

            // When
            BigInteger actual = parser.parse(input);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull()
                    .isEqualTo(l);
        }
    }
}
