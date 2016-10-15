/**
 */
package kr.lul.common.api;

import static java.lang.String.format;

/**
 * @author Just Burrow
 * @since 2016. 10. 12.
 */
public interface Namespace {
  /**
   * @author Just Burrow
   * @since 2016. 10. 15.
   */
  public static final String DELIMITER = "/";

  /**
   * 상위 네임스페이스의 표준 이름.
   *
   * @return
   * @author Just Burrow
   * @since 2016. 10. 13.
   */
  public String getNamespace();

  /***
   * @return
   * @author Just Burrow
   * @since 2016. 10. 12.
   */
  public String getSimpleName();

  /**
   * {@link #getSimpleName()}의 알리아스.
   *
   * @return
   * @author Just Burrow
   * @since 2016. 10. 15.
   * @see #getSimpleName()
   */
  default public String getName() {
    return getSimpleName();
  }

  /**
   * @return
   * @author Just Burrow
   * @since 2016. 10. 12.
   */
  default public String getCanonicalName() {
    return format("%s%s%s", getNamespace(), DELIMITER, getSimpleName());
  }
}
