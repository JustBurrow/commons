package kr.lul.commons.util.parser;

import kr.lul.commons.util.ParseException;
import kr.lul.commons.util.Parser;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class DoubleParser implements Parser<Double> {
    @Override
    public Double parse(String text) throws ParseException {
        try {
            return null == text
                    ? null
                    : Double.parseDouble(text);
        } catch (NumberFormatException e) {
            throw new ParseException(e);
        }
    }
}
