/**
 * @see https://github.com/JustBurrow/common
 */
package kr.lul.data;

import java.time.Instant;

/**
 * @author Just Burrow
 * @since 2016. 9. 28.
 */
public class CreatableImpl implements Creatable {
  private Instant create;

  /**
   * @author Just Burrow
   * @since 2016. 9. 28.
   */
  public CreatableImpl() {
  }

  /**
   * @author Just Burrow
   * @since 2016. 9. 28.
   * @param create
   */
  public CreatableImpl(Instant create) {
    this.create = create;
  }

  /**
   * @param create
   * @author Just Burrow
   * @since 2016. 9. 28.
   */
  public void setCreate(Instant create) {
    this.create = create;
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // <I>Creatable
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

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Object
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public String toString() {
    return new StringBuilder(CreatableImpl.class.getSimpleName())
        .append(" [create=").append(this.create)
        .append("]").toString();
  }
}
