package kr.lul.commons.util.converter;

import kr.lul.commons.util.AbstractComposer;
import kr.lul.commons.util.ComposeException;

/**
 * {@link Object#toString()} 대용 컴포저.
 *
 * @author justburrow
 * @see Object#toString()
 * @since 2018. 9. 20.
 */
public class ToStringComposer extends AbstractComposer<Object> {
    public ToStringComposer() {
        super(Object.class);
    }

    public String compose(boolean b) {
        return Boolean.toString(b);
    }

    public String compose(byte b) {
        return Byte.toString(b);
    }

    public String compose(short s) {
        return Short.toString(s);
    }

    public String compose(int i) {
        return Integer.toString(i);
    }

    public String compose(long l) {
        return Long.toString(l);
    }

    public String compose(float f) {
        return Float.toString(f);
    }

    public String compose(double d) {
        return Double.toString(d);
    }

    public String compose(char c) {
        return Character.toString(c);
    }

    public String compose(String string) {
        return string;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Composer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public String compose(Object source) throws ComposeException {
        return null == source
                ? null
                : source.toString();
    }
}
