/**
 *
 */
package kr.lul.common.data;

import java.time.Instant;

/**
 * 애플리케이션 로직에서 생성과 갱신이 가능한 데이터.
 *
 * @author Just Burrow
 * @since 2016. 8. 25.
 */
public interface Updatable {
  /**
   * 데이터 생성 시각.
   *
   * @return 데이터 생성 시각.
   * @author Just Burrow
   * @since 2016. 8. 25.
   */
  public Instant getCreate();

  /**
   * 엔티티 저장 시각.
   *
   * @return 데이터 저장 시각.
   * @author Just Burrow
   * @since 2016. 8. 25.
   */
  public Instant getUpdate();
}
