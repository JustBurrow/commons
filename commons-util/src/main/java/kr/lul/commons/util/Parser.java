package kr.lul.commons.util;

/**
 * 문자열을 해석해 목표 오브젝트의 클래스로 변환한다.
 * {@link Converter} 중에서 문자열을 해성하는 특수한 형태.
 *
 * @param <T> 목표 클래스.
 *
 * @author justburrow
 * @since 2018. 9. 17.
 */
public interface Parser<T> extends Converter<String, T> {
    /**
     * 문자열을 목표 클래스의 오브젝트로 변환한다.
     *
     * @param text 문자열.
     *
     * @return 목표 오브젝트.
     *
     * @throws ParseException 문자열 변환 실패.
     * @see #convert(String)
     */
    T parse(String text) throws ParseException;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Converter
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    default Class<String> getSourceClass() {
        return String.class;
    }

    @Override
    default T convert(String text) throws ConvertException {
        return parse(text);
    }
}
