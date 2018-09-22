package kr.lul.commons.util;

import java.util.Objects;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

/**
 * 어떤 변환을 수행하는지 알 수 있는 정보를 제공하는 컨버터.
 *
 * @param <S> 원본 클래스.
 * @param <T> 타겟 클래스.
 *
 * @author justburrow
 * @since 2018. 9. 17.
 */
public interface IdentifiableConverter<S, T> extends Converter<S, T> {
    /**
     * 컨버터를 구분할 수 있는 ID.
     * JPA 등에서 자주 사용하는 `ID`, `Id`는 이름 충돌을 고려해 사용 안함.
     */
    class ConverterType {
        protected final Class source;
        protected final Class target;

        public ConverterType(Class source, Class target) {
            requireNonNull(source, "source is null.");
            this.source = source;
            this.target = target;
        }

        public Class source() {
            return this.source;
        }

        public Class target() {
            return this.target;
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // java.lang.Object
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof IdentifiableConverter.ConverterType)) return false;
            ConverterType id = (ConverterType) o;
            return Objects.equals(this.source, id.source) &&
                    Objects.equals(this.target, id.target);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.source, this.target);
        }

        @Override
        public String toString() {
            return format("%s -> %s", this.source, this.target);
        }
    }

    /**
     * @return 컨버터 ID.
     */
    ConverterType getType();

    /**
     * @return 원본 오브젝트의 클래스.
     */
    Class<S> getSourceClass();

    /**
     * @return 목표 클래스.
     */
    Class<T> getTargetClass();
}
