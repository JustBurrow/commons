package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractConverter;
import kr.lul.commons.util.PrimitiveBoxer;

/**
 * @author justburrow
 * @since 2018. 9. 20.
 */
public class CharArrayBoxer
        extends AbstractConverter<char[], Character[]>
        implements PrimitiveBoxer<char[], Character[]> {
    public static final CharArrayBoxer SINGLETON = new CharArrayBoxer();

    public CharArrayBoxer() {
        super(char[].class, Character[].class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.PrimitiveBoxer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Character[] box(char[] primitive) {
        Character[] array = new Character[primitive.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = primitive[i];
        }
        return array;
    }
}
