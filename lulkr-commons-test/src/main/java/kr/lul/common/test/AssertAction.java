/**
 * @see https://github.com/JustBurrow/common
 */
package kr.lul.common.test;

import static kr.lul.common.util.Asserts.notEmpty;
import static kr.lul.common.util.Asserts.notNull;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;

/**
 * AssertJ의 {@link Assertions#assertThatThrownBy(ThrowingCallable)}용 도구.
 * 같은 테스트가 필요한 예외를 던지는 여러 개의 테스트를 묶어서 테스트한다.
 *
 * @author Just Burrow
 * @since 2016. 9. 2.
 * @see http://blog.lul.kr/2016/08/31/junit-assertj-lambda.html
 */
public interface AssertAction {
  /**
   * 인자로 받은 코드가 던지는 예외를 검증한다.
   *
   * @param action
   * @param callables
   * @author Just Burrow
   * @since 2016. 9. 2.
   */
  public static void assertThese(AssertAction action, ThrowingCallable... callables) {
    notNull(action, "action");
    notEmpty(callables, "callables");

    for (ThrowingCallable callable : callables) {
      action.test(callable);
    }
  }

  /**
   * 테스트 대상 코드를 실행하고 결과를 검증 한다.
   *
   * @param callable
   * @author Just Burrow
   * @since 2016. 9. 2.
   * @see {@link Assertions#assertThatThrownBy(ThrowingCallable)}
   */
  public void test(ThrowingCallable callable);
}
