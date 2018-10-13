package kr.lul.commons.util.parser;

import kr.lul.commons.util.AbstractIdentifiableParser;
import kr.lul.commons.util.ParseException;

import java.time.Instant;
import java.time.format.DateTimeParseException;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class InstantParser extends AbstractIdentifiableParser<Instant> {
    public InstantParser() {
        super(Instant.class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Parser
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Instant parse(String text) throws ParseException {
        try {
            return null == text
                    ? null
                    : Instant.parse(text);
        } catch (DateTimeParseException e) {
            throw new ParseException(e);
        }
    }
}
