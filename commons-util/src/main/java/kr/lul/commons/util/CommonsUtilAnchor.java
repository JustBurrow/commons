package kr.lul.commons.util;

/**
 * @author justburrow
 * @since 2018. 9. 17.
 */
public class CommonsUtilAnchor implements Anchor {
    public static final Package PACKAGE = CommonsUtilAnchor.class.getPackage();
    public static final String PACKAGE_NAME = PACKAGE.getName();

    protected CommonsUtilAnchor() {
        throw new UnsupportedOperationException();
    }
}
