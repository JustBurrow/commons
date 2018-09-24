package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractIdentifiableComposer;
import kr.lul.commons.util.ComposeException;

import java.time.Period;

/**
 * @author justburrow
 * @since 2018. 9. 24.
 */
public class PeriodComposer
        extends AbstractIdentifiableComposer<Period> {
    public PeriodComposer() {
        super(Period.class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Composer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public String compose(Period period) throws ComposeException {
        return null == period
                ? null
                : period.toString();
    }
}
