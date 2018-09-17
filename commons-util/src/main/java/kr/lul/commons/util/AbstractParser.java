package kr.lul.commons.util;

import static kr.lul.commons.util.Arguments.notNull;

/**
 * 파서 부분 구현.
 *
 * @author justburrow
 * @since 2018. 9. 17.
 */
public abstract class AbstractParser<T> implements Parser<T> {
    protected final Class<T> targetType;
    protected final ConverterId id;

    protected AbstractParser(Class<T> targetType) {
        notNull(targetType, "targetType");

        this.targetType = targetType;
        this.id = new ConverterId(String.class, targetType);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // lul.kr.commons.util.Parser
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Class<T> getTargetClass() {
        return this.targetType;
    }

    @Override
    public ConverterId getId() {
        return this.id;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // java.lang.Object
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) return false;
        if (this == obj) return true;
        if (obj instanceof AbstractParser) {
            return this.id.equals(((Parser) obj).getId());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
