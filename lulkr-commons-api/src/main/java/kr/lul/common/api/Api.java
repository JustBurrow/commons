/**
 */
package kr.lul.common.api;

/**
 * API 정의.
 *
 * @author Just Burrow
 * @since 2016. 10. 7.
 */
public interface Api {
  /**
   * @return
   * @author Just Burrow
   * @since 2016. 10. 7.
   */
  public ServiceModule getServiceModule();

  /**
   * @return
   * @author Just Burrow
   * @since 2016. 10. 7.
   */
  public Namespace getNamespace();

  /**
   * @return
   * @author Just Burrow
   * @since 2016. 10. 7.
   */
  public Type getType();

  /**
   * 서비스 모듈, 네임스페이스를 제외한 API 경로.
   *
   * @return
   * @author Just Burrow
   * @since 2016. 10. 7.
   */
  public String getSubPath();

  /**
   * 전체 경로.
   *
   * @return
   * @author Just Burrow
   * @since 2016. 10. 7.
   */
  public String getPath();
}
