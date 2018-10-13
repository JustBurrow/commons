package kr.lul.commons.util.parser;

import kr.lul.commons.util.AbstractIdentifiableParser;
import kr.lul.commons.util.Configurable;
import kr.lul.commons.util.ParseException;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static kr.lul.commons.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class ZonedDateTimeParser
        extends AbstractIdentifiableParser<ZonedDateTime>
        implements Configurable<DateTimeFormatter> {
    private DateTimeFormatter formatter;

    public ZonedDateTimeParser() {
        this(DateTimeFormatter.ISO_ZONED_DATE_TIME);
    }

    public ZonedDateTimeParser(DateTimeFormatter formatter) {
        super(ZonedDateTime.class);
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
    public ZonedDateTime parse(String text) throws ParseException {
        try {
            return null == text
                    ? null
                    : ZonedDateTime.parse(text, this.formatter);
        } catch (DateTimeParseException e) {
            throw new ParseException(e);
        }
    }
}
