package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractConverter;
import kr.lul.commons.util.JavaLangConstants;
import kr.lul.commons.util.PrimitiveBoxer;

/**
 * @author justburrow
 * @since 2018. 9. 20.
 */
public class CharBoxer extends AbstractConverter<Character, Character> implements PrimitiveBoxer<Character, Character> {
    public static final CharBoxer SINGLETON = new CharBoxer();

    public CharBoxer() {
        super(Character.TYPE, Character.class);
    }

    public Character box(char primitive) {
        return primitive;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.PrimitiveBoxer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Character box(Character primitive) {
        return null == primitive
                ? JavaLangConstants.CHAR_DEFAULT
                : primitive;
    }
}
