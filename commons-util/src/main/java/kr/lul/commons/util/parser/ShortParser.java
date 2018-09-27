package kr.lul.commons.util.parser;

import kr.lul.commons.util.ParseException;
import kr.lul.commons.util.Parser;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class ShortParser implements Parser<Short> {
    @Override
    public Short parse(String text) throws ParseException {
        try {
            return null == text
                    ? null
                    : Short.parseShort(text);
        } catch (NumberFormatException e) {
            throw new ParseException(e);
        }
    }
}
