package kr.lul.commons.util;

import static kr.lul.commons.util.Arguments.notNull;

/**
 * 파서 부분 구현.
 *
 * @param <T> 목표 자료형.
 *
 * @author justburrow
 * @since 2018. 9. 17.
 */
public abstract class AbstractIdentifiableParser<T> implements IdentifiableParser<T> {
    protected final Class<T> targetType;
    protected final ConverterType id;

    protected AbstractIdentifiableParser(Class<T> targetType) {
        notNull(targetType, "targetType");

        this.targetType = targetType;
        this.id = new ConverterType(String.class, targetType);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // lul.kr.commons.util.IdentifiableParser
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public ConverterType getType() {
        return this.id;
    }

    @Override
    public Class<T> getTargetClass() {
        return this.targetType;
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
        if (obj instanceof AbstractIdentifiableParser) {
            return this.id.equals(((IdentifiableParser) obj).getType());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
