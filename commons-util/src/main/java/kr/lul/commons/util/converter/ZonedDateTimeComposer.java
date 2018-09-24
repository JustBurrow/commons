package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractIdentifiableComposer;
import kr.lul.commons.util.ComposeException;
import kr.lul.commons.util.Configurable;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static kr.lul.commons.util.Arguments.notNull;

/**
 * @author justburrow
 * @see ZonedDateTime
 * @since 2018. 9. 24.
 */
public class ZonedDateTimeComposer
        extends AbstractIdentifiableComposer<ZonedDateTime>
        implements Configurable<DateTimeFormatter> {
    private DateTimeFormatter formatter;

    public ZonedDateTimeComposer() {
        this(DateTimeFormatter.ISO_ZONED_DATE_TIME);
    }

    public ZonedDateTimeComposer(DateTimeFormatter formatter) {
        super(ZonedDateTime.class);
        notNull(formatter, "formatter");

        this.formatter = formatter;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.AbstractIdentifiableComposer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public String compose(ZonedDateTime zonedDateTime) throws ComposeException {
        return null == zonedDateTime
                ? null
                : zonedDateTime.format(this.formatter);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Configurable
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public DateTimeFormatter getConfig() {
        return this.formatter;
    }
}
