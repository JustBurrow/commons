package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractConverter;
import kr.lul.commons.util.JavaLangConstants;
import kr.lul.commons.util.PrimitiveBoxer;

/**
 * @author justburrow
 * @since 2018. 9. 20.
 */
public class ShortBoxer extends AbstractConverter<Short, Short> implements PrimitiveBoxer<Short, Short> {
    public static final ShortBoxer SINGLETON = new ShortBoxer();

    public ShortBoxer() {
        super(Short.TYPE, Short.class);
    }

    public Short box(short primitive) {
        return primitive;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.PrimitiveBoxer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Short box(Short primitive) {
        return null == primitive
                ? JavaLangConstants.SHORT_DEFAULT
                : primitive;
    }
}
