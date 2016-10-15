/**
 */
package kr.lul.common.api;

import static java.lang.String.format;
import static kr.lul.common.util.RandomUtil.R;
import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Just Burrow
 * @since 2016. 10. 13.
 */
public class AntPatternApiUtilTest {
  private AntPatternApiUtil util;

  /**
   * @throws java.lang.Exception
   * @author Just Burrow
   * @since 2016. 10. 13.
   */
  @Before
  public void setUp() throws Exception {
    this.util = new AntPatternApiUtil();
  }

  @Test
  public void testPattern() throws Exception {
    // Given
    final String namespace = "/" + RandomStringUtils.randomAlphabetic(R.notNegative(10));
    final String name = RandomStringUtils.randomAlphanumeric(R.positive(10));
    final Namespace expect = new Namespace() {
      @Override
      public String getNamespace() {
        return namespace;
      }

      @Override
      public String getSimpleName() {
        return name;
      }
    };

    // When & Then
    assertThat(this.util.pattern(expect)).isEqualTo(format("%s/%s", namespace, name))
        .isEqualTo(expect.getCanonicalName());
  }

  @Test
  public void testPatternWithVariable() throws Exception {
    // Given
    final String namespace = "/" + RandomStringUtils.randomAlphabetic(R.positive(10));
    final String variable = RandomStringUtils.randomAlphabetic(R.positive(5));
    final String name = "{" + variable + "}/abc";
    final Namespace expect = new Namespace() {
      @Override
      public String getNamespace() {
        return namespace;
      }

      @Override
      public String getSimpleName() {
        return name;
      }
    };

    // When & Then
    assertThat(this.util.pattern(expect)).isEqualTo(format("%s/*/abc", namespace));
  }

  @Test
  public void testChildrenPattern() throws Exception {
    // Given
    final String namespace = "/" + RandomStringUtils.randomAlphabetic(R.notNegative(10));
    final String name = RandomStringUtils.randomAlphanumeric(R.positive(10));
    final Namespace expect = new Namespace() {
      @Override
      public String getNamespace() {
        return namespace;
      }

      @Override
      public String getSimpleName() {
        return name;
      }
    };

    // When & Then
    assertThat(this.util.childrenPattern(expect)).isEqualTo(format("%s/%s/*", namespace, name));
  }

  @Test
  public void testSubPattern() throws Exception {
    // Given
    final String namespace = "/" + RandomStringUtils.randomAlphabetic(R.notNegative(10));
    final String name = RandomStringUtils.randomAlphanumeric(R.positive(10));
    final Namespace expect = new Namespace() {
      @Override
      public String getNamespace() {
        return namespace;
      }

      @Override
      public String getSimpleName() {
        return name;
      }

      @Override
      public String getCanonicalName() {
        return format("%s/%s", this.getNamespace(), this.getSimpleName());
      }
    };

    // When & Then
    assertThat(this.util.subPattern(expect)).isEqualTo(format("%s/%s/**", namespace, name))
        .startsWith(expect.getCanonicalName())
        .endsWith("/**");
  }

  @Test
  public void testStripRegex() throws Exception {
    // Given
    final String namespace = "";
    final String name = "abc/{num:\\d+}/def";
    final Namespace expect = new Namespace() {
      @Override
      public String getNamespace() {
        return namespace;
      }

      @Override
      public String getSimpleName() {
        return name;
      }
    };

    // When & Then
    assertThat(this.util.stripRegex(expect)).isEqualTo("/abc/{num}/def");
  }
}
