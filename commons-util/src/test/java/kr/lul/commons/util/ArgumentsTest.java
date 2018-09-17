package kr.lul.commons.util;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.PatternSyntaxException;

import static kr.lul.commons.util.Arguments.*;
import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2018. 9. 17.
 */
public class ArgumentsTest {
    private static final Logger log = getLogger(ArgumentsTest.class);

    public static final String SOME_TARGET_NAME = "someName";

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
    public void notNullWithObject() throws Exception {
        Arguments.notNull(new Object());
    }

    @Test
    public void testNotNullWithObjectAndNullName() throws Exception {
        Arguments.notNull(new Object(), SOME_TARGET_NAME);
    }

    @Test
    public void testNotNullWithNullObject() throws Exception {
        assertThatThrownBy(() -> Arguments.notNull(null))
                .isInstanceOf(AssertionException.class)
                .hasMessageContaining(" is null");
    }

    @Test
    public void testNotNullWithNullObjectAndNullName() throws Exception {
        assertThatThrownBy(() -> Arguments.notNull(null, SOME_TARGET_NAME))
                .isInstanceOf(AssertionException.class)
                .hasMessageContaining(" is null")
                .hasMessageContaining(SOME_TARGET_NAME);
    }

    @Test
    public void testPositiveWithNegative1() throws Exception {
        assertThatThrownBy(() -> positive(-1))
                .isInstanceOf(AssertionException.class)
                .hasMessageContaining(" is not positive")
                .hasMessageContaining("-1");
    }

    @Test
    public void testPositiveWith0() throws Exception {
        assertThatThrownBy(() -> positive(0))
                .isInstanceOf(AssertionException.class)
                .hasMessageContaining(" is not positive")
                .hasMessageContaining("0");
    }

    @Test
    public void testPositiveWith1() throws Exception {
        positive(1);
    }

    @Test
    public void testPositiveWithNegative1L() throws Exception {
        assertThatThrownBy(() -> positive(-1L))
                .isInstanceOf(AssertionException.class)
                .hasMessageContaining(" is not positive")
                .hasMessageContaining("-1");
    }

    @Test
    public void testPositiveWith0L() throws Exception {
        assertThatThrownBy(() -> positive(0L))
                .isInstanceOf(AssertionException.class)
                .hasMessageContaining(" is not positive")
                .hasMessageContaining("0");
    }

    @Test
    public void testPositiveWith1L() throws Exception {
        positive(1L);
    }

    @Test
    public void testPositiveWithNegative1AndName() throws Exception {
        assertThatThrownBy(() -> positive(-1, SOME_TARGET_NAME))
                .isInstanceOf(AssertionException.class)
                .hasMessageContaining(" is not positive")
                .hasMessageContaining("-1")
                .hasMessageContaining(SOME_TARGET_NAME);
    }

    @Test
    public void testPositiveWith0AndName() throws Exception {
        assertThatThrownBy(() -> positive(0, SOME_TARGET_NAME))
                .isInstanceOf(AssertionException.class)
                .hasMessageContaining(" is not positive")
                .hasMessageContaining("0")
                .hasMessageContaining(SOME_TARGET_NAME);
    }

    @Test
    public void testPositiveWith1AndName() throws Exception {
        positive(1, SOME_TARGET_NAME);
    }

    @Test
    public void testPositiveWithNegative1LAndName() throws Exception {
        assertThatThrownBy(() -> positive(-1L, SOME_TARGET_NAME))
                .isInstanceOf(AssertionException.class)
                .hasMessageContaining(" is not positive")
                .hasMessageContaining("-1")
                .hasMessageContaining(SOME_TARGET_NAME);
    }

    @Test
    public void testPositiveWith0LAndName() throws Exception {
        assertThatThrownBy(() -> positive(0L, SOME_TARGET_NAME))
                .isInstanceOf(AssertionException.class)
                .hasMessageContaining(" is not positive")
                .hasMessageContaining("0")
                .hasMessageContaining(SOME_TARGET_NAME);
    }

    @Test
    public void testPositiveWith1LAndName() throws Exception {
        positive(1L, SOME_TARGET_NAME);
    }

    @Test
    public void testNotNegativeWithNegative1() throws Exception {
        assertThatThrownBy(() -> notNegative(-1))
                .isInstanceOf(AssertionException.class)
                .hasMessageContaining(" is negative")
                .hasMessageContaining("-1");
    }

    @Test
    public void testNotNegativeWith0() throws Exception {
        notNegative(0);
    }

    @Test
    public void testNotNegativeWith1() throws Exception {
        notNegative(1);
    }

    @Test
    public void testNotNegativeWithNegative1AndName() throws Exception {
        assertThatThrownBy(() -> notNegative(-1, SOME_TARGET_NAME))
                .isInstanceOf(AssertionException.class)
                .hasMessageContaining(" is negative")
                .hasMessageContaining("-1")
                .hasMessageContaining(SOME_TARGET_NAME);
    }

    @Test
    public void testNotNegativeWith0AndName() throws Exception {
        notNegative(0, SOME_TARGET_NAME);
    }

    @Test
    public void testNotNegativeWith1AndName() throws Exception {
        notNegative(1, SOME_TARGET_NAME);
    }


    @Test
    public void testNotNegativeWithNegative1L() throws Exception {
        assertThatThrownBy(() -> notNegative(-1L))
                .isInstanceOf(AssertionException.class)
                .hasMessageContaining(" is negative")
                .hasMessageContaining("-1");
    }

    @Test
    public void testNotNegativeWith0L() throws Exception {
        notNegative(0L);
    }

    @Test
    public void testNotNegativeWith1L() throws Exception {
        notNegative(1L);
    }

    @Test
    public void testNotNegativeWithNegative1LAndName() throws Exception {
        assertThatThrownBy(() -> notNegative(-1L, SOME_TARGET_NAME))
                .isInstanceOf(AssertionException.class)
                .hasMessageContaining(" is negative")
                .hasMessageContaining("-1")
                .hasMessageContaining(SOME_TARGET_NAME);
    }

    @Test
    public void testNotNegativeWith0LAndName() throws Exception {
        notNegative(0L, SOME_TARGET_NAME);
    }

    @Test
    public void testNotNegativeWith1LAndName() throws Exception {
        notNegative(1L, SOME_TARGET_NAME);
    }

    @Test
    public void testNotEmptyWithNullText() throws Exception {
        assertThatThrownBy(() -> notEmpty(null))
                .isInstanceOf(AssertionException.class)
                .hasMessageContaining(" is null.");
    }

    @Test
    public void testNotEmptyWithEmptyText() throws Exception {
        assertThatThrownBy(() -> notEmpty(""))
                .isInstanceOf(AssertionException.class)
                .hasMessageContaining(" is empty.");
    }

    @Test
    public void testNotEmptyWithText() throws Exception {
        notEmpty(random(this.random.nextInt(1, 10)));
    }


    @Test
    public void testNotEmptyWithNullTextAndName() throws Exception {
        assertThatThrownBy(() -> notEmpty(null, SOME_TARGET_NAME))
                .isInstanceOf(AssertionException.class)
                .hasMessageContaining(" is null.")
                .hasMessageContaining(SOME_TARGET_NAME);
    }

    @Test
    public void testNotEmptyWithEmptyTextAndName() throws Exception {
        assertThatThrownBy(() -> notEmpty("", SOME_TARGET_NAME))
                .isInstanceOf(AssertionException.class)
                .hasMessageContaining(" is empty.")
                .hasMessageContaining(SOME_TARGET_NAME);
    }

    @Test
    public void testNotEmptyWithTextAndName() throws Exception {
        notEmpty(random(this.random.nextInt(1, 10)), SOME_TARGET_NAME);
    }

    @Test
    public void testMatchesWithNullTextAndNullPattern() throws Exception {
        assertThatThrownBy(() -> matches(null, null))
                .isInstanceOf(AssertionException.class)
                .hasMessageContaining(" is null");
    }

    @Test
    public void testMatchesWithNullTextAndPattern() throws Exception {
        assertThatThrownBy(() -> matches(null, ".*"))
                .isInstanceOf(AssertionException.class)
                .hasMessageContaining("is null");
    }

    @Test
    public void testMatchesWithEmptyTextAndNullPattern() throws Exception {
        assertThatThrownBy(() -> matches("", null))
                .isInstanceOf(AssertionException.class)
                .hasMessage("pattern is null.");
    }

    @Test
    public void testMatchesWithTextAndIllegalPattern() throws Exception {
        // Given
        String pattern = "[*";
        log.info("GIVEN - pattern={}", pattern);

        // When & Then
        assertThatThrownBy(() -> matches(random(this.random.nextInt(0, 10)), "[*"))
                .isInstanceOf(AssertionException.class)
                .hasCauseInstanceOf(PatternSyntaxException.class)
                .hasMessageContaining("illegal pattern")
                .hasMessageContaining(pattern);
    }

    @Test
    public void testMatchesWithEmptyTextAndPattern() throws Exception {
        matches("", ".*");
    }

    @Test
    public void testMatchesWithDigitsAndNonDigits() throws Exception {
        // Given
        String target = "" + this.random.nextLong();
        String pattern = "\\D+";
        log.info("GIVEN - target={}, pattern={}", target, pattern);

        // When
        assertThatThrownBy(() -> matches(target, pattern))
                .isInstanceOf(AssertionException.class)
                .hasMessageContaining("does not match")
                .hasMessageContaining(target)
                .hasMessageContaining(pattern);
    }

    @Test
    public void testMatchesWithTextAndPattern() throws Exception {
        matches(random(this.random.nextInt(1, 10)), ".*");
    }

    @Test
    public void testMatchesWithNullTextAndNullPatternAndName() throws Exception {
        assertThatThrownBy(() -> matches(null, null, SOME_TARGET_NAME))
                .isInstanceOf(AssertionException.class)
                .hasMessageContaining(" is null")
                .hasMessageContaining(SOME_TARGET_NAME);
    }

    @Test
    public void testMatchesWithNullTextAndPatternAndName() throws Exception {
        assertThatThrownBy(() -> matches(null, ".*", SOME_TARGET_NAME))
                .isInstanceOf(AssertionException.class)
                .hasMessageContaining("is null")
                .hasMessageContaining(SOME_TARGET_NAME);
    }


    @Test
    public void testMatchesWithEmptyTextAndNullPatternAndName() throws Exception {
        assertThatThrownBy(() -> matches("", null, SOME_TARGET_NAME))
                .isInstanceOf(AssertionException.class)
                .hasMessage("pattern is null.");
    }

    @Test
    public void testMatchesWithTextAndIllegalPatternAndName() throws Exception {
        // Given
        String pattern = "[*";
        log.info("GIVEN - pattern={}", pattern);

        // When & Then
        assertThatThrownBy(() -> matches(random(this.random.nextInt(0, 10)), "[*", SOME_TARGET_NAME))
                .isInstanceOf(AssertionException.class)
                .hasCauseInstanceOf(PatternSyntaxException.class)
                .hasMessageContaining("illegal pattern")
                .hasMessageContaining(pattern);
    }

    @Test
    public void testMatchesWithEmptyTextAndPatternAndName() throws Exception {
        matches("", ".*", SOME_TARGET_NAME);
    }

    @Test
    public void testMatchesWithDigitsAndNonDigitsAndName() throws Exception {
        // Given
        String target = "" + this.random.nextLong();
        String pattern = "\\D+";
        log.info("GIVEN - target={}, pattern={}", target, pattern);

        // When
        assertThatThrownBy(() -> matches(target, pattern, SOME_TARGET_NAME))
                .isInstanceOf(AssertionException.class)
                .hasMessageContaining("does not match")
                .hasMessageContaining(target)
                .hasMessageContaining(pattern)
                .hasMessageContaining(SOME_TARGET_NAME);
    }

    @Test
    public void testMatchesWithTextAndPatternAndName() throws Exception {
        matches(random(this.random.nextInt(1, 10)), ".*", SOME_TARGET_NAME);
    }
}
