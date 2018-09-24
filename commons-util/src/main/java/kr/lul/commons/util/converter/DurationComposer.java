package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractIdentifiableComposer;
import kr.lul.commons.util.ComposeException;

import java.time.Duration;

/**
 * @author justburrow
 * @since 2018. 9. 24.
 */
public class DurationComposer
        extends AbstractIdentifiableComposer<Duration> {
    public DurationComposer() {
        super(Duration.class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Composer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public String compose(Duration duration) throws ComposeException {
        return null == duration
                ? null
                : duration.toString();
    }
}
