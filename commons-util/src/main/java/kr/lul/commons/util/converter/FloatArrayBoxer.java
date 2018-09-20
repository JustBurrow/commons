package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractConverter;
import kr.lul.commons.util.PrimitiveBoxer;

/**
 * @author justburrow
 * @since 2018. 9. 20.
 */
public class FloatArrayBoxer
        extends AbstractConverter<float[], Float[]>
        implements PrimitiveBoxer<float[], Float[]> {
    public static final FloatArrayBoxer SINGLETON = new FloatArrayBoxer();

    public FloatArrayBoxer() {
        super(float[].class, Float[].class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.PrimitiveBoxer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Float[] box(float[] primitive) {
        Float[] array = new Float[primitive.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = primitive[i];
        }
        return array;
    }
}
