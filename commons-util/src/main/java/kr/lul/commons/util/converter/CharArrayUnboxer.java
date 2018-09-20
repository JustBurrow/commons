package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractConverter;
import kr.lul.commons.util.PrimitiveUnboxer;

/**
 * @author justburrow
 * @since 2018. 9. 20.
 */
public class CharArrayUnboxer
        extends AbstractConverter<Character[], char[]>
        implements PrimitiveUnboxer<Character[], char[]> {
    public static final CharArrayUnboxer SINGLETON = new CharArrayUnboxer();

    public CharArrayUnboxer() {
        super(Character[].class, char[].class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.PrimitiveUnboxer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public char[] unbox(Character[] primitive) {
        char[] array = new char[primitive.length];
        for (int i = 0; i < primitive.length; i++) {
            array[i] = primitive[i];
        }
        return array;
    }
}
