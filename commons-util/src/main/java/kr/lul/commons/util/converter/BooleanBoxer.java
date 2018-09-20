package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractConverter;
import kr.lul.commons.util.JavaLangConstants;
import kr.lul.commons.util.PrimitiveBoxer;

/**
 * @author justburrow
 * @since 2018. 9. 20.
 */
public class BooleanBoxer extends AbstractConverter<Boolean, Boolean> implements PrimitiveBoxer<Boolean, Boolean> {
    public static final BooleanBoxer SINGLETON = new BooleanBoxer();

    public BooleanBoxer() {
        super(Boolean.TYPE, Boolean.class);
    }

    public Boolean box(boolean primitive) {
        return primitive;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.PrimitiveBoxer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Boolean box(Boolean primitive) {
        return null == primitive
                ? JavaLangConstants.BOOLEAN_DEFAULT
                : primitive;
    }
}
