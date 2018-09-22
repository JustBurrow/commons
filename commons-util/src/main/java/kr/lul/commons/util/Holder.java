package kr.lul.commons.util;

/**
 * 오브젝트를 담아두고 액세스 할 수 도와준다.
 *
 * @param <T> 담아둘 오브젝트의 타입.
 *
 * @author justburrow
 * @since 2018. 9. 22.
 */
public interface Holder<T> {
    /**
     * @return 담아둔 오브젝트.
     */
    T get();
}
