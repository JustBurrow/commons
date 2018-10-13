package kr.lul.commons.util.parser;

import kr.lul.commons.util.AbstractIdentifiableParser;
import kr.lul.commons.util.ParseException;

import java.math.BigInteger;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class BigIntegerParser extends AbstractIdentifiableParser<BigInteger> {
    public BigIntegerParser() {
        super(BigInteger.class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Parser
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public BigInteger parse(String text) throws ParseException {
        try {
            return null == text
                    ? null
                    : new BigInteger(text);
        } catch (NumberFormatException e) {
            throw new ParseException(e);
        }
    }
}
