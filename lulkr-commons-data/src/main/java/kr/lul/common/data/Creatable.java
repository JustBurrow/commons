/**
 *
 */
package kr.lul.common.data;

import java.time.Instant;

/**
 * 생성할 수는 있지만 수정할 수 없는 데이터.
 *
 * @author Just Burrow
 * @since 2016. 8. 25.
 */
public interface Creatable {
  /**
   * 데이터 생성 시각.
   *
   * @return 데이터 생성 시각.
   * @author Just Burrow
   * @since 2016. 8. 25.
   */
  public Instant getCreate();
}
