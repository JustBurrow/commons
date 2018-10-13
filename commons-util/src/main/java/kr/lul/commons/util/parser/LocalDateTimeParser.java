package kr.lul.commons.util.parser;

import kr.lul.commons.util.AbstractIdentifiableParser;
import kr.lul.commons.util.Configurable;
import kr.lul.commons.util.ParseException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static kr.lul.commons.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class LocalDateTimeParser
        extends AbstractIdentifiableParser<LocalDateTime>
        implements Configurable<DateTimeFormatter> {
    private DateTimeFormatter formatter;

    public LocalDateTimeParser() {
        this(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public LocalDateTimeParser(DateTimeFormatter formatter) {
        super(LocalDateTime.class);
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
    public LocalDateTime parse(String text) throws ParseException {
        try {
            return null == text
                    ? null
                    : LocalDateTime.parse(text, this.formatter);
        } catch (DateTimeParseException e) {
            throw new ParseException(e);
        }
    }
}
