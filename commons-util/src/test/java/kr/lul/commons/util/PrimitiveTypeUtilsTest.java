package kr.lul.commons.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.copyOf;
import static java.util.stream.IntStream.range;
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

    private static final int ARRAY_LENGTH_BOUND = 10;
    private static final int LOOP_COUNT = 500;

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

    public static Character[] wrapperCharacters(int length) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Character[] array = new Character[length];
        for (int i = 0; i < length; i++) {
            array[i] = (char) random.nextInt(Character.MIN_VALUE, 1 + Character.MAX_VALUE);
        }
        return array;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private ThreadLocalRandom random;

    @Before
    public void setUp() throws Exception {
        if (null == this.random) {
            this.random = ThreadLocalRandom.current();
        } else {
            this.random.setSeed(this.random.nextLong());
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testBoxWithBoolean() throws Exception {
        assertThat(box(true))
                .isSameAs(Boolean.TRUE);
        assertThat(box(false))
                .isSameAs(Boolean.FALSE);
    }

    @Test
    public void testBoxWithByte() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            final byte expected = (byte) this.random.nextInt(Byte.MIN_VALUE, 1 + Byte.MAX_VALUE);
            log.info("GIVEN - expected={}", expected);

            // When
            Byte actual = box(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull()
                    .isEqualTo(expected);
        });
    }

    @Test
    public void testBoxWithWrapperByte() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            final Byte expected = (byte) this.random.nextInt(Byte.MIN_VALUE, 1 + Byte.MAX_VALUE);
            log.info("GIVEN - expected={}", expected);

            // When
            Byte actual = box(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull()
                    .isSameAs(expected);
        });
    }

    @Test
    public void testBoxWithShort() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            short expected = (short) this.random.nextInt(Short.MIN_VALUE, 1 + Short.MAX_VALUE);
            log.info("GIVEN - expected={}", expected);

            // When
            Short actual = box(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull()
                    .isEqualTo(expected);
        });
    }

    @Test
    public void testBoxWithWrapperShort() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            final Short expected = (short) this.random.nextInt(Short.MIN_VALUE, 1 + Short.MAX_VALUE);
            log.info("GIVEN - expected={}", expected);

            // When
            Short actual = box(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull()
                    .isSameAs(expected);
        });
    }

    @Test
    public void testBoxWithInt() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            final int expected = this.random.nextInt();
            log.info("GIVEN - expected={}", expected);

            // When
            Integer actual = box(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull()
                    .isEqualTo(expected);
        });
    }

    @Test
    public void testBoxWithWrapperInt() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            final Integer expected = this.random.nextInt();
            log.info("GIVEN - expected={}", expected);

            // When
            Integer actual = box(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull()
                    .isSameAs(expected);
        });
    }

    @Test
    public void testBoxWithLong() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            long expected = this.random.nextLong();
            log.info("GIVEN - expected={}", expected);

            // When
            Long actual = box(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull()
                    .isEqualTo(expected);
        });
    }

    @Test
    public void testBoxWithWrapperLong() throws Exception {
        range(0, LOOP_COUNT).forEach(l -> {
            final Long expected = this.random.nextLong();
            log.info("GIVEN - expected={}", expected);

            // When
            Long actual = box(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull()
                    .isSameAs(expected);
        });
    }

    @Test
    public void testBoxWithFloat() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            final float expected = this.random.nextFloat();
            log.info("GIVEN - expected={}", expected);

            // When
            Float actual = box(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull()
                    .isEqualTo(expected);
        });
    }

    @Test
    public void testBoxWithWrapperFloat() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            final Float expected = this.random.nextFloat();
            log.info("GIVEN - expected={}", expected);

            // When
            Float actual = box(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull()
                    .isSameAs(expected);
        });
    }

    @Test
    public void testBoxWithDouble() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            final double expected = this.random.nextDouble();
            log.info("GIVEN - expected={}", expected);

            // When
            Double actual = box(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull()
                    .isEqualTo(expected);
        });
    }

    @Test
    public void testBoxWithWrapperDouble() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            final Double expected = this.random.nextDouble();
            log.info("GIVEN - expected={}", expected);

            // When
            Double actual = box(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull()
                    .isSameAs(expected);
        });
    }

    @Test
    public void testBoxWithChar() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            final char expected = (char) this.random.nextInt(Character.MIN_VALUE, 1 + Character.MAX_VALUE);
            log.info("GIVEN - expected={}", expected);

            // When
            Character actual = box(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull()
                    .isEqualTo(expected);
        });
    }

    @Test
    public void testBoxWithWrapperChar() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            final Character expected = (char) this.random.nextInt(Character.MIN_VALUE, 1 + Character.MAX_VALUE);
            log.info("GIVEN - expected={}", expected);

            // When
            Character actual = box(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull()
                    .isSameAs(expected);
        });
    }

    @Test
    public void testBoxWithObject() throws Exception {
        // Given
        Object object = new Object();
        log.info("GIVEN - object={}", object);

        // When & Then
        assertThat(box(object))
                .isNotNull()
                .isSameAs(object);
    }

    @Test
    public void testBoxWithNull() throws Exception {
        assertThat(box((Object) null))
                .isNull();
    }

    @Test
    public void testBoxWithNullBooleans() throws Exception {
        assertThat(box((boolean[]) null))
                .isNull();
    }

    @Test
    public void testBoxWithBooleans() throws Exception {
        // Given
        boolean[] expected = booleans(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        Boolean[] actual = box(expected);
        log.info("WHEN - actual={}", Arrays.toString(actual));

        // Then
        assertThat(actual)
                .isNotNull()
                .hasSize(expected.length);
        for (int i = 0; i < expected.length; i++) {
            assertThat(actual[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testBoxWithBooleansAsObject() throws Exception {
        // Given
        boolean[] expected = booleans(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        Object actual = box((Object) expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .isNotSameAs(expected)
                .isInstanceOf(Boolean[].class);
        Boolean[] booleans = (Boolean[]) actual;
        assertThat(booleans)
                .hasSize(expected.length);
        for (int i = 0; i < booleans.length; i++) {
            assertThat(booleans[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testBoxWithNullBytes() throws Exception {
        assertThat(box((byte[]) null))
                .isNull();
    }

    @Test
    public void testBoxWithBytes() throws Exception {
        // Given
        byte[] expected = bytes(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        Byte[] actual = box(expected);
        log.info("WHEN - actual={}", Arrays.toString(actual));

        // Then
        assertThat(actual)
                .isNotNull()
                .hasSize(expected.length);
        for (int i = 0; i < expected.length; i++) {
            assertThat(actual[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testBoxWithBytesAsObject() throws Exception {
        // Given
        byte[] expected = bytes(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        Object actual = box((Object) expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .isNotSameAs(expected)
                .isInstanceOf(Byte[].class);
        Byte[] bytes = (Byte[]) actual;
        assertThat(bytes)
                .hasSize(expected.length);
        for (int i = 0; i < bytes.length; i++) {
            assertThat(bytes[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testBoxWithNullShorts() throws Exception {
        assertThat(box((short[]) null))
                .isNull();
    }

    @Test
    public void testBoxWithShorts() throws Exception {
        // Given
        short[] expected = shorts(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        Short[] actual = box(expected);
        log.info("WHEN - actual={}", Arrays.toString(actual));

        // Then
        assertThat(actual)
                .isNotNull()
                .hasSize(expected.length);
        for (int i = 0; i < expected.length; i++) {
            assertThat(actual[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testBoxWithShortsAsObject() throws Exception {
        // Given
        short[] expected = shorts(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        Object actual = box((Object) expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .isNotSameAs(expected)
                .isInstanceOf(Short[].class);
        Short[] shorts = (Short[]) actual;
        assertThat(shorts)
                .hasSize(expected.length);
        for (int i = 0; i < shorts.length; i++) {
            assertThat(shorts[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testBoxWithNullInts() throws Exception {
        assertThat(box((int[]) null))
                .isNull();
    }

    @Test
    public void testBoxWithInts() throws Exception {
        // Given
        int[] expected = ints(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        Integer[] actual = box(expected);
        log.info("WHEN - actual={}", Arrays.toString(actual));

        // Then
        assertThat(actual)
                .isNotNull()
                .hasSize(expected.length);
        for (int i = 0; i < expected.length; i++) {
            assertThat(actual[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testBoxWithIntsAsObject() throws Exception {
        // Given
        int[] expected = ints(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        Object actual = box((Object) expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .isNotSameAs(expected)
                .isInstanceOf(Integer[].class);
        Integer[] ints = (Integer[]) actual;
        assertThat(ints)
                .hasSize(expected.length);
        for (int i = 0; i < ints.length; i++) {
            assertThat(ints[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testBoxWithNullLongs() throws Exception {
        assertThat(box((long[]) null))
                .isNull();
    }

    @Test
    public void testBoxWithLongs() throws Exception {
        // Given
        long[] expected = longs(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        Long[] actual = box(expected);
        log.info("WHEN - actual={}", Arrays.toString(actual));

        // Then
        assertThat(actual)
                .isNotNull()
                .hasSize(expected.length);
        for (int i = 0; i < expected.length; i++) {
            assertThat(actual[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testBoxWithLongsAsObject() throws Exception {
        // Given
        long[] expected = longs(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        Object actual = box((Object) expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .isNotSameAs(expected)
                .isInstanceOf(Long[].class);
        Long[] longs = (Long[]) actual;
        assertThat(longs)
                .hasSize(expected.length);
        for (int i = 0; i < longs.length; i++) {
            assertThat(longs[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testBoxWithNullFloats() throws Exception {
        assertThat(box((float[]) null))
                .isNull();
    }

    @Test
    public void testBoxWithFloats() throws Exception {
        // Given
        float[] expected = floats(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        Float[] actual = box(expected);
        log.info("WHEN - actual={}", Arrays.toString(actual));

        // Then
        assertThat(actual)
                .isNotNull()
                .hasSize(expected.length);
        for (int i = 0; i < expected.length; i++) {
            assertThat(actual[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testBoxWithFloatsAsObject() throws Exception {
        // Given
        float[] expected = floats(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        Object actual = box((Object) expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .isNotSameAs(expected)
                .isInstanceOf(Float[].class);
        Float[] floats = (Float[]) actual;
        assertThat(floats)
                .hasSize(expected.length);
        for (int i = 0; i < floats.length; i++) {
            assertThat(floats[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testBoxWithNullDoubles() throws Exception {
        assertThat(box((double[]) null))
                .isNull();
    }

    @Test
    public void testBoxWithDoubles() throws Exception {
        // Given
        double[] expected = doubles(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        Double[] actual = box(expected);
        log.info("WHEN - actual={}", Arrays.toString(actual));

        // Then
        assertThat(actual)
                .isNotNull()
                .hasSize(expected.length);
        for (int i = 0; i < expected.length; i++) {
            assertThat(actual[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testBoxWithDoublesAsObject() throws Exception {
        // Given
        double[] expected = doubles(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        Object actual = box((Object) expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .isNotSameAs(expected)
                .isInstanceOf(Double[].class);
        Double[] doubles = (Double[]) actual;
        assertThat(doubles)
                .hasSize(expected.length);
        for (int i = 0; i < doubles.length; i++) {
            assertThat(doubles[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testBoxWithNullChars() throws Exception {
        assertThat(box((char[]) null))
                .isNull();
    }

    @Test
    public void testBoxWithChars() throws Exception {
        // Given
        char[] expected = chars(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        Character[] actual = box(expected);
        log.info("WHEN - actual={}", Arrays.toString(actual));

        // Then
        assertThat(actual)
                .isNotNull()
                .hasSize(expected.length);
        for (int i = 0; i < actual.length; i++) {
            assertThat(actual[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testBoxWithCharsAsObject() throws Exception {
        // Given
        char[] expected = chars(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        Object actual = box((Object) expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .isNotSameAs(expected)
                .isInstanceOf(Character[].class);
        Character[] characters = (Character[]) actual;
        assertThat(characters)
                .hasSize(expected.length);
        for (int i = 0; i < characters.length; i++) {
            assertThat(characters[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testBoxWithNullStrings() throws Exception {
        assertThat(box((String[]) null))
                .isNull();
    }

    @Test
    public void testBoxWithStrings() throws Exception {
        // Given
        String[] expected = strings(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        String[] actual = box(expected);
        log.info("WHEN - actual={}", Arrays.toString(actual));

        // Then
        assertThat(actual)
                .isNotNull()
                .isSameAs(expected);
        for (int i = 0; i < expected.length; i++) {
            assertThat(actual[i])
                    .isSameAs(expected[i]);
        }
    }

    @Test
    public void testBoxWithStringsAsObject() throws Exception {
        // Given
        String[] expected = strings(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        String[] backup = copyOf(expected, expected.length);
        log.info("GIVEN - expected={}", expected);

        // When
        Object actual = box((Object) expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .isSameAs(expected);
        String[] strings = (String[]) actual;
        assertThat(strings)
                .hasSize(backup.length);
        for (int i = 0; i < strings.length; i++) {
            assertThat(strings[i])
                    .isNotNull()
                    .isSameAs(backup[i]);
        }
    }

    @Test
    public void testBoxWithNullObjects() throws Exception {
        assertThat(box((Object[]) null))
                .isNull();
    }

    @Test
    public void testBoxWithObjects() throws Exception {
        // Given
        Object object1 = new Object();
        Object object2 = new Object();
        Object object3 = new Object();
        Object object4 = new Object();
        Object object5 = new Object();
        log.info("GIVEN - object1={}, object2={}, object3={}, object4={}, object5={}",
                object1, object2, object3, object4, object5);
        Object[] expected = new Object[]{object1, object2, object3, object4, object5};
        log.info("GIVEN - expected={}", expected);

        // When
        Object[] actual = box(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .hasSize(expected.length)
                .containsExactly(object1, object2, object3, object4, object5);
    }

    @Test
    public void testBoxWithObjectsAsObject() throws Exception {
        // Given
        Object object1 = new Object();
        Object object2 = new Object();
        Object object3 = new Object();
        Object object4 = new Object();
        Object object5 = new Object();
        log.info("GIVEN - object1={}, object2={}, object3={}, object4={}, object5={}",
                object1, object2, object3, object4, object5);
        Object[] expected = new Object[]{object1, object2, object3, object4, object5};
        Object[] backup = copyOf(expected, expected.length);
        log.info("GIVEN - expected={}", expected);

        // When
        Object actual = box((Object) expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .isSameAs(expected);
        Object[] objects = (Object[]) actual;
        assertThat(objects)
                .hasSize(backup.length);
        for (int i = 0; i < objects.length; i++) {
            assertThat(objects[i])
                    .isSameAs(backup[i]);
        }
    }

    @Test
    public void testUnboxWithNullWrapperClass() throws Exception {
        assertThat(unbox((Boolean) null))
                .isEqualTo(BOOLEAN_DEFAULT);
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
    public void testUnboxWithBoolean() throws Exception {
        assertThat(unbox(Boolean.TRUE))
                .isTrue();
        assertThat(unbox(Boolean.FALSE))
                .isFalse();
    }

    @Test
    public void testUnboxWithBooleanAsObject() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            Boolean expected = this.random.nextBoolean();
            log.info("GIVEN - expected={}", expected);

            // When
            Object actual = unbox((Object) expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull()
                    .isSameAs(expected);
        });
    }

    @Test
    public void testUnboxWithByte() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            Byte expected = (byte) this.random.nextInt(Byte.MIN_VALUE, 1 + Byte.MAX_VALUE);
            log.info("GIVEN - expected={}", expected);

            // When
            byte actual = unbox(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isEqualTo(expected);
        });
    }

    @Test
    public void testUnboxWithByteAsObject() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            Byte expected = (byte) this.random.nextInt(Byte.MIN_VALUE, 1 + Byte.MAX_VALUE);
            log.info("GIVEN - expected={}", expected);

            // When
            Object actual = unbox((Object) expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull()
                    .isSameAs(expected);
        });
    }

    @Test
    public void testUnboxWithShort() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            Short expected = (short) this.random.nextInt(Short.MIN_VALUE, 1 + Short.MAX_VALUE);
            log.info("GIVEN - expected={}", expected);

            // When
            short actual = unbox(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isEqualTo(expected);
        });
    }

    @Test
    public void testUnboxWithShortAsObject() throws Exception {
        // Given
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            Short expected = (short) this.random.nextInt(Short.MIN_VALUE, 1 + Short.MAX_VALUE);
            log.info("GIVEN - expected={}", expected);

            // When
            Object actual = unbox((Object) expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull()
                    .isSameAs(expected);
        });
    }

    @Test
    public void testUnboxWithInteger() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            Integer expected = this.random.nextInt();
            log.info("GIVEN - expected={}", expected);

            // When
            int actual = unbox(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isEqualTo(expected);
        });
    }

    @Test
    public void testUnboxWithIntegerAsObject() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            Integer expected = this.random.nextInt();
            log.info("GIVEN - expected={}", expected);

            // When
            Object actual = unbox((Object) expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isSameAs(expected);
        });
    }

    @Test
    public void testUnboxWithLong() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            Long expected = this.random.nextLong();
            log.info("GIVEN - expected={}", expected);

            // When
            long actual = unbox(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isEqualTo(expected);
        });
    }

    @Test
    public void testUnboxWithLongAsObject() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            Long expected = this.random.nextLong();
            log.info("GIVEN - expected={}", expected);

            // When
            Object actual = unbox((Object) expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isSameAs(expected);
        });
    }

    @Test
    public void testUnboxWithFloat() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            Float expected = this.random.nextFloat();
            log.info("GIVEN - expected={}", expected);

            // When
            float actual = unbox(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isEqualTo(expected);
        });
    }

    @Test
    public void testUnboxWithFloatAsObject() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            Float expected = this.random.nextFloat();
            log.info("GIVEN - expected={}", expected);

            // When
            Object actual = unbox((Object) expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isSameAs(expected);
        });
    }

    @Test
    public void testUnboxWithDouble() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            Double expected = this.random.nextDouble();
            log.info("GIVEN - expected={}", expected);

            // When
            double actual = unbox(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isEqualTo(expected);
        });
    }

    @Test
    public void testUnboxWithDoubleAsObject() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            Double expected = this.random.nextDouble();
            log.info("GIVEN - expected={}", expected);

            // When
            Object actual = unbox((Object) expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isSameAs(expected);
        });
    }

    @Test
    public void testUnboxWithNullBooleans() throws Exception {
        assertThat(unbox((Boolean[]) null))
                .isNull();
    }

    @Test
    public void testUnboxWithNullElementBooleans() throws Exception {
        // Given
        Boolean[] expected = new Boolean[]{null, null, null, null};
        log.info("GIVEN - expected={}", Arrays.toString(expected));

        // When
        boolean[] actual = unbox(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .hasSize(expected.length)
                .containsExactly(BOOLEAN_DEFAULT, BOOLEAN_DEFAULT, BOOLEAN_DEFAULT, BOOLEAN_DEFAULT);
    }

    @Test
    public void testUnboxWithWrapperBooleans() throws Exception {
        // Given
        Boolean[] expected = wrapperBooleans(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", Arrays.toString(expected));

        // When
        boolean[] actual = unbox(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .hasSize(expected.length);
        for (int i = 0; i < actual.length; i++) {
            assertThat(actual[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testUnboxWithWrapperBooleansAsObject() throws Exception {
        // Given
        Boolean[] expected = wrapperBooleans(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", Arrays.toString(expected));

        // When
        Object actual = unbox((Object) expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .isInstanceOf(boolean[].class);
        boolean[] booleans = (boolean[]) actual;
        assertThat(booleans)
                .hasSize(expected.length);
        for (int i = 0; i < booleans.length; i++) {
            assertThat(booleans[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testUnboxWithNullBytes() throws Exception {
        assertThat(unbox((Byte[]) null))
                .isNull();
    }

    @Test
    public void testUnboxWithNullElementBytes() throws Exception {
        // Given
        Byte[] expected = new Byte[]{null, null, null};
        log.info("GIVEN - expected={}", expected);

        // When
        byte[] actual = unbox(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .hasSize(expected.length)
                .containsExactly(BYTE_DEFAULT, BYTE_DEFAULT, BYTE_DEFAULT);
    }

    @Test
    public void testUnboxWithBytes() throws Exception {
        // Given
        Byte[] expected = wrapperBytes(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        byte[] actual = unbox(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .hasSize(expected.length);
        for (int i = 0; i < actual.length; i++) {
            assertThat(actual[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testUnboxWithBytesAsObject() throws Exception {
        // Given
        Byte[] expected = wrapperBytes(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        Object actual = unbox((Object) expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .isInstanceOf(byte[].class);
        byte[] bytes = (byte[]) actual;
        assertThat(bytes)
                .hasSize(expected.length);
        for (int i = 0; i < bytes.length; i++) {
            assertThat(bytes[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testUnboxWithNullShorts() throws Exception {
        assertThat(unbox((Short[]) null))
                .isNull();
    }

    @Test
    public void testUnboxWithNullElementShorts() throws Exception {
        // Given
        Short[] expected = new Short[]{null, null, null, null};
        log.info("GIVEN - expected={}", expected);

        // When
        short[] actual = unbox(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .hasSize(expected.length)
                .containsExactly(SHORT_DEFAULT, SHORT_DEFAULT, SHORT_DEFAULT, SHORT_DEFAULT);
    }

    @Test
    public void testUnboxWithShorts() throws Exception {
        // Given
        Short[] expected = wrapperShorts(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        short[] actual = unbox(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .hasSize(expected.length);
        for (int i = 0; i < actual.length; i++) {
            assertThat(actual[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testUnboxWithShortsAsObject() throws Exception {
        // Given
        Short[] expected = wrapperShorts(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        Object actual = unbox((Object) expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .isInstanceOf(short[].class);
        short[] shorts = (short[]) actual;
        assertThat(shorts)
                .hasSize(expected.length);
        for (int i = 0; i < shorts.length; i++) {
            assertThat(shorts[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testUnboxWithNullIntegers() throws Exception {
        assertThat(unbox((Integer[]) null))
                .isNull();
    }

    @Test
    public void testUnboxWithNullElementIntegers() throws Exception {
        // Given
        Integer[] expected = new Integer[]{null, null, null, null};
        log.info("GIVEN - expected={}", expected);

        // When
        int[] actual = unbox(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .hasSize(expected.length)
                .containsExactly(INT_DEFAULT, INT_DEFAULT, INT_DEFAULT, INT_DEFAULT);
    }

    @Test
    public void testUnboxWithIntegers() throws Exception {
        // Given
        Integer[] expected = wrapperIntegers(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        int[] actual = unbox(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .hasSize(expected.length);
        for (int i = 0; i < actual.length; i++) {
            assertThat(actual[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testUnboxWithIntegersAsObject() throws Exception {
        // Given
        Integer[] expected = wrapperIntegers(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        Object actual = unbox((Object) expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .isInstanceOf(int[].class);
        int[] ints = (int[]) actual;
        assertThat(ints)
                .hasSize(expected.length);
        for (int i = 0; i < ints.length; i++) {
            assertThat(ints[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testUnboxWithNullLongs() throws Exception {
        assertThat(unbox((Long[]) null))
                .isNull();
    }

    @Test
    public void testUnboxWithNullElementLongs() throws Exception {
        // Given
        Long[] expected = new Long[]{null, null, null, null};
        log.info("GIVEN - expected={}", expected);

        // When
        long[] actual = unbox(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .hasSize(expected.length)
                .containsExactly(LONG_DEFAULT, LONG_DEFAULT, LONG_DEFAULT, LONG_DEFAULT);
    }

    @Test
    public void testUnboxWithLongs() throws Exception {
        // Given
        Long[] expected = wrapperLongs(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        long[] actual = unbox(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .hasSize(expected.length);
        for (int i = 0; i < actual.length; i++) {
            assertThat(actual[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testUnboxWithLongsAsObject() throws Exception {
        // Given
        Long[] expected = wrapperLongs(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        Object actual = unbox((Object) expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .isInstanceOf(long[].class);
        long[] longs = (long[]) actual;
        assertThat(longs)
                .hasSize(expected.length);
        for (int i = 0; i < longs.length; i++) {
            assertThat(longs[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testUnboxWithNullFloats() throws Exception {
        assertThat(unbox((Float[]) null))
                .isNull();
    }

    @Test
    public void testUnboxWithNullElementFloats() throws Exception {
        // Given
        Float[] expected = new Float[]{null, null, null, null};
        log.info("GIVEN - expected={}", expected);

        // When
        float[] actual = unbox(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .containsExactly(FLOAT_DEFAULT, FLOAT_DEFAULT, FLOAT_DEFAULT, FLOAT_DEFAULT);
    }

    @Test
    public void testUnboxWithFloats() throws Exception {
        // Given
        Float[] expected = wrapperFloats(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        float[] actual = unbox(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .hasSize(expected.length);
        for (int i = 0; i < actual.length; i++) {
            assertThat(actual[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testUnboxWithFloatsAsObject() throws Exception {
        // Given
        Float[] expected = wrapperFloats(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        Object actual = unbox((Object) expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .isInstanceOf(float[].class);
        float[] floats = (float[]) actual;
        assertThat(floats)
                .hasSize(expected.length);
        for (int i = 0; i < floats.length; i++) {
            assertThat(floats[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testUnboxWithNullDoubles() throws Exception {
        assertThat(unbox((Double[]) null))
                .isNull();
    }

    @Test
    public void testUnboxWithNullElementDoubles() throws Exception {
        // Given
        Double[] expected = new Double[]{null, null, null, null};
        log.info("GIVEN - expected={}", expected);

        // When
        double[] actual = unbox(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .hasSize(expected.length)
                .containsExactly(DOUBLE_DEFAULT, DOUBLE_DEFAULT, DOUBLE_DEFAULT, DOUBLE_DEFAULT);
    }

    @Test
    public void testUnboxWithDoubles() throws Exception {
        // Given
        Double[] expected = wrapperDoubles(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        double[] actual = unbox(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .hasSize(expected.length);
        for (int i = 0; i < actual.length; i++) {
            assertThat(actual[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testUnboxWithDoublesAsObject() throws Exception {
        // Given
        Double[] expected = wrapperDoubles(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        Object actual = unbox((Object) expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .isInstanceOf(double[].class);
        double[] doubles = (double[]) actual;
        assertThat(doubles)
                .hasSize(expected.length);
        for (int i = 0; i < doubles.length; i++) {
            assertThat(doubles[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testUnboxWithNullCharacters() throws Exception {
        assertThat(unbox((Character[]) null))
                .isNull();
    }

    @Test
    public void testUnboxWithNullElementCharacters() throws Exception {
        // Given
        Character[] expected = new Character[]{null, null, null, null};
        log.info("GIVEN - expected={}", expected);

        // When
        char[] actual = unbox(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .hasSize(expected.length)
                .containsExactly(CHAR_DEFAULT, CHAR_DEFAULT, CHAR_DEFAULT, CHAR_DEFAULT);
    }

    @Test
    public void testUnboxWithCharacters() throws Exception {
        // Given
        Character[] expected = wrapperCharacters(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        char[] actual = unbox(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .hasSize(expected.length);
        for (int i = 0; i < actual.length; i++) {
            assertThat(actual[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testUnboxWithCharactersAsObject() throws Exception {
        // Given
        Character[] expected = wrapperCharacters(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        log.info("GIVEN - expected={}", expected);

        // When
        Object actual = unbox((Object) expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .isInstanceOf(char[].class);
        char[] chars = (char[]) actual;
        assertThat(chars)
                .hasSize(expected.length);
        for (int i = 0; i < chars.length; i++) {
            assertThat(chars[i])
                    .isEqualTo(expected[i]);
        }
    }

    @Test
    public void testUnboxWithNullObjects() throws Exception {
        assertThat(unbox((Object[]) null))
                .isNull();
    }

    @Test
    public void testUnboxWithObjects() throws Exception {
        // Given
        Object object1 = new Object();
        Object object2 = new Object();
        Object object3 = new Object();
        Object object4 = new Object();
        Object object5 = new Object();
        log.info("GIVEN - object1={}, object2={}, object3={}, object4={}, object5={}",
                object1, object2, object3, object4, object5);
        Object[] expected = new Object[]{object1, object2, object3, object4, object5};
        log.info("GIVEN - expected={}", expected);

        // When
        Object[] actual = unbox(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .hasSize(expected.length)
                .containsExactly(object1, object2, object3, object4, object5);
    }

    @Test
    public void testUnboxWithObjectsAsObject() throws Exception {
        // Given
        Object object1 = new Object();
        Object object2 = new Object();
        Object object3 = new Object();
        Object object4 = new Object();
        Object object5 = new Object();
        log.info("GIVEN - object1={}, object2={}, object3={}, object4={}, object5={}",
                object1, object2, object3, object4, object5);
        Object[] expected = new Object[]{object1, object2, object3, object4, object5};
        log.info("GIVEN - expected={}", expected);

        // When
        Object actual = unbox((Object) expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .isInstanceOf(Object[].class)
                .isSameAs(expected);
        assertThat((Object[]) actual)
                .hasSize(expected.length)
                .containsExactly(object1, object2, object3, object4, object5);
    }

    @Test
    public void testUnboxWithStrings() throws Exception {
        // Given
        String[] expected = strings(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        String[] backup = Arrays.copyOf(expected, expected.length);
        log.info("GIVEN - expected={}", expected);

        // When
        String[] actual = unbox(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .isSameAs(expected)
                .hasSize(expected.length);
        for (int i = 0; i < actual.length; i++) {
            assertThat(actual[i])
                    .isSameAs(backup[i]);
        }
    }

    @Test
    public void testUnboxWithStringsAsObject() throws Exception {
        // Given
        String[] expected = strings(this.random.nextInt(1, ARRAY_LENGTH_BOUND));
        String[] backup = Arrays.copyOf(expected, expected.length);
        log.info("GIVEN - expected={}", expected);

        // When
        Object actual = unbox((Object) expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isNotNull()
                .isSameAs(expected);
        String[] strings = (String[]) actual;
        assertThat(strings)
                .hasSize(expected.length);
        for (int i = 0; i < strings.length; i++) {
            assertThat(strings[i])
                    .isSameAs(backup[i]);
        }
    }
}
