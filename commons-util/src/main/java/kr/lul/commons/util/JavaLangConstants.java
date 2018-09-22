package kr.lul.commons.util;

import java.util.Set;

/**
 * Java 언어 수준의 상수.
 *
 * @author justburrow
 * @since 2018. 9. 20.
 */
public abstract class JavaLangConstants {
    public static final Set<Class> PRIMITIVE_TYPES = Set.of(
            Boolean.TYPE,
            Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE,
            Float.TYPE, Double.TYPE,
            Character.TYPE
    );

    public static final Set<Class> PRIMITIVE_ARRAY_TYPES = Set.of(
            boolean[].class,
            byte[].class, short[].class, int[].class, long[].class,
            float[].class, double[].class,
            char[].class
    );

    public static final boolean BOOLEAN_DEFAULT = false;
    public static final byte BYTE_DEFAULT = (byte) 0;
    public static final short SHORT_DEFAULT = (short) 0;
    public static final int INT_DEFAULT = 0;
    public static final long LONG_DEFAULT = 0L;

    public static final float FLOAT_DEFAULT = 0.0F;
    public static final double DOUBLE_DEFAULT = 0.0;

    public static final char CHAR_DEFAULT = Character.MIN_VALUE;

    /**
     * @see Boolean#TYPE
     */
    public static final String BOOLEAN_TYPE_NAME = "boolean";
    /**
     * @see Byte#TYPE
     */
    public static final String BYTE_TYPE_NAME = "byte";
    /**
     * @see Short#TYPE
     */
    public static final String SHORT_TYPE_NAME = "short";
    /**
     * @see Integer#TYPE
     */
    public static final String INTEGER_TYPE_NAME = "int";
    /**
     * @see Long#TYPE
     */
    public static final String LONG_TYPE_NAME = "long";
    /**
     * @see Float#TYPE
     */
    public static final String FLOAT_TYPE_NAME = "float";
    /**
     * @see Double#TYPE
     */
    public static final String DOUBLE_TYPE_NAME = "double";
    /**
     * @see Character#TYPE
     */
    public static final String CHARACTER_TYPE_NAME = "char";

    /**
     * @see Boolean
     */
    public static final String BOOLEAN_CLASS_NAME = "java.lang.Boolean";
    /**
     * @see Byte
     */
    public static final String BYTE_CLASS_NAME = "java.lang.Byte";
    /**
     * @see Short
     */
    public static final String SHORT_CLASS_NAME = "java.lang.Short";
    /**
     * @see Integer
     */
    public static final String INTEGER_CLASS_NAME = "java.lang.Integer";
    /**
     * @see Long
     */
    public static final String LONG_CLASS_NAME = "java.lang.Long";
    /**
     * @see Float
     */
    public static final String FLOAT_CLASS_NAME = "java.lang.Float";
    /**
     * @see Double
     */
    public static final String DOUBLE_CLASS_NAME = "java.lang.Double";
    /**
     * @see Character
     */
    public static final String CHARACTER_CLASS_NAME = "java.lang.Character";

    /**
     * @see String
     */
    public static final String STRING_CLASS_NAME = "java.lang.String";
    /**
     * @see java.math.BigInteger
     */
    public static final String BIG_INTEGER_CLASS_NAME = "java.math.BigInteger";
    /**
     * @see java.math.BigDecimal
     */
    public static final String BIG_DECIMAL_CLASS_NAME = "java.math.BigDecimal";

    /**
     * @see java.time.Instant
     */
    public static final String INSTANT_CLASS_NAME = "java.time.Instant";
    /**
     * @see java.time.ZonedDateTime
     */
    public static final String ZONED_DATE_TIME_CLASS_NAME = "java.time.ZonedDateTime";
    /**
     * @see java.time.OffsetDateTime
     */
    public static final String OFFSET_DATE_TIME_CLASS_NAME = "java.time.OffsetDateTime";
    /**
     * @see java.time.LocalDateTime
     */
    public static final String LOCAL_DATE_TIME_CLASS_NAME = "java.time.LocalDateTime";
    /**
     * @see java.time.LocalDate
     */
    public static final String LOCAL_DATE_CLASS_NAME = "java.time.LocalDate";
    /**
     * @see java.time.LocalTime
     */
    public static final String LOCAL_TIME_CLASS_NAME = "java.time.LocalTime";

    /**
     * @see java.time.Period
     */
    public static final String PERIOD_CLASS_NAME = "java.time.Period";
    /**
     * @see java.time.Duration
     */
    public static final String DURATION_CLASS_NAME = "java.time.Duration";

    /**
     * @see Boolean#TYPE
     */
    public static final String BOOLEAN_TYPE_ARRAY_CLASS_NAME = "[Z";
    /**
     * @see Boolean
     */
    public static final String BOOLEAN_CLASS_ARRAY_CLASS_NAME = "[L" + BOOLEAN_CLASS_NAME + ";";
    /**
     * @see Byte#TYPE
     */
    public static final String BYTE_TYPE_ARRAY_CLASS_NAME = "[B";
    /**
     * @see Byte
     */
    public static final String BYTE_CLASS_ARRAY_CLASS_NAME = "[L" + BYTE_CLASS_NAME + ";";
    /**
     * @see Short#TYPE
     */
    public static final String SHORT_TYPE_ARRAY_CLASS_NAME = "[S";
    /**
     * @see Short
     */
    public static final String SHORT_CLASS_ARRAY_CLASS_NAME = "[L" + SHORT_CLASS_NAME + ";";
    /**
     * @see Integer#TYPE
     */
    public static final String INTEGER_TYPE_ARRAY_CLASS_NAME = "[I";
    /**
     * @see Integer
     */
    public static final String INTEGER_CLASS_ARRAY_CLASS_NAME = "[L" + INTEGER_CLASS_NAME + ";";
    /**
     * @see Long#TYPE
     */
    public static final String LONG_TYPE_ARRAY_CLASS_NAME = "[J";
    /**
     * @see Long
     */
    public static final String LONG_CLASS_ARRAY_CLASS_NAME = "[L" + LONG_CLASS_NAME + ";";
    /**
     * @see Float#TYPE
     */
    public static final String FLOAT_TYPE_ARRAY_CLASS_NAME = "[F";
    /**
     * @see Float
     */
    public static final String FLOAT_CLASS_ARRAY_CLASS_NAME = "[L" + FLOAT_CLASS_NAME + ";";
    /**
     * @see Double#TYPE
     */
    public static final String DOUBLE_TYPE_ARRAY_CLASS_NAME = "[D";
    /**
     * @see Double
     */
    public static final String DOUBLE_CLASS_ARRAY_CLASS_NAME = "[L" + DOUBLE_CLASS_NAME + ";";
    /**
     * @see Character#TYPE
     */
    public static final String CHARACTER_TYPE_ARRAY_CLASS_NAME = "[C";
    /**
     * @see Character
     */
    public static final String CHARACTER_CLASS_ARRAY_CLASS_NAME = "[L" + CHARACTER_CLASS_NAME + ";";

    /**
     * @see String
     */
    public static final String STRING_ARRAY_CLASS_NAME = "[Ljava.lang.String;";
    /**
     * <code>java.lang.String.format(OBJECT_ARRAY_FORMAT, SomeClass.class.getName())</code>
     *
     * @see String#format(String, Object...)
     */
    public static final String OBJECT_ARRAY_FORMAT = "[L%s;";

    private JavaLangConstants() {
        throw new UnsupportedOperationException();
    }
}
