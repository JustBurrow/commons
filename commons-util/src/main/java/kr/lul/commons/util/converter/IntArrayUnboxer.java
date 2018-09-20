package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractConverter;
import kr.lul.commons.util.PrimitiveUnboxer;

/**
 * @author justburrow
 * @since 2018. 9. 20.
 */
public class IntArrayUnboxer
        extends AbstractConverter<Integer[], int[]>
        implements PrimitiveUnboxer<Integer[], int[]> {
    public static final IntArrayUnboxer SINGLETON = new IntArrayUnboxer();

    public IntArrayUnboxer() {
        super(Integer[].class, int[].class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.PrimitiveUnboxer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public int[] unbox(Integer[] primitive) {
        int[] array = new int[primitive.length];
        for (int i = 0; i < primitive.length; i++) {
            array[i] = primitive[i];
        }
        return array;
    }
}
