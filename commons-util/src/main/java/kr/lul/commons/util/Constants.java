package kr.lul.commons.util;

import java.util.Map;
import java.util.Set;

import static java.util.Map.entry;

/**
 * @author justburrow
 * @since 2018. 9. 18.
 */
public abstract class Constants {
    /**
     * {@code boolean}
     *
     * @see Boolean#TYPE
     */
    public static final String BOOLEAN_TYPE_NAME = "boolean";
    /**
     * {@code byte}
     *
     * @see Byte#TYPE
     */
    public static final String BYTE_TYPE_NAME = "byte";
    /**
     * {@code short}
     *
     * @see Short#TYPE
     */
    public static final String SHORT_TYPE_NAME = "short";
    /**
     * {@code int}
     *
     * @see Integer#TYPE
     */
    public static final String INTEGER_TYPE_NAME = "int";
    /**
     * {@code long}
     *
     * @see Long#TYPE
     */
    public static final String LONG_TYPE_NAME = "long";
    /**
     * {@code float}
     *
     * @see Float#TYPE
     */
    public static final String FLOAT_TYPE_NAME = "float";
    /**
     * {@code double}
     *
     * @see Double#TYPE
     */
    public static final String DOUBLE_TYPE_NAME = "double";
    /**
     * {@code char}
     *
     * @see Character#TYPE
     */
    public static final String CHARACTER_TYPE_NAME = "char";

    /**
     * @see Boolean#TYPE
     * @see Byte#TYPE
     * @see Short#TYPE
     * @see Integer#TYPE
     * @see Long#TYPE
     * @see Float#TYPE
     * @see Double#TYPE
     * @see Character#TYPE
     */
    public static final Set<Class> PRIMITIVE_TYPES = Set.of(Boolean.TYPE,
            Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE,
            Float.TYPE, Double.TYPE,
            Character.TYPE);

    /**
     * {@code Map<primitiveTypeName, type>}
     */
    public static final Map<String, Class> PRIMITIVE_TYPE_MAP = Map.ofEntries(
            entry(BOOLEAN_TYPE_NAME, Boolean.TYPE),
            entry(BYTE_TYPE_NAME, Byte.TYPE),
            entry(SHORT_TYPE_NAME, Short.TYPE),
            entry(INTEGER_TYPE_NAME, Integer.TYPE),
            entry(LONG_TYPE_NAME, Long.TYPE),
            entry(FLOAT_TYPE_NAME, Float.TYPE),
            entry(DOUBLE_TYPE_NAME, Double.TYPE),
            entry(CHARACTER_TYPE_NAME, Character.TYPE)
    );

    /**
     * {@code Map<primitiveType, wrapperClass>}
     *
     * @see #AUTO_UNBOXING_MAP
     */
    public static final Map<Class, Class> AUTO_BOXING_MAP = Map.ofEntries(
            entry(Boolean.TYPE, Boolean.class),
            entry(Byte.TYPE, Byte.class),
            entry(Short.TYPE, Short.class),
            entry(Integer.TYPE, Integer.class),
            entry(Long.TYPE, Long.class),
            entry(Float.TYPE, Float.class),
            entry(Double.TYPE, Double.class),
            entry(Character.TYPE, Character.class)
    );

    /**
     * {@code Map< wrapperClass, primitiveType>}
     *
     * @see #AUTO_UNBOXING_MAP
     */
    public static final Map<Class, Class> AUTO_UNBOXING_MAP = Map.ofEntries(
            entry(Boolean.class, Boolean.TYPE),
            entry(Byte.class, Byte.TYPE),
            entry(Short.class, Short.TYPE),
            entry(Integer.class, Integer.TYPE),
            entry(Long.class, Long.TYPE),
            entry(Float.class, Float.TYPE),
            entry(Double.class, Double.TYPE),
            entry(Character.class, Character.TYPE)
    );

    private Constants() {
        throw new UnsupportedOperationException();
    }
}
