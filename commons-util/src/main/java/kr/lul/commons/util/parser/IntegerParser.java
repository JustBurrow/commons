package kr.lul.commons.util.parser;

import kr.lul.commons.util.ParseException;
import kr.lul.commons.util.Parser;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class IntegerParser implements Parser<Integer> {
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Parser
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Integer parse(String text) throws ParseException {
        try {
            return null == text
                    ? null
                    : Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new ParseException(e);
        }
    }
}
