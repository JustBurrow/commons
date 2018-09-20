package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractConverter;
import kr.lul.commons.util.PrimitiveBoxer;

/**
 * @author justburrow
 * @since 2018. 9. 20.
 */
public class DoubleArrayBoxer
        extends AbstractConverter<double[], Double[]>
        implements PrimitiveBoxer<double[], Double[]> {
    public static final DoubleArrayBoxer SINGLETON = new DoubleArrayBoxer();

    public DoubleArrayBoxer() {
        super(double[].class, Double[].class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.PrimitiveBoxer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Double[] box(double[] primitive) {
        Double[] array = new Double[primitive.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = primitive[i];
        }
        return array;
    }
}
