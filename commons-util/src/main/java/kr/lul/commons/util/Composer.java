package kr.lul.commons.util;

/**
 * 오브젝트를 문자열로 변환한다.
 * {@link Converter} 중에서 문자열로 변환하는 특수한 형태.
 *
 * @author justburrow
 * @since 2018. 9. 23.
 */
@FunctionalInterface
public interface Composer<S> extends Converter<S, String> {
    /**
     * 오브젝트를 문자열로 변환한다.
     *
     * @param source 원본 오브젝트.
     *
     * @return 오브젝트의 문자열.
     *
     * @see ComposeException 문자열로 변환 실패.
     * @see #convert(Object)
     */
    String compose(S source) throws ComposeException;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Converter
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    default String convert(S source) throws ConvertException {
        return compose(source);
    }
}
