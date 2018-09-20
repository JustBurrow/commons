package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractConverter;
import kr.lul.commons.util.PrimitiveUnboxer;

/**
 * @author justburrow
 * @since 2018. 9. 20.
 */
public class DoubleArrayUnboxer
        extends AbstractConverter<Double[], double[]>
        implements PrimitiveUnboxer<Double[], double[]> {
    public static final DoubleArrayUnboxer SINGLETON = new DoubleArrayUnboxer();

    public DoubleArrayUnboxer() {
        super(Double[].class, double[].class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.PrimitiveUnboxer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public double[] unbox(Double[] primitive) {
        double[] array = new double[primitive.length];
        for (int i = 0; i < primitive.length; i++) {
            array[i] = primitive[i];
        }
        return array;
    }
}
