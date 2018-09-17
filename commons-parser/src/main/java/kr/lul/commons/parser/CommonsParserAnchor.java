package kr.lul.commons.parser;

/**
 * @author justburrow
 * @since 2018. 9. 18.
 */
public class CommonsParserAnchor implements kr.lul.commons.util.Anchor {
    public static final Package PACKAGE = CommonsParserAnchor.class.getPackage();
    public static final String PACKAGE_NAME = PACKAGE.getName();

    protected CommonsParserAnchor() {
        throw new UnsupportedOperationException();
    }
}
