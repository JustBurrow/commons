/**
 */
package kr.lul.common.api;

/**
 * API 유틸리티.
 *
 * @author Just Burrow
 * @since 2016. 10. 13.
 */
public interface ApiUtil {
  /**
   * API와 정확히 일치하는 패턴.
   *
   * @param namespace
   * @return
   * @author Just Burrow
   * @since 2016. 10. 13.
   */
  public String pattern(Namespace namespace);

  /**
   * API와 자식 API와 일치하는 패턴.
   *
   * @param namespace
   * @return
   * @author Just Burrow
   * @since 2016. 10. 15.
   */
  public String childrenPattern(Namespace namespace);

  /**
   * API와 자손 API와 일치하는 패턴.
   *
   * @param namespace
   * @return
   * @author Just Burrow
   * @since 2016. 10. 13.
   */
  public String subPattern(Namespace namespace);

  /**
   * 정규표현식을 제거한 API 정의를 반환한다.
   *
   * @param namespace
   * @return
   * @author Just Burrow
   * @since 2016. 10. 15.
   */
  public String stripRegex(Namespace namespace);
}
