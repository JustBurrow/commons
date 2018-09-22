package kr.lul.commons.util;

/**
 * 문자열을 해석해 목표 오브젝트의 클래스로 변환한다.
 * {@link IdentifiableConverter} 중에서 문자열을 해성하는 특수한 형태.
 *
 * @param <T> 목표 클래스.
 *
 * @author justburrow
 * @since 2018. 9. 17.
 */
public interface IdentifiableParser<T> extends Parser<T>, IdentifiableConverter<String, T> {
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.IdentifiableConverter
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    default Class<String> getSourceClass() {
        return String.class;
    }
}
