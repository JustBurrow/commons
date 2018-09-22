package kr.lul.commons.util;

/**
 * 담아둘 오브젝트를 홀더 생성 후 지정할 수 있는 홀더.
 *
 * @param <T> 담아둘 오브젝트 타입.
 *
 * @author justburrow
 * @since 2018. 9. 22.
 */
public interface SettableHolder<T> extends Holder<T> {
    /**
     * 오브젝트 담기.
     *
     * @param object 담아둘 오브젝트.
     *
     * @throws IllegalStateException 이미 오브젝트가 담겨있을 경우.
     */
    void set(T object) throws IllegalStateException;
}
