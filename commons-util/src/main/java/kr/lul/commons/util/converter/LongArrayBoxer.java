package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractConverter;
import kr.lul.commons.util.PrimitiveBoxer;

/**
 * @author justburrow
 * @since 2018. 9. 20.
 */
public class LongArrayBoxer
        extends AbstractConverter<long[], Long[]>
        implements PrimitiveBoxer<long[], Long[]> {
    public static final LongArrayBoxer SINGLETON = new LongArrayBoxer();

    public LongArrayBoxer() {
        super(long[].class, Long[].class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.PrimitiveBoxer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Long[] box(long[] primitive) {
        Long[] array = new Long[primitive.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = primitive[i];
        }
        return array;
    }
}
