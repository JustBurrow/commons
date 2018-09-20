package kr.lul.commons.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static kr.lul.commons.util.JavaLangConstants.*;
import static kr.lul.commons.util.PrimitiveTypeUtils.box;
import static kr.lul.commons.util.PrimitiveTypeUtils.unbox;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2018. 9. 20.
 */
public class PrimitiveTypeUtilsTest {
    private static final Logger log = getLogger(PrimitiveTypeUtilsTest.class);

    private ThreadLocalRandom random;

    public static boolean[] booleans(int length) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        boolean[] array = new boolean[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextBoolean();
        }
        return array;
    }

    public static byte[] bytes(int length) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        byte[] array = new byte[length];
        for (int i = 0; i < length; i++) {
            array[i] = (byte) random.nextInt(Byte.MIN_VALUE, 1 + Byte.MAX_VALUE);
        }
        return array;
    }

    public static short[] shorts(int length) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        short[] array = new short[length];
        for (int i = 0; i < length; i++) {
            array[i] = (short) random.nextInt(Short.MIN_VALUE, 1 + Short.MAX_VALUE);
        }
        return array;
    }

    public static int[] ints(int length) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    public static long[] longs(int length) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        long[] array = new long[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextLong();
        }
        return array;
    }

    public static float[] floats(int length) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        float[] array = new float[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextFloat();
        }
        return array;
    }

    public static double[] doubles(int length) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        double[] array = new double[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextDouble();
        }
        return array;
    }

    public static char[] chars(int length) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        char[] array = new char[length];
        for (int i = 0; i < length; i++) {
            array[i] = (char) random.nextInt(Character.MIN_VALUE, 1 + Character.MAX_VALUE);
        }
        return array;
    }

    public static String[] strings(int length) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            array[i] = RandomStringUtils.random(random.nextInt(0, 10));
        }
        return array;
    }

    public static Boolean[] wrapperBooleans(int length) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Boolean[] array = new Boolean[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextBoolean();
        }
        return array;
    }

    public static Byte[] wrapperBytes(int length) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Byte[] array = new Byte[length];
        for (int i = 0; i < length; i++) {
            array[i] = (byte) random.nextInt(Byte.MIN_VALUE, 1 + Byte.MAX_VALUE);
        }
        return array;
    }

    public static Short[] wrapperShorts(int length) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Short[] array = new Short[length];
        for (int i = 0; i < length; i++) {
            array[i] = (short) random.nextInt(Short.MIN_VALUE, 1 + Short.MAX_VALUE);
        }
        return array;
    }

    public static Integer[] wrapperIntegers(int length) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    public static Long[] wrapperLongs(int length) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Long[] array = new Long[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextLong();
        }
        return array;
    }

    public static Float[] wrapperFloats(int length) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Float[] array = new Float[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextFloat();
        }
        return array;
    }

    public static Double[] wrapperDoubles(int length) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Double[] array = new Double[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextDouble();
        }
        return array;
    }

    @Before
    public void setUp() throws Exception {
        if (null == this.random) {
            this.random = ThreadLocalRandom.current();
        } else {
            this.random.setSeed(this.random.nextLong());
        }
    }

    @Test
    public void testBoxWithObject() throws Exception {
        // Given
        Object object = new Object();
        log.info("GIVEN - object={}", object);

        // When & Then
        assertThat(box(object))
                .isSameAs(object);
    }

    @Test
    public void testBoxWithBooleans() throws Exception {
        // Given
        boolean[] expected = booleans(this.random.nextInt(1, 10));
        log.info("GIVEN - expected={}", expected);

        // When
        Boolean[] actual = box(expected);
        log.info("WHEN - actual={}", Arrays.toString(actual));

        // Then
        assertThat(actual)
                .hasSize(expected.length);
        for (int i = 0; i < expected.length; i++) {
            assertThat(actual[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testBoxWithBytes() throws Exception {
        // Given
        byte[] expected = bytes(this.random.nextInt(1, 10));
        log.info("GIVEN - expected={}", expected);

        // When
        Byte[] actual = box(expected);
        log.info("WHEN - actual={}", Arrays.toString(actual));

        // Then
        assertThat(actual)
                .hasSize(expected.length);
        for (int i = 0; i < expected.length; i++) {
            assertThat(actual[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testBoxWithShorts() throws Exception {
        // Given
        short[] expected = shorts(this.random.nextInt(1, 10));
        log.info("GIVEN - expected={}", expected);

        // When
        Short[] actual = box(expected);
        log.info("WHEN - actual={}", Arrays.toString(actual));

        // Then
        assertThat(actual)
                .hasSize(expected.length);
        for (int i = 0; i < expected.length; i++) {
            assertThat(actual[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testBoxWithInts() throws Exception {
        // Given
        int[] expected = ints(this.random.nextInt(1, 10));
        log.info("GIVEN - expected={}", expected);

        // When
        Integer[] actual = box(expected);
        log.info("WHEN - actual={}", Arrays.toString(actual));

        // Then
        assertThat(actual)
                .hasSize(expected.length);
        for (int i = 0; i < expected.length; i++) {
            assertThat(actual[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testBoxWithLongs() throws Exception {
        // Given
        long[] expected = longs(this.random.nextInt(1, 10));
        log.info("GIVEN - expected={}", expected);

        // When
        Long[] actual = box(expected);
        log.info("WHEN - actual={}", Arrays.toString(actual));

        // Then
        assertThat(actual)
                .hasSize(expected.length);
        for (int i = 0; i < expected.length; i++) {
            assertThat(actual[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testBoxWithFloats() throws Exception {
        // Given
        float[] expected = floats(this.random.nextInt(1, 10));
        log.info("GIVEN - expected={}", expected);

        // When
        Float[] actual = box(expected);
        log.info("WHEN - actual={}", Arrays.toString(actual));

        // Then
        assertThat(actual)
                .hasSize(expected.length);
        for (int i = 0; i < expected.length; i++) {
            assertThat(actual[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testBoxWithDoubles() throws Exception {
        // Given
        double[] expected = doubles(this.random.nextInt(1, 10));
        log.info("GIVEN - expected={}", expected);

        // When
        Double[] actual = box(expected);
        log.info("WHEN - actual={}", Arrays.toString(actual));

        // Then
        assertThat(actual)
                .hasSize(expected.length);
        for (int i = 0; i < expected.length; i++) {
            assertThat(actual[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testBoxWithChars() throws Exception {
        // Given
        char[] expected = chars(this.random.nextInt(1, 10));
        log.info("GIVEN - expected={}", expected);

        // When
        Character[] actual = box(expected);
        log.info("WHEN - actual={}", Arrays.toString(actual));

        // Then
        assertThat(actual)
                .hasSize(expected.length);
        for (int i = 0; i < actual.length; i++) {
            assertThat(actual[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testBoxWithStrings() throws Exception {
        // Given
        String[] expected = strings(this.random.nextInt(1, 10));
        log.info("GIVEN - expected={}", expected);

        // When
        String[] actual = box(expected);
        log.info("WHEN - actual={}", Arrays.toString(actual));

        // Then
        assertThat(actual)
                .isSameAs(expected);
        for (int i = 0; i < expected.length; i++) {
            assertThat(actual[i])
                    .isSameAs(expected[i]);
        }
    }

    @Test
    public void testUnboxWithBoolean() throws Exception {
        assertThat(unbox((Boolean) null))
                .isEqualTo(BOOLEAN_DEFAULT);
        assertThat(unbox(Boolean.TRUE))
                .isTrue();
        assertThat(unbox(Boolean.FALSE))
                .isFalse();
    }

    @Test
    public void testUnboxWithNullWrapperClass() throws Exception {
        assertThat(unbox((Byte) null))
                .isEqualTo(BYTE_DEFAULT);
        assertThat(unbox((Short) null))
                .isEqualTo(SHORT_DEFAULT);
        assertThat(unbox((Integer) null))
                .isEqualTo(INT_DEFAULT);
        assertThat(unbox((Long) null))
                .isEqualTo(LONG_DEFAULT);
        assertThat(unbox((Float) null))
                .isEqualTo(FLOAT_DEFAULT);
        assertThat(unbox((Double) null))
                .isEqualTo(DOUBLE_DEFAULT);
        assertThat(unbox((Character) null))
                .isEqualTo(CHAR_DEFAULT);
        assertThat(unbox((Object) null))
                .isNull();
        assertThat(unbox((String) null))
                .isNull();
    }

    @Test
    public void testUnboxWithByte() throws Exception {
        // Given
        Byte expected = (byte) this.random.nextInt(Byte.MIN_VALUE, 1 + Byte.MAX_VALUE);
        log.info("GIVEN - expected={}", expected);

        // When
        byte actual = unbox(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    public void testUnboxWithShort() throws Exception {
        // Given
        Short expected = (short) this.random.nextInt(Short.MIN_VALUE, 1 + Short.MAX_VALUE);
        log.info("GIVEN - expected={}", expected);

        // When
        short actual = unbox(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    public void testUnboxWithInteger() throws Exception {
        // Given
        Integer expected = this.random.nextInt();
        log.info("GIVEN - expected={}", expected);

        // When
        int actual = unbox(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    public void testUnboxWithLong() throws Exception {
        // Given
        Long expected = this.random.nextLong();
        log.info("GIVEN - expected={}", expected);

        // When
        long actual = unbox(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    public void testUnboxWithFloat() throws Exception {
        // Given
        Float expected = this.random.nextFloat();
        log.info("GIVEN - expected={}", expected);

        // When
        float actual = unbox(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    public void testUnboxWithDouble() throws Exception {
        // Given
        Double expected = this.random.nextDouble();
        log.info("GIVEN - expected={}", expected);

        // When
        double actual = unbox(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    public void testUnboxWithWrapperBooleans() throws Exception {
        // Given
        Boolean[] expected = wrapperBooleans(this.random.nextInt(1, 10));
        log.info("GIVEN - expected={}", Arrays.toString(expected));

        // When
        boolean[] actual = unbox(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .hasSize(expected.length);
        for (int i = 0; i < actual.length; i++) {
            assertThat(actual[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testUnboxWithNullWrapperBooleans() throws Exception {
        // Given
        Boolean[] expected = new Boolean[]{null, null, null, null};
        log.info("GIVEN - expected={}", Arrays.toString(expected));

        // When
        boolean[] actual = unbox(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .hasSize(expected.length)
                .containsExactly(BOOLEAN_DEFAULT, BOOLEAN_DEFAULT, BOOLEAN_DEFAULT, BOOLEAN_DEFAULT);
    }
}
