package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractIdentifiableComposer;
import kr.lul.commons.util.ComposeException;
import kr.lul.commons.util.Configurable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static kr.lul.commons.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2018. 9. 24.
 */
public class LocalDateComposer
        extends AbstractIdentifiableComposer<LocalDate>
        implements Configurable<DateTimeFormatter> {
    public static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

    private DateTimeFormatter formatter;

    public LocalDateComposer() {
        this(DEFAULT_FORMATTER);
    }

    public LocalDateComposer(DateTimeFormatter formatter) {
        super(LocalDate.class);
        notNull(formatter, "formatter");

        this.formatter = formatter;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Composer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public String compose(LocalDate localDate) throws ComposeException {
        return null == localDate
                ? null
                : localDate.format(this.formatter);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Configurable
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public DateTimeFormatter getConfig() {
        return this.formatter;
    }
}
