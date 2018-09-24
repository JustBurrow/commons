package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractIdentifiableComposer;
import kr.lul.commons.util.ComposeException;
import kr.lul.commons.util.Configurable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static kr.lul.commons.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2018. 9. 24.
 */
public class LocalDateTimeComposer
        extends AbstractIdentifiableComposer<LocalDateTime>
        implements Configurable<DateTimeFormatter> {
    private DateTimeFormatter formatter;

    public LocalDateTimeComposer() {
        this(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public LocalDateTimeComposer(DateTimeFormatter formatter) {
        super(LocalDateTime.class);
        notNull(formatter, "formatter");

        this.formatter = formatter;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Composer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public String compose(LocalDateTime localDateTime) throws ComposeException {
        return null == localDateTime
                ? null
                : localDateTime.format(this.formatter);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Configurable
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public DateTimeFormatter getConfig() {
        return this.formatter;
    }
}
