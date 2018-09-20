package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractConverter;
import kr.lul.commons.util.PrimitiveUnboxer;

/**
 * @author justburrow
 * @since 2018. 9. 20.
 */
public class LongArrayUnboxer
        extends AbstractConverter<Long[], long[]>
        implements PrimitiveUnboxer<Long[], long[]> {
    public static final LongArrayUnboxer SINGLETON = new LongArrayUnboxer();

    public LongArrayUnboxer() {
        super(Long[].class, long[].class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.PrimitiveUnboxer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public long[] unbox(Long[] primitive) {
        long[] array = new long[primitive.length];
        for (int i = 0; i < primitive.length; i++) {
            array[i] = primitive[i];
        }
        return array;
    }
}
