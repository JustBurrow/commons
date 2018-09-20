package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractConverter;
import kr.lul.commons.util.JavaLangConstants;
import kr.lul.commons.util.PrimitiveBoxer;

/**
 * @author justburrow
 * @since 2018. 9. 20.
 */
public class DoubleBoxer extends AbstractConverter<Double, Double> implements PrimitiveBoxer<Double, Double> {
    public static final DoubleBoxer SINGLETON = new DoubleBoxer();

    public DoubleBoxer() {
        super(Double.TYPE, Double.class);
    }

    public Double box(double primitive) {
        return primitive;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.PrimitiveBoxer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Double box(Double primitive) {
        return null == primitive
                ? JavaLangConstants.DOUBLE_DEFAULT
                : primitive;
    }
}
