package kr.lul.commons.util;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2018. 9. 22.
 */
public class DefaultHolderTest {
    private static final Logger log = getLogger(DefaultHolderTest.class);

    private DefaultHolder<Object> holder;

    @Before
    public void setUp() throws Exception {
        this.holder = new DefaultHolder<>();
    }

    @Test
    public void testConstructorWithObject() throws Exception {
        // Given
        Object expected = new Object();
        log.info("GIVEN - expected={}", expected);

        // When
        var actual = new DefaultHolder<>(expected);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .extracting(DefaultHolder::isSet, DefaultHolder::get)
                .containsSequence(true, expected);
        assertThatThrownBy(() -> actual.set(null))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("already set");
        assertThatThrownBy(() -> actual.set(expected))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("already set");
        assertThatThrownBy(() -> actual.set(new Object()))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("already set");
    }

    @Test
    public void testGet() throws Exception {
        assertThat(this.holder.isSet())
                .isFalse();
        assertThat(this.holder.get())
                .isNull();
    }

    @Test
    public void testSetTwice() throws Exception {
        // Given
        this.holder.set(new Object());
        log.info("GIVEN - holder={}", this.holder);

        // Then
        assertThatThrownBy(() -> this.holder.set(new Object()))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("already set");
    }

    @Test
    public void testSetWithNull() throws Exception {
        // When
        this.holder.set(null);
        log.info("WHEN - holder={}", this.holder);

        // Then
        assertThat(this.holder.isSet())
                .isTrue();
        assertThat(this.holder.get())
                .isNull();
        assertThatThrownBy(() -> this.holder.set(null))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("already set");
        assertThatThrownBy(() -> this.holder.set(new Object()))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("already set");
    }

    @Test
    public void testSetAndGet() throws Exception {
        // Given
        Object expected = new Object();
        log.info("GIVEN - expected={}", expected);

        // When
        this.holder.set(expected);

        // Then
        assertThat(this.holder.isSet())
                .isTrue();
        assertThat(this.holder.get())
                .isSameAs(expected);
    }
}
