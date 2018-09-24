package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractIdentifiableComposer;
import kr.lul.commons.util.ComposeException;
import kr.lul.commons.util.Configurable;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static kr.lul.commons.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2018. 9. 24.
 */
public class LocalTimeComposer
        extends AbstractIdentifiableComposer<LocalTime>
        implements Configurable<DateTimeFormatter> {
    public static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ISO_LOCAL_TIME;

    private DateTimeFormatter formatter;

    public LocalTimeComposer() {
        this(DEFAULT_FORMATTER);
    }

    public LocalTimeComposer(DateTimeFormatter formatter) {
        super(LocalTime.class);
        notNull(formatter, "formatter");

        this.formatter = formatter;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Composer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public String compose(LocalTime localTime) throws ComposeException {
        return null == localTime
                ? null
                : localTime.format(this.formatter);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Configurable
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public DateTimeFormatter getConfig() {
        return this.formatter;
    }
}
