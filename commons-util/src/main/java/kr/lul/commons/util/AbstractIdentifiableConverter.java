package kr.lul.commons.util;

import static kr.lul.commons.util.Arguments.notNull;

/**
 * 컨버터 부분 구현.
 *
 * @author justburrow
 * @since 2018. 9. 17.
 */
public abstract class AbstractIdentifiableConverter<S, T> implements IdentifiableConverter<S, T> {
    protected final Class<S> sourceType;
    protected final Class<T> targetType;
    protected final ConverterIdentifier id;

    protected AbstractIdentifiableConverter(Class<S> sourceType, Class<T> targetType) {
        notNull(sourceType, "sourceType");
        notNull(targetType, "targetType");

        this.sourceType = sourceType;
        this.targetType = targetType;
        this.id = new ConverterIdentifier(sourceType, targetType);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // lul.kr.commons.util.IdentifiableConverter
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public ConverterIdentifier getId() {
        return this.id;
    }

    @Override
    public Class<S> getSourceClass() {
        return this.sourceType;
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
        if (obj instanceof AbstractIdentifiableConverter) {
            return this.id.equals(((AbstractIdentifiableConverter) obj).getId());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.id.toString();
    }
}
