/**
 */
package kr.lul.common.api;

import static java.lang.String.format;

/**
 * API 네임 스페이스.
 *
 * @author Just Burrow
 * @since 2016. 10. 7.
 */
public interface Block extends Namespace {
  /**
   * @return
   * @author Just Burrow
   * @since 2016. 10. 12.
   */
  public Module getModule();

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
    return getModule().getCanonicalName();
  }

  /*
   * (non-Javadoc)
   * @author Just Burrow
   * @since 2016. 10. 12.
   */
  @Override
  default String getCanonicalName() {
    return format("%s/%s", getModule().getCanonicalName(), getName());
  }
}
