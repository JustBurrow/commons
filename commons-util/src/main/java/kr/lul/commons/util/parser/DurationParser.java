package kr.lul.commons.util.parser;

import kr.lul.commons.util.AbstractIdentifiableParser;
import kr.lul.commons.util.ParseException;

import java.time.Duration;
import java.time.format.DateTimeParseException;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class DurationParser
        extends AbstractIdentifiableParser<Duration> {
    public DurationParser() {
        super(Duration.class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Parser
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Duration parse(String text) throws ParseException {
        try {
            return null == text
                    ? null
                    : Duration.parse(text);
        } catch (DateTimeParseException e) {
            throw new ParseException(e);
        }
    }
}
