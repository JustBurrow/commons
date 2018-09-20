package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractConverter;
import kr.lul.commons.util.JavaLangConstants;
import kr.lul.commons.util.PrimitiveUnboxer;

/**
 * @author justburrow
 * @since 2018. 9. 20.
 */
public class BooleanUnboxer
        extends AbstractConverter<Boolean, Boolean>
        implements PrimitiveUnboxer<Boolean, Boolean> {
    public static final BooleanUnboxer SINGLETON = new BooleanUnboxer();

    public BooleanUnboxer() {
        super(Boolean.class, Boolean.TYPE);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.converter.BooleanUnboxer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Boolean unbox(Boolean primitive) {
        return null == primitive
                ? JavaLangConstants.BOOLEAN_DEFAULT
                : primitive;
    }
}
