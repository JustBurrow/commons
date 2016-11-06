/**
 */
package kr.lul.common.api;

import static java.lang.String.format;

import java.time.Instant;

/**
 * API 정의.
 * 기본적으로 {@link Api}를 상속한 <code>enum</code>에서 상세 내용을 정의한다.
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
  public Operation getOperation();

  /**
   * {@link Module}이나 {@link Block}은 이름만으로 구분할 수 있기 때문에 {@link #getCanonicalName()}으로 구분할 수 있지만,
   * {@link Api} 수준에서는 이름과 {@link Operation}을 함께 고려해야 한다.
   * API 수준에서 문자열로 구분할 때 사용한다.
   *
   * @return
   * @author Just Burrow
   * @since 2016. 11. 5.
   * @see #getCanonicalName()
   */
  default public String getSignature() {
    return format("%s %s", getOperation(), getCanonicalName());
  }

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
   * @see #getSignature()
   */
  @Override
  default public String getCanonicalName() {
    return format("%s/%s", getBlock().getCanonicalName(), getSimpleName());
  }
}
