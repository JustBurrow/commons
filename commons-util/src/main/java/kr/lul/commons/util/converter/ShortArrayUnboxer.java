package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractConverter;
import kr.lul.commons.util.PrimitiveUnboxer;

/**
 * @author justburrow
 * @since 2018. 9. 20.
 */
public class ShortArrayUnboxer
        extends AbstractConverter<Short[], short[]>
        implements PrimitiveUnboxer<Short[], short[]> {
    public static final ShortArrayUnboxer SINGLETON = new ShortArrayUnboxer();

    public ShortArrayUnboxer() {
        super(Short[].class, short[].class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.PrimitiveUnboxer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public short[] unbox(Short[] primitive) {
        short[] array = new short[primitive.length];
        for (int i = 0; i < primitive.length; i++) {
            array[i] = primitive[i];
        }
        return array;
    }
}
