package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractConverter;
import kr.lul.commons.util.PrimitiveBoxer;

/**
 * @author justburrow
 * @since 2018. 9. 20.
 */
public class ShortArrayBoxer
        extends AbstractConverter<short[], Short[]>
        implements PrimitiveBoxer<short[], Short[]> {
    public static final ShortArrayBoxer SINGLETON = new ShortArrayBoxer();

    public ShortArrayBoxer() {
        super(short[].class, Short[].class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.PrimitiveBoxer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Short[] box(short[] primitive) {
        Short[] array = new Short[primitive.length];
        for (int i = 0; i < primitive.length; i++) {
            array[i] = primitive[i];
        }
        return array;
    }
}
