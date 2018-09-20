package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractConverter;
import kr.lul.commons.util.PrimitiveBoxer;

/**
 * @author justburrow
 * @since 2018. 9. 20.
 */
public class BooleanArrayBoxer
        extends AbstractConverter<boolean[], Boolean[]>
        implements PrimitiveBoxer<boolean[], Boolean[]> {
    public static final BooleanArrayBoxer SINGLETON = new BooleanArrayBoxer();

    public BooleanArrayBoxer() {
        super(boolean[].class, Boolean[].class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.PrimitiveBoxer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Boolean[] box(final boolean[] primitive) {
        Boolean[] array = new Boolean[primitive.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = primitive[i];
        }
        return array;
    }
}
