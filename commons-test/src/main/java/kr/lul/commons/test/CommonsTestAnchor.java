package kr.lul.commons.test;

/**
 * @author justburrow
 * @since 2018. 9. 17.
 */
public class CommonsTestAnchor implements kr.lul.commons.util.Anchor {
    public static final Package PACKAGE = CommonsTestAnchor.class.getPackage();
    public static final String PACKAGE_NAME = PACKAGE.getName();

    protected CommonsTestAnchor() {
        throw new UnsupportedOperationException();
    }
}
