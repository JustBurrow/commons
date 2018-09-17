package kr.lul.commons.util;

/**
 * @author justburrow
 * @since 2018. 9. 18.
 */
public class ParseException extends ConvertException {
    public ParseException() {
    }

    public ParseException(String message) {
        super(message);
    }

    public ParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParseException(Throwable cause) {
        super(cause);
    }
}
