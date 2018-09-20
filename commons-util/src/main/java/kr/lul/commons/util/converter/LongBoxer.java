package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractConverter;
import kr.lul.commons.util.JavaLangConstants;
import kr.lul.commons.util.PrimitiveBoxer;

/**
 * @author justburrow
 * @since 2018. 9. 20.
 */
public class LongBoxer extends AbstractConverter<Long, Long> implements PrimitiveBoxer<Long, Long> {
    public static final LongBoxer SINGLETON = new LongBoxer();

    public LongBoxer() {
        super(Long.TYPE, Long.class);
    }

    public Long box(long primitive) {
        return primitive;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.PrimitiveBoxer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Long box(Long primitive) {
        return null == primitive
                ? JavaLangConstants.LONG_DEFAULT
                : primitive;
    }
}
