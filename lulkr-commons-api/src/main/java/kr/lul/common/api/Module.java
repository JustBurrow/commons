/**
 */
package kr.lul.common.api;

/**
 * API를 제공하는 서비스 모듈.
 *
 * @author Just Burrow
 * @since 2016. 10. 7.
 */
public interface Module extends Namespace {
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // <I>Namespace
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  /*
   * (non-Javadoc)
   * @author Just Burrow
   * @since 2016. 10. 13.
   */
  @Override
  default String getNamespace() {
    return "/";
  }

  /*
   * (non-Javadoc)
   * @author Just Burrow
   * @since 2016. 10. 7.
   */
  @Override
  default public String getCanonicalName() {
    return "/" + getName();
  }
}
