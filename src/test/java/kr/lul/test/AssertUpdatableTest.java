/**
 * @see https://github.com/JustBurrow/common
 */
package kr.lul.test;

import static kr.lul.test.AssertUpdatable.createdAfter;
import static kr.lul.test.AssertUpdatable.createdAfterAndUpdatedAfter;
import static kr.lul.test.AssertUpdatable.updatedAfter;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.Instant;

import org.junit.Before;
import org.junit.Test;

import kr.lul.data.UpdatableImpl;
import kr.lul.util.AssertionException;
import kr.lul.util.AssertsTest;

/**
 * @author Just Burrow
 * @since 2016. 9. 28.
 */
public class AssertUpdatableTest extends AbstractJUnitTest {
  /**
   * @throws java.lang.Exception
   * @author Just Burrow
   * @since 2016. 9. 28.
   */
  @Before
  public void setUp() throws Exception {
    this.initialize();
  }

  @Test
  public void testCreatedAfterWithNull() {
    AssertsTest.assertThrowingCallables(AssertionException.class,
        () -> createdAfter(null, this.now),
        () -> createdAfter(new UpdatableImpl(), null),
        () -> createdAfter(null, null));
  }

  @Test
  public void testCreatedAfterWithEmptyUpdatable() throws Exception {
    assertThatThrownBy(() -> createdAfter(new UpdatableImpl(), this.now)).isInstanceOf(AssertionError.class);
  }

  @Test
  public void testCreatedAfter() throws Exception {
    createdAfter(new UpdatableImpl(Instant.now(), Instant.now()), this.now);
  }

  @Test
  public void testUpdatedAfterWithNull() throws Exception {
    AssertsTest.assertThrowingCallables(AssertionException.class,
        () -> updatedAfter(null, this.now),
        () -> updatedAfter(new UpdatableImpl(), null),
        () -> updatedAfter(null, null));
  }

  @Test
  public void testUpdatedAfeterWithEmptyUpdatable() throws Exception {
    assertThatThrownBy(() -> updatedAfter(new UpdatableImpl(), this.now)).isInstanceOf(AssertionError.class);
  }

  @Test
  public void testUpdateAfter() throws Exception {
    updatedAfter(new UpdatableImpl(Instant.now(), Instant.now()), this.now);
  }

  @Test
  public void testCreatedAfterAndUpdatedAfterWithNull() throws Exception {
    AssertsTest.assertThrowingCallables(AssertionException.class,
        () -> createdAfterAndUpdatedAfter(null, null, null),
        () -> createdAfterAndUpdatedAfter(null, null, this.now),
        () -> createdAfterAndUpdatedAfter(null, this.now, null),
        () -> createdAfterAndUpdatedAfter(null, this.now, this.now),
        () -> createdAfterAndUpdatedAfter(new UpdatableImpl(), null, null),
        () -> createdAfterAndUpdatedAfter(new UpdatableImpl(), null, this.now),
        () -> createdAfterAndUpdatedAfter(new UpdatableImpl(), this.now, null));
  }

  @Test
  public void testCreatedAfterAndUpdatedAfterWithEmptyUpdatable() throws Exception {
    assertThatThrownBy(() -> createdAfterAndUpdatedAfter(new UpdatableImpl(), this.now, this.now))
        .isInstanceOf(AssertionError.class);
  }

  @Test
  public void testCreatedAfterAndUpdatedAfter() throws Exception {
    createdAfterAndUpdatedAfter(new UpdatableImpl(Instant.now(), Instant.now()), this.now, this.now);
  }
}
