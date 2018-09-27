package kr.lul.commons.util.composer;

import kr.lul.commons.util.AbstractIdentifiableComposer;
import kr.lul.commons.util.ConvertException;

/**
 * @author justburrow
 * @since 2018. 9. 19.
 */
public class ClassComposer extends AbstractIdentifiableComposer<Class> {
    public ClassComposer() {
        super(Class.class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.IdentifiableComposer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public String compose(Class source) throws ConvertException {
        return null == source
                ? null
                : source.getName();
    }
}
