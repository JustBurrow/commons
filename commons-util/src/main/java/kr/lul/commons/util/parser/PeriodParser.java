package kr.lul.commons.util.parser;

import kr.lul.commons.util.AbstractIdentifiableParser;
import kr.lul.commons.util.ParseException;

import java.time.Period;
import java.time.format.DateTimeParseException;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class PeriodParser
        extends AbstractIdentifiableParser<Period> {
    public PeriodParser() {
        super(Period.class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Parser
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Period parse(String text) throws ParseException {
        try {
            return null == text
                    ? null
                    : Period.parse(text);
        } catch (DateTimeParseException e) {
            throw new ParseException(e);
        }
    }
}
