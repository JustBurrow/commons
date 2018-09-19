package kr.lul.commons.util;

/**
 * @author justburrow
 * @since 2018. 9. 20.
 */
public class ComposeException extends ConvertException {
    public ComposeException() {
    }

    public ComposeException(String message) {
        super(message);
    }

    public ComposeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ComposeException(Throwable cause) {
        super(cause);
    }
}
