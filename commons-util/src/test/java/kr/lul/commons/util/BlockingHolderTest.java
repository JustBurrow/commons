package kr.lul.commons.util;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.lang.Thread.State;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2018. 9. 22.
 */
public class BlockingHolderTest {
    private static final Logger log = getLogger(BlockingHolderTest.class);

    public static final long TEST_TIMEOUT = 100L;

    private BlockingHolder<Object> holder;

    private ThreadLocalRandom random;
    private Instant before;

    @Before
    public void setUp() throws Exception {
        this.holder = new BlockingHolder<>();
        if (null == this.random) {
            this.random = ThreadLocalRandom.current();
        } else {
            this.random.setSeed(this.random.nextLong());
        }

        this.before = Instant.now();

        log.info("SETUP - holder={}, before={}", this.holder, this.before);
    }

    @Test(timeout = TEST_TIMEOUT)
    public void testConstructor() throws Exception {
        // When
        BlockingHolder<Object> actual = new BlockingHolder<>();
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .extracting(BlockingHolder::isSet)
                .containsSequence(false);

        Thread thread = new Thread(() -> {
            actual.get();
        });
        thread.start();
        Thread.sleep(1L);
        assertThat(thread.getState())
                .isSameAs(State.WAITING);
    }

    @Test(timeout = TEST_TIMEOUT)
    public void testConstructorWithNull() throws Exception {
        // When
        BlockingHolder<Object> actual = new BlockingHolder<>(null);
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .extracting(BlockingHolder::isSet, BlockingHolder::get)
                .containsSequence(true, null);
        assertThat(actual.get())
                .isNull();
        assertThatThrownBy(() -> actual.set(null))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("already set");
        assertThatThrownBy(() -> actual.set(new Object()))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("already set");
    }

    @Test
    public void testSetTwice() throws Exception {
        // Given
        Object object = new Object();
        this.holder.set(object);
        log.info("GIVEN - holder={}", this.holder);

        // When & Then
        assertThatThrownBy(() -> this.holder.set(object))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("already set");
        assertThatThrownBy(() -> this.holder.set(null))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("already set");
    }

    @Test(timeout = TEST_TIMEOUT)
    public void testGet() throws Exception {
        // Given
        Object expected = new Object();
        log.info("GIVEN - expected={}", expected);

        // When
        this.holder.set(expected);
        log.info("WHEN - holder={}", this.holder);

        // Then
        assertThat(this.holder)
                .extracting(BlockingHolder::isSet, BlockingHolder::get)
                .containsSequence(true, expected);
        assertThat(this.holder.get())
                .isSameAs(expected);
    }

    @Test(timeout = TEST_TIMEOUT)
    public void testGetTwice() throws Exception {
        // Given
        Object expected = new Object();
        this.holder.set(expected);
        log.info("GIVEN - expected={}, holder={}", expected, this.holder);

        // When
        this.holder.get();
        Object actual = this.holder.get();
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isSameAs(expected);
    }

    @Test(timeout = 5 * TEST_TIMEOUT)
    public void testBlockingGet() throws Exception {
        // Given
        final long blockTime = this.random.nextLong(2 * TEST_TIMEOUT, 5 * TEST_TIMEOUT - 10);
        Object expected = new Object();
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(blockTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.holder.set(expected);
        });

        // When
        thread.start();
        Object actual = this.holder.get();
        log.info("WHEN - actual={}", actual);

        // Then
        assertThat(actual)
                .isSameAs(expected)
                .isSameAs(this.holder.get());
        assertThat(Instant.now())
                .isAfterOrEqualTo(this.before.plusMillis(blockTime))
                .isBefore(this.before.plusMillis(2 * blockTime));
    }
}
