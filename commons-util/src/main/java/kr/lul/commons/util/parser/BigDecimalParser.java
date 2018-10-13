package kr.lul.commons.util.parser;

import kr.lul.commons.util.AbstractIdentifiableParser;
import kr.lul.commons.util.ParseException;

import java.math.BigDecimal;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class BigDecimalParser extends AbstractIdentifiableParser<BigDecimal> {
    public BigDecimalParser() {
        super(BigDecimal.class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Parser
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public BigDecimal parse(String text) throws ParseException {
        try {
            return null == text
                    ? null
                    : new BigDecimal(text);
        } catch (NumberFormatException e) {
            throw new ParseException(e);
        }
    }
}
