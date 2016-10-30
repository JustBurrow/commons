/**
 */
package kr.lul.common.util;

/**
 * @author Just Burrow
 * @since 2016. 10. 30.
 */
public class CurrentSettableLazyValue<V> implements SettableLazyValue<V> {
  private final Object lock   = new Object();
  private boolean      setted = false;
  private V            value;

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // <I>SettableLazyValue<V>
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  /*
   * (non-Javadoc)
   * @author Just Burrow
   * @since 2016. 10. 30.
   */
  @Override
  public void set(V value) {
    synchronized (this.lock) {
      if (this.setted) {
        throw new IllegalStateException("already setted.");
      }
      this.value = value;
      this.setted = true;
      this.lock.notifyAll();
    }
  }

  /*
   * (non-Javadoc)
   * @author Just Burrow
   * @since 2016. 10. 30.
   */
  @Override
  public V value() {
    synchronized (this.lock) {
      try {
        this.lock.wait();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      return this.value;
    }
  }
}
