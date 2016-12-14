/**
 */
package kr.lul.common.util;

import static kr.lul.common.util.Asserts.matches;
import static kr.lul.common.util.Asserts.notNull;

import java.lang.reflect.Field;

/**
 * @author Just Burrow
 * @since 2016. 11. 18.
 */
public abstract class FieldUtils {
  /**
   * 지정한 클래스를 포함한 상위 클래스에서 오브젝트의 필드를 찾아 반환한다. 접근자는 변경하지 않는다.
   *
   * @param clz
   *          기준 클래스. 이 클래스 혹은 이 클래스의 조상 클래스에서 필드를 찾는다.
   * @param name
   *          필드 이름.
   * @param obj
   * @return 없으면 <code>null</code>.
   * @author Just Burrow
   * @since 2016. 11. 18.
   */
  public static <C> Field getFieldIncludeAncestors(Class<C> clz, String name, C obj) {
    notNull(clz, "clz");
    matches(name, "[a-z]\\w*", "name");
    notNull(obj, "obj");

    try {
      return clz.getDeclaredField(name);
    } catch (NoSuchFieldException | SecurityException e) {
      if (Object.class == clz) {
        return null;
      }
    }

    Class<?> targetClass = clz.getSuperclass();
    Class<?> superClass = targetClass.getSuperclass();
    Field field = null;
    do {
      try {
        field = targetClass.getDeclaredField(name);
      } catch (NoSuchFieldException | SecurityException e) {
        if (null == superClass) {
          return field;
        } else {
          superClass = superClass.getSuperclass();
        }
        targetClass = targetClass.getSuperclass();
      }
    } while (null == field && targetClass != superClass);
    return field;
  }
}
