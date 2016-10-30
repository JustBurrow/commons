/**
 */
package kr.lul.common.util;

/**
 * @author Just Burrow
 * @since 2016. 10. 27.
 */
public interface SettableLazyValue<V> extends LazyValue<V> {
  /**
   * @param value
   * @author Just Burrow
   * @since 2016. 10. 27.
   */
  public void set(V value);
}
