package kr.lul.commons.util.converter;

import kr.lul.commons.util.PrimitiveTypeUtilsTest;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.util.concurrent.ThreadLocalRandom;

import static java.util.stream.IntStream.range;
import static kr.lul.commons.util.PrimitiveTypeUtilsTest.booleans;
import static kr.lul.commons.util.PrimitiveTypeUtilsTest.strings;
import static kr.lul.commons.util.Strings.containsSequence;
import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2018. 9. 23.
 */
public class ToStringComposerTest {
    private static final Logger log = getLogger(ToStringComposerTest.class);
    private static final int LOOP_COUNT = 100;
    public static final int ARRAY_MAX_LENGTH = 10;

    private ToStringComposer composer;

    private ThreadLocalRandom random;

    @Before
    public void setUp() throws Exception {
        this.composer = new ToStringComposer();

        if (null == this.random) {
            this.random = ThreadLocalRandom.current();
        } else {
            this.random.setSeed(this.random.nextLong());
        }
    }

    @Test
    public void testComposeWithBoolean() throws Exception {
        assertThat(this.composer.compose(true))
                .isEqualTo("true");
        assertThat(this.composer.compose(false))
                .isEqualTo("false");
    }

    @Test
    public void testComposeWithByte() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            byte b = (byte) this.random.nextInt(Byte.MIN_VALUE, 1 + Byte.MAX_VALUE);
            log.info("GIVEN - b={}", b);

            // When
            String actual = this.composer.compose(b);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotEmpty()
                    .isEqualTo("" + b);
        });
    }

    @Test
    public void testComposeWithShort() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            short expected = (short) this.random.nextInt(Short.MIN_VALUE, 1 + Short.MAX_VALUE);
            log.info("GIVEN - expected={}", expected);

            // When
            String actual = this.composer.compose(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotEmpty()
                    .isEqualTo("" + expected);
        });
    }

    @Test
    public void testComposeWithInt() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            int expected = this.random.nextInt();
            log.info("GIVEN - expected={}", expected);

            // When
            String actual = this.composer.compose(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotEmpty()
                    .isEqualTo("" + expected);
        });
    }

    @Test
    public void testComposeWithLong() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            long expected = this.random.nextLong();
            log.info("GIVEN - expected={}", expected);

            // When
            String actual = this.composer.compose(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotEmpty()
                    .isEqualTo("" + expected);
        });
    }

    @Test
    public void testComposeWithFloat() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            float expected = this.random.nextFloat();
            log.info("GIVEN - expected={}", expected);

            // When
            String actual = this.composer.compose(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotEmpty()
                    .isEqualTo("" + expected);
        });
    }

    @Test
    public void testComposeWithDouble() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            double expected = this.random.nextDouble();
            log.info("GIVEN - expected={}", expected);

            // When
            String actual = this.composer.compose(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotEmpty()
                    .isEqualTo("" + expected);
        });
    }

    @Test
    public void testComposeWithChar() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            char expected = random(1).charAt(0);
            log.info("GIVEN - expected={}", expected);

            // When
            String actual = this.composer.compose(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotEmpty()
                    .isEqualTo("" + expected);
        });
    }

    @Test
    public void testComposeWithString() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            String expected = random(this.random.nextInt(1, 10));
            log.info("GIVEN - expected={}", expected);

            // When
            String actual = this.composer.compose(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotEmpty()
                    .isSameAs(expected);
        });
    }

    @Test
    public void testComposeWithNullBooleans() throws Exception {
        assertThat(this.composer.compose((boolean[]) null))
                .isEqualTo(this.composer.compose((Object) null))
                .isNull();
    }

    @Test
    public void testComposeWithBooleans() throws Exception {
        // Given
        boolean[] expected = booleans(this.random.nextInt(1, ARRAY_MAX_LENGTH));
        log.info("GIVEN - expected={}", expected);

        // When
        String actual = this.composer.compose(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotEmpty();
        assertThat(containsSequence(actual, expected))
                .isTrue();
    }

    @Test
    public void testComposeWithBooleansAsObject() throws Exception {
        // Given
        boolean[] expected = booleans(this.random.nextInt(1, ARRAY_MAX_LENGTH));
        log.info("GIVEN - expected={}", expected);

        // When
        String actual = this.composer.compose((Object) expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotEmpty();
        assertThat(containsSequence(actual, expected))
                .isTrue();
    }

    @Test
    public void testComposeWithNullBytes() throws Exception {
        assertThat(this.composer.compose((byte[]) null))
                .isEqualTo(this.composer.compose((Object) null))
                .isNull();
    }

    @Test
    public void testComposeWithBytes() throws Exception {
        // Given
        byte[] expected = PrimitiveTypeUtilsTest.bytes(this.random.nextInt(1, ARRAY_MAX_LENGTH));
        log.info("GIVEN - expected={}", expected);

        // When
        String actual = this.composer.compose(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotEmpty();
        assertThat(containsSequence(actual, expected))
                .isTrue();
    }

    @Test
    public void testComposeWithBytesAsObject() throws Exception {
        // Given
        byte[] expected = PrimitiveTypeUtilsTest.bytes(this.random.nextInt(1, ARRAY_MAX_LENGTH));
        log.info("GIVEN - expected={}", expected);

        // When
        String actual = this.composer.compose((Object) expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotEmpty();
        assertThat(containsSequence(actual, expected))
                .isTrue();
    }

    @Test
    public void testComposeWithNullShorts() throws Exception {
        assertThat(this.composer.compose((short[]) null))
                .isEqualTo(this.composer.compose((Object) null))
                .isNull();
    }

    @Test
    public void testComposeWithShorts() throws Exception {
        // Given
        short[] expected = PrimitiveTypeUtilsTest.shorts(this.random.nextInt(1, ARRAY_MAX_LENGTH));
        log.info("GIVEN - expected={}", expected);

        // When
        String actual = this.composer.compose(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotEmpty();
        assertThat(containsSequence(actual, expected))
                .isTrue();
    }

    @Test
    public void testComposeWithShortsAsObject() throws Exception {
        // Given
        short[] expected = PrimitiveTypeUtilsTest.shorts(this.random.nextInt(1, ARRAY_MAX_LENGTH));
        log.info("GIVEN - expected={}", expected);

        // When
        String actual = this.composer.compose((Object) expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotEmpty();
        assertThat(containsSequence(actual, expected))
                .isTrue();
    }

    @Test
    public void testComposeWithNullInts() throws Exception {
        assertThat(this.composer.compose((int[]) null))
                .isEqualTo(this.composer.compose((Object) null))
                .isNull();
    }

    @Test
    public void testComposeWithInts() throws Exception {
        // Given
        int[] expected = PrimitiveTypeUtilsTest.ints(this.random.nextInt(1, ARRAY_MAX_LENGTH));
        log.info("GIVEN - expected={}", expected);

        // When
        String actual = this.composer.compose(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotEmpty();
        assertThat(containsSequence(actual, expected))
                .isTrue();
    }

    @Test
    public void testComposeWithIntsAsObject() throws Exception {
        // Given
        int[] expected = PrimitiveTypeUtilsTest.ints(this.random.nextInt(1, ARRAY_MAX_LENGTH));
        log.info("GIVEN - expected={}", expected);

        // When
        String actual = this.composer.compose((Object) expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotEmpty();
        assertThat(containsSequence(actual, expected))
                .isTrue();
    }

    @Test
    public void testComposeWithNullLongs() throws Exception {
        assertThat(this.composer.compose((long[]) null))
                .isEqualTo(this.composer.compose((Object) null))
                .isNull();
    }

    @Test
    public void testComposeWithLongs() throws Exception {
        // Given
        long[] expected = PrimitiveTypeUtilsTest.longs(this.random.nextInt(1, ARRAY_MAX_LENGTH));
        log.info("GIVEN - expected={}", expected);

        // When
        String actual = this.composer.compose(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotEmpty();
        assertThat(containsSequence(actual, expected))
                .isTrue();
    }

    @Test
    public void testComposeWithLongsAsObject() throws Exception {
        // Given
        long[] expected = PrimitiveTypeUtilsTest.longs(this.random.nextInt(1, ARRAY_MAX_LENGTH));
        log.info("GIVEN - expected={}", expected);

        // When
        String actual = this.composer.compose((Object) expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotEmpty();
        assertThat(containsSequence(actual, expected))
                .isTrue();
    }

    @Test
    public void testComposeWithNullFloats() throws Exception {
        assertThat(this.composer.compose((float[]) null))
                .isEqualTo(this.composer.compose((Object) null))
                .isNull();
    }

    @Test
    public void testComposeWithFloats() throws Exception {
        // Given
        float[] expected = PrimitiveTypeUtilsTest.floats(this.random.nextInt(1, ARRAY_MAX_LENGTH));
        log.info("GIVEN - expected={}", expected);

        // When
        String actual = this.composer.compose(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotEmpty();
        assertThat(containsSequence(actual, expected))
                .isTrue();
    }

    @Test
    public void testComposeWithFloatsAsObject() throws Exception {
        // Given
        float[] expected = PrimitiveTypeUtilsTest.floats(this.random.nextInt(1, ARRAY_MAX_LENGTH));
        log.info("GIVEN - expected={}", expected);

        // When
        String actual = this.composer.compose((Object) expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotEmpty();
        assertThat(containsSequence(actual, expected))
                .isTrue();
    }

    @Test
    public void testComposeWithNullDoubles() throws Exception {
        assertThat(this.composer.compose((double[]) null))
                .isEqualTo(this.composer.compose((Object) null))
                .isNull();
    }

    @Test
    public void testComposeWithDoubles() throws Exception {
        // Given
        double[] expected = PrimitiveTypeUtilsTest.doubles(this.random.nextInt(1, ARRAY_MAX_LENGTH));
        log.info("GIVEN - expected={}", expected);

        // When
        String actual = this.composer.compose(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotEmpty();
        assertThat(containsSequence(actual, expected))
                .isTrue();
    }

    @Test
    public void testComposeWithDoublesAsObject() throws Exception {
        // Given
        double[] expected = PrimitiveTypeUtilsTest.doubles(this.random.nextInt(1, ARRAY_MAX_LENGTH));
        log.info("GIVEN - expected={}", expected);

        // When
        String actual = this.composer.compose((Object) expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotEmpty();
        assertThat(containsSequence(actual, expected))
                .isTrue();
    }

    @Test
    public void testComposeWithNullChars() throws Exception {
        assertThat(this.composer.compose((char[]) null))
                .isEqualTo(this.composer.compose((Object) null))
                .isNull();
    }

    @Test
    public void testComposeWithChars() throws Exception {
        // Given
        char[] expected = PrimitiveTypeUtilsTest.chars(this.random.nextInt(1, ARRAY_MAX_LENGTH));
        log.info("GIVEN - expected={}", expected);

        // When
        String actual = this.composer.compose(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotEmpty();
        assertThat(containsSequence(actual, expected))
                .isTrue();
    }

    @Test
    public void testComposeWithCharsAsObject() throws Exception {
        // Given
        char[] expected = PrimitiveTypeUtilsTest.chars(this.random.nextInt(1, ARRAY_MAX_LENGTH));
        log.info("GIVEN - expected={}", expected);

        // When
        String actual = this.composer.compose((Object) expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotEmpty();
        assertThat(containsSequence(actual, expected))
                .isTrue();
    }

    @Test
    public void testComposeWithNullStrings() throws Exception {
        assertThat(this.composer.compose((String[]) null))
                .isNull();
    }

    @Test
    public void testComposeWithStrings() throws Exception {
        // Given
        String[] expected = strings(this.random.nextInt(1, ARRAY_MAX_LENGTH));
        log.info("GIVEN - expected={}", expected);

        // When
        String actual = this.composer.compose(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotEmpty();
        assertThat(containsSequence(actual, expected))
                .isTrue();
    }

    @Test
    public void testComposeWithNullObject() throws Exception {
        assertThat(this.composer.compose((Object) null))
                .isNull();
    }

    @Test
    public void testComposeWithObject() throws Exception {
        // Given
        Object expected = new Object();

        // When
        String actual = this.composer.compose(expected);

        // Then
        assertThat(actual)
                .isNotEmpty()
                .isEqualTo(expected.toString());
    }
}
