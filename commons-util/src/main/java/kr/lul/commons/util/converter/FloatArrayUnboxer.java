package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractConverter;
import kr.lul.commons.util.PrimitiveUnboxer;

/**
 * @author justburrow
 * @since 2018. 9. 20.
 */
public class FloatArrayUnboxer
        extends AbstractConverter<Float[], float[]>
        implements PrimitiveUnboxer<Float[], float[]> {
    public static final FloatArrayUnboxer SINGLETON = new FloatArrayUnboxer();

    public FloatArrayUnboxer() {
        super(Float[].class, float[].class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.PrimitiveUnboxer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public float[] unbox(Float[] primitive) {
        float[] array = new float[primitive.length];
        for (int i = 0; i < primitive.length; i++) {
            array[i] = primitive[i];
        }
        return array;
    }
}
