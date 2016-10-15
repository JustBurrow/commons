/**
 */
package kr.lul.common.api;

/**
 * @author Just Burrow
 * @since 2016. 10. 13.
 */
public class AntPatternApiUtil implements ApiUtil {
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // <I>ApiUtil
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  /*
   * (non-Javadoc)
   * @author Just Burrow
   * @since 2016. 10. 13.
   */
  @Override
  public String pattern(Namespace namespace) {
    String pattern = namespace.getCanonicalName();
    return pattern.replaceAll("\\{[^}]+\\}", "*");
  }

  /*
   * (non-Javadoc)
   * @author Just Burrow
   * @since 2016. 10. 15.
   */
  @Override
  public String childrenPattern(Namespace namespace) {
    String pattern = this.pattern(namespace);
    if (pattern.endsWith("/")) {
      pattern += "*";
    } else {
      pattern += "/*";
    }
    return pattern;
  }

  /*
   * (non-Javadoc)
   * @author Just Burrow
   * @since 2016. 10. 13.
   */
  @Override
  public String subPattern(Namespace namespace) {
    String pattern = this.pattern(namespace);
    if (pattern.endsWith("/")) {
      pattern += "**";
    } else {
      pattern += "/**";
    }
    return pattern;
  }

  /*
   * (non-Javadoc)
   * @author Just Burrow
   * @since 2016. 10. 15.
   */
  @Override
  public String stripRegex(Namespace namespace) {
    String definition = namespace.getCanonicalName();
    definition = definition.replaceAll(":[^}]+\\}", "}");
    return definition;
  }
}
