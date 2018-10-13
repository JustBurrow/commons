package kr.lul.commons.util.parser;

import kr.lul.commons.util.AbstractIdentifiableParser;
import kr.lul.commons.util.Configurable;
import kr.lul.commons.util.ParseException;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static kr.lul.commons.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class LocalTimeParser
        extends AbstractIdentifiableParser<LocalTime>
        implements Configurable<DateTimeFormatter> {
    private DateTimeFormatter formatter;

    public LocalTimeParser() {
        this(DateTimeFormatter.ISO_LOCAL_TIME);
    }

    public LocalTimeParser(DateTimeFormatter formatter) {
        super(LocalTime.class);
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
    public LocalTime parse(String text) throws ParseException {
        try {
            return null == text
                    ? null
                    : LocalTime.parse(text, this.formatter);
        } catch (DateTimeParseException e) {
            throw new ParseException(e);
        }
    }
}
