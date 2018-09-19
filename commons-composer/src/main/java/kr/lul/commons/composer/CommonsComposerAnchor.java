package kr.lul.commons.composer;

/**
 * @author justburrow
 * @since 2018. 9. 19.
 */
public class CommonsComposerAnchor implements kr.lul.commons.util.Anchor {
    public static final Package PACKAGE = CommonsComposerAnchor.class.getPackage();
    public static final String PACKAGE_NAME = PACKAGE.getName();

    protected CommonsComposerAnchor() {
        throw new UnsupportedOperationException();
    }
}
