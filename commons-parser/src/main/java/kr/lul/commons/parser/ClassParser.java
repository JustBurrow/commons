package kr.lul.commons.parser;

import kr.lul.commons.util.AbstractParser;
import kr.lul.commons.util.ParseException;

import static kr.lul.commons.util.Arguments.notEmpty;
import static kr.lul.commons.util.Constants.*;

/**
 * @author justburrow
 * @since 2018. 9. 18.
 */
public class ClassParser extends AbstractParser<Class> {
    public ClassParser() {
        super(Class.class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Converter
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Class convert(String text) throws ParseException {
        if (null == text) {
            return null;
        }
        notEmpty(text, "text");

        switch (text) {
            case BOOLEAN_TYPE_NAME:
                return Boolean.TYPE;
            case BYTE_TYPE_NAME:
                return Byte.TYPE;
            case SHORT_TYPE_NAME:
                return Short.TYPE;
            case INTEGER_TYPE_NAME:
                return Integer.TYPE;
            case LONG_TYPE_NAME:
                return Long.TYPE;
            case FLOAT_TYPE_NAME:
                return Float.TYPE;
            case DOUBLE_TYPE_NAME:
                return Double.TYPE;
            case CHARACTER_TYPE_NAME:
                return Character.TYPE;
        }

        try {
            return Class.forName(text);
        } catch (ClassNotFoundException e) {
            throw new ParseException(e.getLocalizedMessage(), e);
        }
    }
}
