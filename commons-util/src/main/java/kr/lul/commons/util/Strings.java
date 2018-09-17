package kr.lul.commons.util;

import static java.lang.String.format;
import static kr.lul.commons.util.Arguments.notNull;

/**
 * 문자열 유틸리티.
 *
 * @author justburrow
 * @see String
 * @since 2018. 9. 18.
 */
public abstract class Strings {
    public static String capitalize(String string) {
        notNull(string, "string");

        if (string.isEmpty()) {
            return "";
        }

        String head = string.substring(0, 1).toUpperCase();
        String body = string.substring(1);

        return format("%s%s", head, body);
    }

    private Strings() {
        throw new UnsupportedOperationException();
    }
}
