package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractConverter;
import kr.lul.commons.util.JavaLangConstants;
import kr.lul.commons.util.PrimitiveBoxer;

/**
 * @author justburrow
 * @since 2018. 9. 20.
 */
public class ByteBoxer extends AbstractConverter<Byte, Byte> implements PrimitiveBoxer<Byte, Byte> {
    public static final ByteBoxer SINGLETON = new ByteBoxer();

    public ByteBoxer() {
        super(Byte.TYPE, Byte.class);
    }

    public Byte box(byte primitive) {
        return primitive;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.PrimitiveBoxer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Byte box(Byte primitive) {
        return null == primitive
                ? JavaLangConstants.BYTE_DEFAULT
                : primitive;
    }
}
