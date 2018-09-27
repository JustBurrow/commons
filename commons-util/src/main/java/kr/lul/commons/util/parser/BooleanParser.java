package kr.lul.commons.util.parser;

import kr.lul.commons.util.ParseException;
import kr.lul.commons.util.Parser;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class BooleanParser implements Parser<Boolean> {
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Parser
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Boolean parse(String text) throws ParseException {
        return null == text
                ? null
                : Boolean.parseBoolean(text);
    }
}
