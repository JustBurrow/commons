package kr.lul.commons.util;

/**
 * 담아둘 오브젝트가 설정되었는지 확인할 수 있는 홀더.
 *
 * @param <T> 담아둘 오브젝트 타입.
 *
 * @author justburrow
 * @since 2018. 9. 22.
 */
public interface CheckableHolder<T> extends Holder<T> {
    /**
     * @return 설정되었으면 {@code true}.
     */
    boolean isSet();
}
