package kr.lul.commons.util;

import static kr.lul.commons.util.JavaLangConstants.*;

/**
 * 기본 자료형과 기본 자료형의 래퍼 클래스의 유틸리티 메서드 모음.
 *
 * @author justburrow
 * @since 2018. 9. 20.
 */
public abstract class PrimitiveTypeUtils {
    /**
     * 기본 자료형을 래퍼 클래스 오브젝트로 변환한다.
     *
     * @param b {@code boolean} 값.
     *
     * @return {@link Boolean} 오브젝트.
     */
    public static Boolean box(boolean b) {
        return b;
    }

    /**
     * 기본 자료형을 래퍼 클래스 오브젝트로 변환한다.
     *
     * @param b {@code byte} 값.
     *
     * @return {@link Byte} 오브젝트.
     */
    public static Byte box(byte b) {
        return b;
    }

    /**
     * 기본 자료형을 래퍼 클래스 오브젝트로 변환한다.
     *
     * @param s {@code short} 값.
     *
     * @return {@link Short} 오브젝트.
     */
    public static Short box(short s) {
        return s;
    }

    /**
     * 기본 자료형을 래퍼 클래스 오브젝트로 변환한다.
     *
     * @param i {@code int} 값.
     *
     * @return {@link Integer} 오브젝트.
     */
    public static Integer box(int i) {
        return i;
    }

    /**
     * 기본 자료형을 래퍼 클래스 오브젝트로 변환한다.
     *
     * @param l {@code long} 값.
     *
     * @return {@link Long} 오브젝트.
     */
    public static Long box(long l) {
        return l;
    }

    /**
     * 기본 자료형을 래퍼 클래스 오브젝트로 변환한다.
     *
     * @param f {@code float} 값.
     *
     * @return {@link Float} 오브젝트.
     */
    public static Float box(float f) {
        return f;
    }

    /**
     * 기본 자료형을 래퍼 클래스 오브젝트로 변환한다.
     *
     * @param d {@code double} 값.
     *
     * @return {@link Double } 오브젝트.
     */
    public static Double box(double d) {
        return d;
    }

    /**
     * 기본 자료형을 래퍼 클래스 오브젝트로 변환한다.
     *
     * @param c {@code char} 값.
     *
     * @return {@link Character} 오브젝트.
     */
    public static Character box(char c) {
        return c;
    }

    /**
     * {@link PrimitiveTypeUtils} 사용자 측이 자료형에 따른 분기문을 작성하지 않아도 되도록 별도의 기능이 없는 메서드를 추가.
     *
     * @param object 임의의 오브젝트.
     * @param <T>    오브젝트의 자료형.
     *
     * @return 인자로 받은 오브젝트.
     */
    public static <T> T box(T object) {
        if (null == object) {
            return null;
        } else if (!object.getClass().isArray()) {
            return object;
        }

        switch (object.getClass().getName()) {
            case BOOLEAN_TYPE_ARRAY_CLASS_NAME:
                return (T) box((boolean[]) object);
            case BYTE_TYPE_ARRAY_CLASS_NAME:
                return (T) box((byte[]) object);
            case SHORT_TYPE_ARRAY_CLASS_NAME:
                return (T) box((short[]) object);
            case INTEGER_TYPE_ARRAY_CLASS_NAME:
                return (T) box((int[]) object);
            case LONG_TYPE_ARRAY_CLASS_NAME:
                return (T) box((long[]) object);
            case FLOAT_TYPE_ARRAY_CLASS_NAME:
                return (T) box((float[]) object);
            case DOUBLE_TYPE_ARRAY_CLASS_NAME:
                return (T) box((double[]) object);
            case CHARACTER_TYPE_ARRAY_CLASS_NAME:
                return (T) box((char[]) object);
            default:
                return object;
        }
    }

    /**
     * 기본 자료형의 배열을 래퍼 클래스의 비열로 변환한다.
     *
     * @param booleans {@code boolean} 배열.
     *
     * @return {@link Boolean} 배열.
     */
    public static Boolean[] box(boolean[] booleans) {
        if (null == booleans) {
            return null;
        }

        Boolean[] array = new Boolean[booleans.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = booleans[i];
        }
        return array;
    }

    /**
     * 기본 자료형의 배열을 래퍼 클래스의 비열로 변환한다.
     *
     * @param bytes {@code byte} 배열.
     *
     * @return {@link Byte} 배열.
     */
    public static Byte[] box(byte[] bytes) {
        if (null == bytes) {
            return null;
        }

        Byte[] array = new Byte[bytes.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = bytes[i];
        }
        return array;
    }

    /**
     * 기본 자료형의 배열을 래퍼 클래스의 비열로 변환한다.
     *
     * @param shorts {@code short} 배열.
     *
     * @return {@link Short} 배열.
     */
    public static Short[] box(short[] shorts) {
        if (null == shorts) {
            return null;
        }

        Short[] array = new Short[shorts.length];
        for (int i = 0; i < shorts.length; i++) {
            array[i] = shorts[i];
        }
        return array;
    }

    /**
     * 기본 자료형의 배열을 래퍼 클래스의 비열로 변환한다.
     *
     * @param ints {@code int} 배열.
     *
     * @return {@link Integer} 배열.
     */
    public static Integer[] box(int[] ints) {
        if (null == ints) {
            return null;
        }

        Integer[] array = new Integer[ints.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = ints[i];
        }
        return array;
    }

    /**
     * 기본 자료형의 배열을 래퍼 클래스의 비열로 변환한다.
     *
     * @param longs {@code long} 배열.
     *
     * @return {@link Long} 배열.
     */
    public static Long[] box(long[] longs) {
        if (null == longs) {
            return null;
        }

        Long[] array = new Long[longs.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = longs[i];
        }
        return array;
    }

    /**
     * 기본 자료형의 배열을 래퍼 클래스의 비열로 변환한다.
     *
     * @param floats {@code float} 배열.
     *
     * @return {@link Float} 배열.
     */
    public static Float[] box(float[] floats) {
        if (null == floats) {
            return null;
        }

        Float[] array = new Float[floats.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = floats[i];
        }
        return array;
    }

    /**
     * 기본 자료형의 배열을 래퍼 클래스의 비열로 변환한다.
     *
     * @param doubles {@code double} 배열.
     *
     * @return {@link Double} 배열.
     */
    public static Double[] box(double[] doubles) {
        if (null == doubles) {
            return null;
        }

        Double[] array = new Double[doubles.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = doubles[i];
        }
        return array;
    }

    /**
     * 기본 자료형의 배열을 래퍼 클래스의 비열로 변환한다.
     *
     * @param chars {@code char} 배열.
     *
     * @return {@link Character} 배열.
     */
    public static Character[] box(char[] chars) {
        if (null == chars) {
            return null;
        }

        Character[] array = new Character[chars.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = chars[i];
        }
        return array;
    }

    /**
     * {@link PrimitiveTypeUtils} 사용자 측이 자료형에 따른 분기문을 작성하지 않아도 되도록 별도의 기능이 없는 메서드를 추가.
     *
     * @param objects 오브젝트 배열.
     * @param <T>     오브젝트 타입.
     *
     * @return 인자로 받은 오브젝트 배열.
     */
    public static <T> T[] box(T[] objects) {
        return objects;
    }

    /**
     * 래퍼 클래스의 오브젝트를 기본 자료형으로 반환한다.
     *
     * @param b {@link Boolean} 오브젝트.
     *
     * @return {@code boolean} 값.
     *
     * @see JavaLangConstants#BOOLEAN_DEFAULT {@link Boolean} 오브젝트가 {@code null}일 때.
     */
    public static boolean unbox(Boolean b) {
        return null == b
                ? BOOLEAN_DEFAULT
                : b;
    }

    /**
     * 래퍼 클래스의 오브젝트를 기본 자료형으로 반환한다.
     *
     * @param b {@link Byte} 오브젝트.
     *
     * @return {@code byte} 값.
     *
     * @see JavaLangConstants#BYTE_DEFAULT {@link Byte} 오브젝트가 {@code null}일 때.
     */
    public static byte unbox(Byte b) {
        return null == b
                ? BYTE_DEFAULT
                : b;
    }

    /**
     * 래퍼 클래스의 오브젝트를 기본 자료형으로 반환한다.
     *
     * @param s {@link Short} 오브젝트.
     *
     * @return {@code short} 값.
     *
     * @see JavaLangConstants#SHORT_DEFAULT {@link Short} 오브젝트가 {@code null}일 때.
     */
    public static short unbox(Short s) {
        return null == s
                ? SHORT_DEFAULT
                : s;
    }

    /**
     * 래퍼 클래스의 오브젝트를 기본 자료형으로 반환한다.
     *
     * @param i {@link Integer} 오브젝트.
     *
     * @return {@code int} 값.
     *
     * @see JavaLangConstants#INT_DEFAULT {@link Integer} 오브젝트가 {@code null}일 때.
     */
    public static int unbox(Integer i) {
        return null == i
                ? INT_DEFAULT
                : i;
    }

    /**
     * 래퍼 클래스의 오브젝트를 기본 자료형으로 반환한다.
     *
     * @param l {@link Long} 오브젝트.
     *
     * @return {@code long} 값.
     *
     * @see JavaLangConstants#LONG_DEFAULT {@link Long} 오브젝트가 {@code null}일 때.
     */
    public static long unbox(Long l) {
        return null == l
                ? LONG_DEFAULT
                : l;
    }

    /**
     * 래퍼 클래스의 오브젝트를 기본 자료형으로 반환한다.
     *
     * @param f {@link Float} 오브젝트.
     *
     * @return {@code float} 값.
     *
     * @see JavaLangConstants#FLOAT_DEFAULT {@link Float} 오브젝트가 {@code null}일 때.
     */
    public static float unbox(Float f) {
        return null == f
                ? FLOAT_DEFAULT
                : f;
    }

    /**
     * 래퍼 클래스의 오브젝트를 기본 자료형으로 반환한다.
     *
     * @param d {@link Double} 오브젝트.
     *
     * @return {@code double} 값.
     *
     * @see JavaLangConstants#DOUBLE_DEFAULT {@link Double} 오브젝트가 {@code null}일 때.
     */
    public static double unbox(Double d) {
        return null == d
                ? DOUBLE_DEFAULT
                : d;
    }

    /**
     * 래퍼 클래스의 오브젝트를 기본 자료형으로 반환한다.
     *
     * @param c {@link Character} 오브젝트.
     *
     * @return {@code char} 값.
     *
     * @see JavaLangConstants#CHAR_DEFAULT {@link Character} 오브젝트가 {@code null}일 때.
     */
    public static char unbox(Character c) {
        return null == c
                ? CHAR_DEFAULT
                : c;
    }

    /**
     * 래퍼 클래스 배열을 기본 자료형 배열로 변환한다.
     *
     * @param booleans {@link Boolean} 배열.
     *
     * @return {@code boolean} 배열.
     *
     * @see JavaLangConstants#BOOLEAN_DEFAULT 인자로 받은 배열의 엘리먼트가 {@code null}일 때 사용.
     */
    public static boolean[] unbox(Boolean[] booleans) {
        if (null == booleans) {
            return null;
        }

        boolean[] array = new boolean[booleans.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = null == booleans[i]
                    ? BOOLEAN_DEFAULT
                    : booleans[i];
        }
        return array;
    }

    /**
     * 래퍼 클래스 배열을 기본 자료형 배열로 변환한다.
     *
     * @param bytes {@link Byte} 배열.
     *
     * @return {@code byte} 배열.
     *
     * @see JavaLangConstants#BYTE_DEFAULT 인자로 받은 배열의 엘리먼트가 {@code null}일 때 사용.
     */
    public static byte[] unbox(Byte[] bytes) {
        if (null == bytes) {
            return null;
        }

        byte[] array = new byte[bytes.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = null == bytes[i]
                    ? BYTE_DEFAULT
                    : bytes[i];
        }
        return array;
    }

    /**
     * 래퍼 클래스 배열을 기본 자료형 배열로 변환한다.
     *
     * @param shorts {@link Short} 배열.
     *
     * @return {@code short} 배열.
     *
     * @see JavaLangConstants#SHORT_DEFAULT 인자로 받은 배열의 엘리먼트가 {@code null}일 때 사용.
     */
    public static short[] unbox(Short[] shorts) {
        if (null == shorts) {
            return null;
        }

        short[] array = new short[shorts.length];
        for (int i = 0; i < shorts.length; i++) {
            array[i] = null == shorts[i]
                    ? SHORT_DEFAULT
                    : shorts[i];
        }
        return array;
    }

    /**
     * 래퍼 클래스 배열을 기본 자료형 배열로 변환한다.
     *
     * @param integers {@link Integer} 배열.
     *
     * @return {@code int} 배열.
     *
     * @see JavaLangConstants#INT_DEFAULT 인자로 받은 배열의 엘리먼트가 {@code null}일 때 사용.
     */
    public static int[] unbox(Integer[] integers) {
        if (null == integers) {
            return null;
        }

        int[] array = new int[integers.length];
        for (int i = 0; i < integers.length; i++) {
            array[i] = null == integers[i]
                    ? INT_DEFAULT
                    : integers[i];
        }
        return array;
    }

    /**
     * 래퍼 클래스 배열을 기본 자료형 배열로 변환한다.
     *
     * @param longs {@link Long} 배열.
     *
     * @return {@code long} 배열.
     *
     * @see JavaLangConstants#LONG_DEFAULT 인자로 받은 배열의 엘리먼트가 {@code null}일 때 사용.
     */
    public static long[] unbox(Long[] longs) {
        if (null == longs) {
            return null;
        }

        long[] array = new long[longs.length];
        for (int i = 0; i < longs.length; i++) {
            array[i] = null == longs[i]
                    ? LONG_DEFAULT
                    : longs[i];
        }
        return array;
    }

    /**
     * 래퍼 클래스 배열을 기본 자료형 배열로 변환한다.
     *
     * @param floats {@link Float} 배열.
     *
     * @return {@code float} 배열.
     *
     * @see JavaLangConstants#FLOAT_DEFAULT 인자로 받은 배열의 엘리먼트가 {@code null}일 때 사용.
     */
    public static float[] unbox(Float[] floats) {
        if (null == floats) {
            return null;
        }

        float[] array = new float[floats.length];
        for (int i = 0; i < floats.length; i++) {
            array[i] = null == floats[i]
                    ? FLOAT_DEFAULT
                    : floats[i];
        }
        return array;
    }

    /**
     * 래퍼 클래스 배열을 기본 자료형 배열로 변환한다.
     *
     * @param doubles {@link Double} 배열.
     *
     * @return {@code double} 배열.
     *
     * @see JavaLangConstants#DOUBLE_DEFAULT 인자로 받은 배열의 엘리먼트가 {@code null}일 때 사용.
     */
    public static double[] unbox(Double[] doubles) {
        if (null == doubles) {
            return null;
        }

        double[] array = new double[doubles.length];
        for (int i = 0; i < doubles.length; i++) {
            array[i] = null == doubles[i]
                    ? DOUBLE_DEFAULT
                    : doubles[i];
        }
        return array;
    }

    /**
     * 래퍼 클래스 배열을 기본 자료형 배열로 변환한다.
     *
     * @param characters {@link Character} 배열.
     *
     * @return {@code char} 배열.
     *
     * @see JavaLangConstants#CHAR_DEFAULT 인자로 받은 배열의 엘리먼트가 {@code null}일 때 사용.
     */
    public static char[] unbox(Character[] characters) {
        if (null == characters) {
            return null;
        }

        char[] array = new char[characters.length];
        for (int i = 0; i < characters.length; i++) {
            array[i] = null == characters[i]
                    ? CHAR_DEFAULT
                    : characters[i];
        }
        return array;
    }

    /**
     * {@link PrimitiveTypeUtils} 사용자 측이 자료형에 따른 분기문을 작성하지 않아도 되도록 별도의 기능이 없는 메서드를 추가.
     *
     * @param objects 오브젝트 배열.
     * @param <T>     오브젝트 타입.
     *
     * @return 인자로 받은 오브젝트 배열.
     */
    public static <T> T[] unbox(T[] objects) {
        return objects;
    }

    /**
     * {@link PrimitiveTypeUtils} 사용자 측이 자료형에 따른 분기문을 작성하지 않아도 되도록 별도의 기능이 없는 메서드를 추가.
     *
     * @param object 오브젝트.
     * @param <T>    오브젝트 타입.
     *
     * @return 인자로 받은 오브젝트.
     */
    public static <T> T unbox(T object) {
        if (null == object) {
            return null;
        }

        switch (object.getClass().getName()) {
            case BOOLEAN_CLASS_ARRAY_CLASS_NAME:
                return (T) unbox((Boolean[]) object);
            case BYTE_CLASS_ARRAY_CLASS_NAME:
                return (T) unbox((Byte[]) object);
            case SHORT_CLASS_ARRAY_CLASS_NAME:
                return (T) unbox((Short[]) object);
            case INTEGER_CLASS_ARRAY_CLASS_NAME:
                return (T) unbox((Integer[]) object);
            case LONG_CLASS_ARRAY_CLASS_NAME:
                return (T) unbox((Long[]) object);
            case FLOAT_CLASS_ARRAY_CLASS_NAME:
                return (T) unbox((Float[]) object);
            case DOUBLE_CLASS_ARRAY_CLASS_NAME:
                return (T) unbox((Double[]) object);
            case CHARACTER_CLASS_ARRAY_CLASS_NAME:
                return (T) unbox((Character[]) object);
            default:
                return object;
        }
    }

    private PrimitiveTypeUtils() {
        throw new UnsupportedOperationException();
    }
}
