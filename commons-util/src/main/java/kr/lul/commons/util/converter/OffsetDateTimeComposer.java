package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractIdentifiableComposer;
import kr.lul.commons.util.ComposeException;
import kr.lul.commons.util.Configurable;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import static kr.lul.commons.util.Arguments.notNull;

/**
 * @author justburrow
 * @see OffsetDateTime
 * @since 2018. 9. 24.
 */
public class OffsetDateTimeComposer
        extends AbstractIdentifiableComposer<OffsetDateTime>
        implements Configurable<DateTimeFormatter> {
    private DateTimeFormatter formatter;

    public OffsetDateTimeComposer() {
        this(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

    public OffsetDateTimeComposer(DateTimeFormatter formatter) {
        super(OffsetDateTime.class);
        notNull(formatter, "formatter");

        this.formatter = formatter;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Composer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public String compose(OffsetDateTime offsetDateTime) throws ComposeException {
        return null == offsetDateTime
                ? null
                : offsetDateTime.format(this.formatter);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Configurable
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public DateTimeFormatter getConfig() {
        return this.formatter;
    }
}
