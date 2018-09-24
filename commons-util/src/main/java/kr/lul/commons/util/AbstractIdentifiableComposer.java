package kr.lul.commons.util;

import java.util.Objects;

import static kr.lul.commons.util.Arguments.notNull;

/**
 * 컴포저 부분 구현.
 *
 * @param <S> 원본 자료형.
 *
 * @author justburrow
 * @since 2018. 9. 19.
 */
public abstract class AbstractIdentifiableComposer<S> implements IdentifiableComposer<S> {
    protected final Class<S> sourceType;
    protected final ConverterIdentifier id;

    protected AbstractIdentifiableComposer(Class<S> sourceType) {
        notNull(sourceType, "sourceType");

        this.sourceType = sourceType;
        this.id = new ConverterIdentifier(sourceType, String.class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.IdentifiableComposer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public ConverterIdentifier getId() {
        return this.id;
    }

    @Override
    public Class<S> getSourceClass() {
        return this.sourceType;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // java.lang.Object
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractIdentifiableComposer)) return false;
        AbstractIdentifiableComposer<?> that = (AbstractIdentifiableComposer<?>) o;
        return Objects.equals(this.id, that.id);
    }

    @Override
    public String toString() {
        return this.id.toString();
    }
}
