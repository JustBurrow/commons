/**
 */
package kr.lul.common.api;

import static java.lang.String.format;

import java.time.Instant;

/**
 * API 정의.
 *
 * @author Just Burrow
 * @since 2016. 10. 7.
 */
public interface Api extends Namespace {
  /**
   * @return
   * @author Just Burrow
   * @since 2016. 10. 7.
   */
  public Module getModule();

  /**
   * @return
   * @author Just Burrow
   * @since 2016. 10. 7.
   */
  public Block getBlock();

  /**
   * @return
   * @author Just Burrow
   * @since 2016. 10. 7.
   */
  public Type getType();

  /**
   * API 만료 시각.
   *
   * @return
   * @author Just Burrow
   * @since 2016. 10. 12.
   */
  public Instant getExpire();

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // <I>Namespace
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  /**
   * @return
   * @author Just Burrow
   * @since 2016. 10. 12.
   */
  @Override
  default public String getNamespace() {
    return getBlock().getCanonicalName();
  }

  /**
   * 전체 경로.
   *
   * @return
   * @author Just Burrow
   * @since 2016. 10. 7.
   */
  @Override
  default public String getCanonicalName() {
    return format("%s %s/%s", getType(), getBlock().getCanonicalName(), getName());
  }
}
