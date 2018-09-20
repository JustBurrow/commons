package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractConverter;
import kr.lul.commons.util.JavaLangConstants;
import kr.lul.commons.util.PrimitiveBoxer;

/**
 * @author justburrow
 * @since 2018. 9. 20.
 */
public class IntBoxer extends AbstractConverter<Integer, Integer> implements PrimitiveBoxer<Integer, Integer> {
    public static final IntBoxer SINGLETON = new IntBoxer();

    public IntBoxer() {
        super(Integer.TYPE, Integer.class);
    }

    public Integer box(int i) {
        return i;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.PrimitiveBoxer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Integer box(Integer primitive) {
        return null == primitive
                ? JavaLangConstants.INT_DEFAULT
                : primitive;
    }
}
