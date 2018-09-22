package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractComposer;
import kr.lul.commons.util.ConvertException;

/**
 * @author justburrow
 * @since 2018. 9. 19.
 */
public class ClassComposer extends AbstractComposer<Class> {
    public ClassComposer() {
        super(Class.class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Composer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public String compose(Class source) throws ConvertException {
        return null == source
                ? null
                : source.getName();
    }
}
