package kr.lul.commons.util;

/**
 * 오브젝트를 문자열로 변환한다.
 * {@link IdentifiableConverter} 중에서 문자열로 변환하는 특수한 형태.
 *
 * @param <S> 문자열로 변환할 수 있는 오브젝트의 클래스.
 *
 * @author justburrow
 * @since 2018. 9. 19.
 */
public interface IdentifiableComposer<S> extends Composer<S>, IdentifiableConverter<S, String> {
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.IdentifiableConverter
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    default Class<String> getTargetClass() {
        return String.class;
    }
}
