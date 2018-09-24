package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractIdentifiableComposer;
import kr.lul.commons.util.ComposeException;
import kr.lul.commons.util.Configurable;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

/**
 * {@link Instant}용 컴포저.
 *
 * @author justburrow
 * @since 2018. 9. 23.
 */
public class InstantComposer
        extends AbstractIdentifiableComposer<Instant>
        implements Configurable<DateTimeFormatter> {
    public static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ISO_INSTANT;

    private DateTimeFormatter formatter;

    public InstantComposer() {
        this(DEFAULT_FORMATTER);
    }

    public InstantComposer(DateTimeFormatter formatter) {
        super(Instant.class);
        this.formatter = formatter;
    }

    public DateTimeFormatter getFormatter() {
        return this.formatter;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.IdentifiableConverter
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public String compose(Instant instant) throws ComposeException {
        return null == instant
                ? null
                : this.formatter.format(instant);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Configurable
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public DateTimeFormatter getConfig() {
        return this.formatter;
    }
}
