package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractConverter;
import kr.lul.commons.util.PrimitiveBoxer;

/**
 * @author justburrow
 * @since 2018. 9. 20.
 */
public class IntArrayBoxer
        extends AbstractConverter<int[], Integer[]>
        implements PrimitiveBoxer<int[], Integer[]> {
    public static final IntArrayBoxer SINGLETON = new IntArrayBoxer();

    public IntArrayBoxer() {
        super(int[].class, Integer[].class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.PrimitiveBoxer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Integer[] box(int[] primitive) {
        Integer[] array = new Integer[primitive.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = primitive[i];
        }
        return array;
    }
}
