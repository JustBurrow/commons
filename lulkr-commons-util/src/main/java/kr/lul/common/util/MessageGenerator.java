/**
 */
package kr.lul.common.util;

/**
 * 문자열 메시지 생성용 유틸리티. 메시지를 동적으로 생성하지만, 조건에 따라 메시지 사용 여부가 다를 때 사용한다.
 * 메시지 생성 로직이 가벼울 경우엔 사용하지 않는 것이 좋다.
 *
 * @author Just Burrow
 * @since 2016. 10. 30.
 */
public interface MessageGenerator {
  /**
   * @return
   * @author Just Burrow
   * @since 2016. 10. 30.
   */
  public String message();
}
