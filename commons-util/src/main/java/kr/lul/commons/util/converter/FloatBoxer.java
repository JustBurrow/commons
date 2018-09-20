package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractConverter;
import kr.lul.commons.util.JavaLangConstants;
import kr.lul.commons.util.PrimitiveBoxer;

/**
 * @author justburrow
 * @since 2018. 9. 20.
 */
public class FloatBoxer extends AbstractConverter<Float, Float> implements PrimitiveBoxer<Float, Float> {
    public static final FloatBoxer SINGLETON = new FloatBoxer();

    public FloatBoxer() {
        super(Float.TYPE, Float.class);
    }

    public Float box(float primitive) {
        return primitive;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.PrimitiveBoxer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Float box(Float primitive) {
        return null == primitive
                ? JavaLangConstants.FLOAT_DEFAULT
                : primitive;
    }
}
