/**
 * @see https://github.com/JustBurrow/common
 */
package kr.lul.common.data;

import java.time.Instant;

/**
 * @author Just Burrow
 * @since 2016. 9. 28.
 */
public class UpdatableImpl implements Updatable {
  private Instant create;
  private Instant update;

  /**
   * @author Just Burrow
   * @since 2016. 9. 28.
   */
  public UpdatableImpl() {
  }

  /**
   * @author Just Burrow
   * @since 2016. 9. 28.
   * @param create
   * @param update
   */
  public UpdatableImpl(Instant create, Instant update) {
    this.create = create;
    this.update = update;
  }

  /**
   * @param create
   * @author Just Burrow
   * @since 2016. 9. 28.
   */
  public void setCreate(Instant create) {
    this.create = create;
  }

  /**
   * @param update
   * @author Just Burrow
   * @since 2016. 9. 28.
   */
  public void setUpdate(Instant update) {
    this.update = update;
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // <I>Updatable
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  /*
   * (non-Javadoc)
   * @author Just Burrow
   * @since 2016. 9. 28.
   */
  @Override
  public Instant getCreate() {
    return this.create;
  }

  /*
   * (non-Javadoc)
   * @author Just Burrow
   * @since 2016. 9. 28.
   */
  @Override
  public Instant getUpdate() {
    return this.update;
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Object
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public String toString() {
    return new StringBuilder(UpdatableImpl.class.getSimpleName())
        .append(" [create=").append(this.create)
        .append(", update=").append(this.update)
        .append("]").toString();
  }
}
