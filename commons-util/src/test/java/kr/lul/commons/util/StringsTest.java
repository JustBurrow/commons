package kr.lul.commons.util;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.util.concurrent.ThreadLocalRandom;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2018. 9. 18.
 */
public class StringsTest {
    private static final Logger log = getLogger(StringsTest.class);

    private ThreadLocalRandom random;

    @Before
    public void setUp() throws Exception {
        if (null == this.random) {
            this.random = ThreadLocalRandom.current();
        } else {
            this.random.setSeed(this.random.nextLong());
        }
    }

    @Test
    public void testCapitalize_알파벳으로_시작하는_문자열() throws Exception {
        // Given
        String head = randomAlphabetic(1).toLowerCase();
        String body = random(this.random.nextInt(1, 10));
        String expected = head + body;
        log.info("GIVE - head={}, expected={}", head, expected);

        // When
        String actual = Strings.capitalize(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .isNotEqualTo(expected)
                .isEqualTo(head.toUpperCase() + body);
    }

    @Test
    public void testCapitalize_알파벳으로_시작하지_않는_문자열() throws Exception {
        // Given
        String expected;
        do {
            expected = random(this.random.nextInt(1, 10));
        } while (expected.matches("^[a-zA-Z].*$"));
        log.info("GIVEN - expected={}", expected);

        // When
        String actual = Strings.capitalize(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .isEqualTo(expected);
    }
}
