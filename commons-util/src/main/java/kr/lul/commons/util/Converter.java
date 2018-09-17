package kr.lul.commons.util;

import java.util.Objects;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

/**
 * 어떤 클래스의 오브젝트를 다른 클래스의 오브젝트로 변환하는 코드의 공통 인터페이스.
 * 공통의 인터페이스를 제공해 사용자 측에서는 분기문을 사용하지 않고 오버로딩으로 단순한 코드를 작성할 수 있도록 돕는다.
 *
 * @param <S> 원본 클래스.
 * @param <T> 타겟 클래스.
 *
 * @author justburrow
 * @since 2018. 9. 17.
 */
public interface Converter<S, T> {
    /**
     * 컨버터를 구분할 수 있는 ID.
     * JPA 등에서 자주 사용하는 `ID`, `Id`는 이름 충돌을 고려해 사용 안함.
     */
    class ConverterId {
        protected final Class source;
        protected final Class target;

        public ConverterId(Class source, Class target) {
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
            if (!(o instanceof Converter.ConverterId)) return false;
            ConverterId id = (ConverterId) o;
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
     * @return 원본 오브젝트의 클래스.
     */
    Class<S> getSourceClass();

    /**
     * @return 목표 클래스.
     */
    Class<T> getTargetClass();

    /**
     * @return 컨버터 ID.
     */
    ConverterId getId();

    /**
     * 원본 오브젝트를 목표 클래스의 오브젝트로 변환한다.
     *
     * @param source 원본 오브젝트.
     *
     * @return 변환된 목표 클래스의 오브젝트.
     */
    T convert(S source);
}
