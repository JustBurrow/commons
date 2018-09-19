package kr.lul.commons.util;

import org.junit.Test;

import static kr.lul.commons.util.JavaLangConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author justburrow
 * @since 2018. 9. 20.
 */
public class JavaLangConstantsTest {
    @Test
    public void testPimitiveTypeNames() throws Exception {
        assertThat(BOOLEAN_TYPE_NAME).isEqualTo(Boolean.TYPE.getName());

        assertThat(BYTE_TYPE_NAME).isEqualTo(Byte.TYPE.getName());
        assertThat(SHORT_TYPE_NAME).isEqualTo(Short.TYPE.getName());
        assertThat(INTEGER_TYPE_NAME).isEqualTo(Integer.TYPE.getName());
        assertThat(LONG_TYPE_NAME).isEqualTo(Long.TYPE.getName());

        assertThat(FLOAT_TYPE_NAME).isEqualTo(Float.TYPE.getName());
        assertThat(DOUBLE_TYPE_NAME).isEqualTo(Double.TYPE.getName());

        assertThat(CHARACTER_TYPE_NAME).isEqualTo(Character.TYPE.getName());
    }

    @Test
    public void testPrimitiveArrayTypeName() throws Exception {
        assertThat(BOOLEAN_TYPE_ARRAY_CLASS_NAME).isEqualTo(boolean[].class.getName());

        assertThat(BYTE_TYPE_ARRAY_CLASS_NAME).isEqualTo(byte[].class.getName());
        assertThat(SHORT_TYPE_ARRAY_CLASS_NAME).isEqualTo(short[].class.getName());
        assertThat(INTEGER_TYPE_ARRAY_CLASS_NAME).isEqualTo(int[].class.getName());
        assertThat(LONG_TYPE_ARRAY_CLASS_NAME).isEqualTo(long[].class.getName());

        assertThat(FLOAT_TYPE_ARRAY_CLASS_NAME).isEqualTo(float[].class.getName());
        assertThat(DOUBLE_TYPE_ARRAY_CLASS_NAME).isEqualTo(double[].class.getName());

        assertThat(CHARACTER_TYPE_ARRAY_CLASS_NAME).isEqualTo(char[].class.getName());
        assertThat(STRING_ARRAY_CLASS_NAME).isEqualTo(String[].class.getName());
    }
}
