package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractIdentifiableComposer;
import kr.lul.commons.util.ComposeException;

import java.time.ZoneId;

/**
 * @author justburrow
 * @since 2018. 9. 24.
 */
public class ZoneIdComposer extends AbstractIdentifiableComposer<ZoneId> {
    public ZoneIdComposer() {
        super(ZoneId.class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Composer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public String compose(ZoneId zoneId) throws ComposeException {
        return null == zoneId
                ? null
                : zoneId.toString();
    }
}
