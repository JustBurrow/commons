package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractConverter;
import kr.lul.commons.util.PrimitiveUnboxer;

/**
 * @author justburrow
 * @since 2018. 9. 20.
 */
public class BooleanArrayUnboxer
        extends AbstractConverter<Boolean[], boolean[]>
        implements PrimitiveUnboxer<Boolean[], boolean[]> {
    public static final BooleanArrayUnboxer SINGLETON = new BooleanArrayUnboxer();

    public BooleanArrayUnboxer() {
        super(Boolean[].class, boolean[].class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.PrimitiveUnboxer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean[] unbox(Boolean[] primitive) {
        boolean[] array = new boolean[primitive.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = primitive[i];
        }
        return array;
    }
}
