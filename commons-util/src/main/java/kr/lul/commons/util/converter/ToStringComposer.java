package kr.lul.commons.util.converter;

import kr.lul.commons.util.ComposeException;
import kr.lul.commons.util.Composer;

import java.util.Arrays;

/**
 * {@link Object#toString()} 대용 컴포저.
 *
 * @author justburrow
 * @see Object#toString()
 * @since 2018. 9. 20.
 */
public class ToStringComposer implements Composer<Object> {
    public static final ToStringComposer INSTANCE;

    static {
        synchronized (ToStringComposer.class) {
            INSTANCE = new ToStringComposer();
        }
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

    public String compose(boolean[] array) {
        return Arrays.toString(array);
    }

    public String compose(byte[] array) {
        return Arrays.toString(array);
    }

    public String compose(short[] array) {
        return Arrays.toString(array);
    }

    public String compose(int[] array) {
        return Arrays.toString(array);
    }

    public String compose(long[] array) {
        return Arrays.toString(array);
    }

    public String compose(float[] array) {
        return Arrays.toString(array);
    }

    public String compose(double[] array) {
        return Arrays.toString(array);
    }

    public String compose(char[] array) {
        return Arrays.toString(array);
    }

    public <T> String compose(T[] array) {
        return Arrays.toString(array);
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
