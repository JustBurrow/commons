package kr.lul.commons.util;

import java.util.Objects;

import static java.lang.String.format;
import static kr.lul.commons.util.Arguments.notEmpty;
import static kr.lul.commons.util.Arguments.notNull;

/**
 * 문자열 유틸리티.
 *
 * @author justburrow
 * @see String
 * @since 2018. 9. 18.
 */
public abstract class Strings {
    public static final String DEFAULT_NULL_STRING = "null";

    public static String capitalize(String string) {
        notNull(string, "string");

        if (string.isEmpty()) {
            return "";
        }

        String head = string.substring(0, 1).toUpperCase();
        String body = string.substring(1);

        return format("%s%s", head, body);
    }


    public static String[] toStringArray(boolean... booleans) {
        String[] array = new String[booleans.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = booleans[i]
                    ? "true"
                    : "false";
        }
        return array;
    }

    public static String[] toStringArray(Object... objects) {
        return toStringArray(DEFAULT_NULL_STRING, objects);
    }

    public static String[] toStringArray(String nullString, Object... objects) {
        String[] array = new String[objects.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Objects.toString(objects[i], nullString);
        }
        return array;
    }

    /**
     * 어떤 문자열이 다른 예상되는 오브젝트 문자열을 포함하고 있는지 판단한다.
     *
     * @param target   검증할 문자열.
     * @param booleans 순서대로 포함되었을 것으로 기대하는 {@code boolean} 변수.
     *
     * @return 예상 오브젝트가 순서대로 포함되었으면 {@code true};
     */
    public static boolean containsSequence(String target, boolean... booleans) {
        notEmpty(target, "target");

        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < booleans.length; i++) {
            String compare = Boolean.toString(booleans[i]);

            int index = target.indexOf(compare, prev);
            if (0 > index) {
                return false;
            } else {
                prev = index;
            }
        }

        return true;
    }

    /**
     * 어떤 문자열이 다른 예상되는 오브젝트 문자열을 포함하고 있는지 판단한다.
     *
     * @param target 검증할 문자열.
     * @param bytes  순서대로 포함되었을 것으로 기대하는 {@code byte} 변수.
     *
     * @return 예상 오브젝트가 순서대로 포함되었으면 {@code true};
     */
    public static boolean containsSequence(String target, byte... bytes) {
        notEmpty(target, "target");

        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < bytes.length; i++) {
            String compare = Byte.toString(bytes[i]);

            int index = target.indexOf(compare, prev);
            if (0 > index) {
                return false;
            } else {
                prev = index;
            }
        }

        return true;
    }

    /**
     * 어떤 문자열이 다른 예상되는 오브젝트 문자열을 포함하고 있는지 판단한다.
     *
     * @param target 검증할 문자열.
     * @param shorts 순서대로 포함되었을 것으로 기대하는 {@code short} 변수.
     *
     * @return 예상 오브젝트가 순서대로 포함되었으면 {@code true};
     */
    public static boolean containsSequence(String target, short... shorts) {
        notEmpty(target, "target");

        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < shorts.length; i++) {
            String compare = Short.toString(shorts[i]);

            int index = target.indexOf(compare, prev);
            if (0 > index) {
                return false;
            } else {
                prev = index;
            }
        }

        return true;
    }

    /**
     * 어떤 문자열이 다른 예상되는 오브젝트 문자열을 포함하고 있는지 판단한다.
     *
     * @param target 검증할 문자열.
     * @param ints   순서대로 포함되었을 것으로 기대하는 {@code int} 변수.
     *
     * @return 예상 오브젝트가 순서대로 포함되었으면 {@code true};
     */
    public static boolean containsSequence(String target, int... ints) {
        notEmpty(target, "target");

        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < ints.length; i++) {
            String compare = Integer.toString(ints[i]);

            int index = target.indexOf(compare, prev);
            if (0 > index) {
                return false;
            } else {
                prev = index;
            }
        }

        return true;
    }

    /**
     * 어떤 문자열이 다른 예상되는 오브젝트 문자열을 포함하고 있는지 판단한다.
     *
     * @param target 검증할 문자열.
     * @param longs  순서대로 포함되었을 것으로 기대하는 {@code long} 변수.
     *
     * @return 예상 오브젝트가 순서대로 포함되었으면 {@code true};
     */
    public static boolean containsSequence(String target, long... longs) {
        notEmpty(target, "target");

        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < longs.length; i++) {
            String compare = Long.toString(longs[i]);

            int index = target.indexOf(compare, prev);
            if (0 > index) {
                return false;
            } else {
                prev = index;
            }
        }

        return true;
    }

    /**
     * 어떤 문자열이 다른 예상되는 오브젝트 문자열을 포함하고 있는지 판단한다.
     *
     * @param target 검증할 문자열.
     * @param floats 순서대로 포함되었을 것으로 기대하는 {@code float} 변수.
     *
     * @return 예상 오브젝트가 순서대로 포함되었으면 {@code true};
     */
    public static boolean containsSequence(String target, float... floats) {
        notEmpty(target, "target");

        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < floats.length; i++) {
            String compare = Float.toString(floats[i]);

            int index = target.indexOf(compare, prev);
            if (0 > index) {
                return false;
            } else {
                prev = index;
            }
        }

        return true;
    }

    /**
     * 어떤 문자열이 다른 예상되는 오브젝트 문자열을 포함하고 있는지 판단한다.
     *
     * @param target  검증할 문자열.
     * @param doubles 순서대로 포함되었을 것으로 기대하는 {@code double} 변수.
     *
     * @return 예상 오브젝트가 순서대로 포함되었으면 {@code true};
     */
    public static boolean containsSequence(String target, double... doubles) {
        notEmpty(target, "target");

        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < doubles.length; i++) {
            String compare = Double.toString(doubles[i]);

            int index = target.indexOf(compare, prev);
            if (0 > index) {
                return false;
            } else {
                prev = index;
            }
        }

        return true;
    }

    /**
     * 어떤 문자열이 다른 예상되는 오브젝트 문자열을 포함하고 있는지 판단한다.
     *
     * @param target 검증할 문자열.
     * @param chars  순서대로 포함되었을 것으로 기대하는 {@code char} 변수.
     *
     * @return 예상 오브젝트가 순서대로 포함되었으면 {@code true};
     */
    public static boolean containsSequence(String target, char... chars) {
        notEmpty(target, "target");

        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < chars.length; i++) {
            String compare = Character.toString(chars[i]);

            int index = target.indexOf(compare, prev);
            if (0 > index) {
                return false;
            } else {
                prev = index;
            }
        }

        return true;
    }

    /**
     * 어떤 문자열이 다른 예상되는 오브젝트 문자열을 포함하고 있는지 판단한다.
     *
     * @param target   검증할 문자열.
     * @param expected 순서대로 포함되었을 것으로 기대하는 예상 오브젝트.
     *
     * @return 예상 오브젝트가 순서대로 포함되었으면 {@code true};
     */
    public static boolean containsSequence(String target, Object... expected) {
        return containsSequence(target, DEFAULT_NULL_STRING, expected);
    }

    /**
     * 어떤 문자열이 다른 예상되는 오브젝트 문자열을 포함하고 있는지 판단한다.
     *
     * @param target     검증할 문자열.
     * @param nullString {@code expected}의 엘리먼트가 {@code null}일 때 사용할 문자열.
     * @param expected   순서대로 포함되었을 것으로 기대하는 예상 오브젝트.
     *
     * @return 예상 오브젝트가 순서대로 포함되었으면 {@code true}.
     *
     * @see Objects#toString(Object, String)
     */
    public static boolean containsSequence(String target, String nullString, Object... expected) {
        notEmpty(target, "target");
        notNull(nullString, "nullString");

        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < expected.length; i++) {
            String compare = null == expected[i]
                    ? nullString
                    : expected[i].toString();

            int index = target.indexOf(compare, prev + 1);
            if (0 > index) {
                return false;
            } else {
                prev = index;
            }
        }
        return true;
    }

    private Strings() {
        throw new UnsupportedOperationException();
    }
}
