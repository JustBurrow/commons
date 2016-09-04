/**
 * @see https://github.com/JustBurrow/common
 */
package kr.lul.util;

/**
 * lazy return.
 * 멤버 필드가 아닌, 코드 실행으로 리턴 인스턴스를 만드는 경우에 코드 실행을 늦추기 위해 사용한다.
 * 주로 프록시를 사용한 어떤 처리가 끝난 후로 코드 실행을 미뤄야 하는 다음과 같은 경우.
 * <ul>
 * <li>스프링 트랜잭션 매니저가 실행하는 콜백 핸들러로 값을 정하는 타임스탬프.</li>
 * <li><code>AUTO_INCREMENT</code>인 ID.</li>
 * </ul>
 *
 * @author Just Burrow
 * @since 2016. 9. 4.
 * @param <V>
 *          리턴 타입.
 */
public interface Lazy<V> {
  /**
   * @return 리턴 값.
   * @author Just Burrow
   * @since 2016. 9. 4.
   */
  public V value();
}
