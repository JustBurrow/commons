package kr.lul.commons.util;

/**
 * 설정을 사용해 오브젝트의 작동을 지정할 수 있는 오브젝트.
 *
 * @author justburrow
 * @since 2018. 9. 24.
 */
public interface Configurable<C> {
    /**
     * @return 설정.
     */
    C getConfig();
}
