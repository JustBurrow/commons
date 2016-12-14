/**
 */
package kr.lul.common.util;

import static kr.lul.common.util.FieldUtils.getFieldIncludeAncestors;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

/**
 * @author Just Burrow
 * @since 2016. 12. 12.
 */
public class FieldUtilsTest {
  private static final String TEST_FIELD_NAME = "aaa";

  @Test
  public void testGetFieldIncludeAncestorsWithNullAndNullAndNull() throws Exception {
    assertThatThrownBy(() -> getFieldIncludeAncestors(null, null, null)).isInstanceOf(AssertionException.class);
  }

  @Test
  public void testGetFieldIncludeAncestorsWithNullAndNullAndObject() throws Exception {
    assertThatThrownBy(() -> getFieldIncludeAncestors(null, null, new Object())).isInstanceOf(AssertionException.class);
  }

  @Test
  public void testGetFieldIncludeAncestorsWithNullAndEmptyFieldNameAndObject() throws Exception {
    assertThatThrownBy(() -> getFieldIncludeAncestors(null, "", new Object())).isInstanceOf(AssertionException.class);
  }

  @Test
  public void testGetFieldIncludeAncestorsWithObjectClassAndNullAndNull() throws Exception {
    assertThatThrownBy(() -> getFieldIncludeAncestors(Object.class, null, null))
        .isInstanceOfAny(NullPointerException.class, AssertionException.class);
  }

  @Test
  public void testGetFieldIncludeAncestorsWithObjectAndEmptyFieldNameAndNull() throws Exception {
    assertThatThrownBy(() -> getFieldIncludeAncestors(Object.class, "", null)).isInstanceOf(AssertionException.class);
  }

  @Test
  public void testGetFieldIncludeAncestorsWithObjectClassAndNullAndObject() throws Exception {
    assertThatThrownBy(() -> getFieldIncludeAncestors(Object.class, null, new Object()))
        .isInstanceOfAny(NullPointerException.class, AssertionException.class);
  }

  @Test
  public void testGetFieldIncludeAncestorsWithObjectClassAndEmptyFieldNameAndObject() throws Exception {
    assertThatThrownBy(() -> getFieldIncludeAncestors(Object.class, "", new Object()))
        .isInstanceOf(AssertionException.class);
  }

  @Test
  public void testGetFieldIncludeAncestorsWithNotExistFieldName() throws Exception {
    // When
    assertThat(getFieldIncludeAncestors(Object.class, "zzzzZ__Z", new Object())).isNull();
  }

  @Test
  public void testGetFieldIncludeAncestorsWithFieldInParentClass() throws Exception {
    // Given
    class A {
      @SuppressWarnings("unused")
      private Object aaa;
    }
    class B extends A {
    }

    // When & Then
    assertThat(getFieldIncludeAncestors(B.class, TEST_FIELD_NAME, new B())).isNotNull()
        .isEqualTo(A.class.getDeclaredField(TEST_FIELD_NAME));
  }

  @Test
  public void testGetFieldIncludeAncestorsWithOverridedField() throws Exception {
    // Given
    class A {
      @SuppressWarnings("unused")
      private Object aaa;
    }
    class B extends A {
      @SuppressWarnings("unused")
      private Object aaa;
    }

    // When & Then
    assertThat(getFieldIncludeAncestors(B.class, TEST_FIELD_NAME, new B())).isNotNull()
        .isEqualTo(B.class.getDeclaredField(TEST_FIELD_NAME))
        .isNotEqualTo(A.class.getDeclaredField(TEST_FIELD_NAME));
  }

  @Test
  public void testGetFieldIncludeAncestorsWithGrandParent() throws Exception {
    // Given
    class A {
      @SuppressWarnings("unused")
      private Object aaa;
    }
    class B extends A {
    }
    class C extends B {
    }

    // When & Then
    assertThat(getFieldIncludeAncestors(C.class, TEST_FIELD_NAME, new C()))
        .isEqualTo(A.class.getDeclaredField(TEST_FIELD_NAME));
  }

  @Test
  public void testGetFieldIncludeAncestorsWithOverridedByGrandChild() throws Exception {
    // Given
    class A {
      @SuppressWarnings("unused")
      private Object aaa;
    }
    class B extends A {
    }
    class C extends B {
      @SuppressWarnings("unused")
      private Object aaa;
    }

    // When & Then
    assertThat(getFieldIncludeAncestors(C.class, TEST_FIELD_NAME, new C()))
        .isNotEqualTo(A.class.getDeclaredField(TEST_FIELD_NAME))
        .isEqualTo(C.class.getDeclaredField(TEST_FIELD_NAME));
  }

  @Test
  public void testGetFieldIncludeAncestorsWithOverridedByChild() throws Exception {
    // Given
    class A {
      @SuppressWarnings("unused")
      private Object aaa;
    }
    class B extends A {
      @SuppressWarnings("unused")
      private Object aaa;
    }
    class C extends B {
    }

    // When & Then
    assertThat(getFieldIncludeAncestors(C.class, TEST_FIELD_NAME, new C()))
        .isNotEqualTo(A.class.getDeclaredField(TEST_FIELD_NAME))
        .isEqualTo(B.class.getDeclaredField(TEST_FIELD_NAME));
  }

  @Test
  public void testGetFieldIncludeAncestorsWith3GenerationsAndParentClass() throws Exception {
    // Given
    class A {
      @SuppressWarnings("unused")
      private Object aaa;
    }
    class B extends A {
      @SuppressWarnings("unused")
      private Object aaa;
    }
    class C extends B {
      @SuppressWarnings("unused")
      private Object aaa;
    }

    // When & Then
    assertThat(getFieldIncludeAncestors(B.class, TEST_FIELD_NAME, new C()))
        .isNotEqualTo(A.class.getDeclaredField(TEST_FIELD_NAME))
        .isEqualTo(B.class.getDeclaredField(TEST_FIELD_NAME))
        .isNotEqualTo(C.class.getDeclaredField(TEST_FIELD_NAME));
  }

  @Test
  public void testGetFieldIncludeAncestorsWithExtendedAndEmptyParent() throws Exception {
    // Given
    class A {
    }
    class B extends A {
      @SuppressWarnings("unused")
      private Object aaa;
    }

    // When & Then
    assertThat(getFieldIncludeAncestors(A.class, TEST_FIELD_NAME, new B())).isNull();
  }
}