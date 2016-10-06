/**
 * @see https://github.com/JustBurrow/common
 */
package kr.lul.common.data;

/**
 * @author Just Burrow
 * @since 2016. 9. 3.
 * @param <ID>
 */
public interface ObjectIdDomainObject<ID> extends Updatable {
  /**
   * @return
   * @author Just Burrow
   * @since 2016. 9. 3.
   */
  public ID getId();
}
