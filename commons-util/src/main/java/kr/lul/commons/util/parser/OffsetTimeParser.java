package kr.lul.commons.util.parser;

import kr.lul.commons.util.AbstractIdentifiableParser;
import kr.lul.commons.util.Configurable;
import kr.lul.commons.util.ParseException;

import java.time.OffsetTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static kr.lul.commons.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class OffsetTimeParser
        extends AbstractIdentifiableParser<OffsetTime>
        implements Configurable<DateTimeFormatter> {
    private DateTimeFormatter formatter;

    public OffsetTimeParser() {
        this(DateTimeFormatter.ISO_OFFSET_TIME);
    }

    public OffsetTimeParser(DateTimeFormatter formatter) {
        super(OffsetTime.class);
        notNull(formatter, "formatter");
        this.formatter = formatter;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Configurable
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public DateTimeFormatter getConfig() {
        return this.formatter;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Parser
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public OffsetTime parse(String text) throws ParseException {
        try {
            return null == text
                    ? null
                    : OffsetTime.parse(text, this.formatter);
        } catch (DateTimeParseException e) {
            throw new ParseException(e);
        }
    }
}
