package kr.lul.commons.util.composer;

import kr.lul.commons.util.AbstractIdentifiableComposer;
import kr.lul.commons.util.ComposeException;
import kr.lul.commons.util.Configurable;

import java.time.OffsetTime;
import java.time.format.DateTimeFormatter;

import static kr.lul.commons.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class OffsetTimeComposer
        extends AbstractIdentifiableComposer<OffsetTime>
        implements Configurable<DateTimeFormatter> {
    private DateTimeFormatter formatter;

    public OffsetTimeComposer() {
        this(DateTimeFormatter.ISO_OFFSET_TIME);
    }

    public OffsetTimeComposer(DateTimeFormatter formatter) {
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
    // kr.lul.commons.util.Composer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public String compose(OffsetTime offsetTime) throws ComposeException {
        return null == offsetTime
                ? null
                : offsetTime.format(this.formatter);
    }
}
