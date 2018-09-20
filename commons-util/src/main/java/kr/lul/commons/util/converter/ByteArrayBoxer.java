package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractConverter;
import kr.lul.commons.util.PrimitiveBoxer;

/**
 * @author justburrow
 * @since 2018. 9. 20.
 */
public class ByteArrayBoxer
        extends AbstractConverter<byte[], Byte[]>
        implements PrimitiveBoxer<byte[], Byte[]> {
    public static final ByteArrayBoxer SINGLETON = new ByteArrayBoxer();

    public ByteArrayBoxer() {
        super(byte[].class, Byte[].class);
    }

    @Override
    public Byte[] box(byte[] primitive) {
        Byte[] array = new Byte[primitive.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = primitive[i];
        }
        return array;
    }
}
