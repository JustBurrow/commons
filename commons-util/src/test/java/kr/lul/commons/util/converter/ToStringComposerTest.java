package kr.lul.commons.util.converter;

import kr.lul.commons.util.Composer;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.util.concurrent.ThreadLocalRandom;

import static java.util.stream.IntStream.range;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2018. 9. 23.
 */
public class ToStringComposerTest {
    private static final Logger log = getLogger(ToStringComposerTest.class);
    private static final int LOOP_COUNT = 100;

    private ToStringComposer composer;

    private ThreadLocalRandom random;

    @Before
    public void setUp() throws Exception {
        this.composer = new ToStringComposer();

        if (null == this.random) {
            this.random = ThreadLocalRandom.current();
        } else {
            this.random.setSeed(this.random.nextLong());
        }
    }

    @Test
    public void testSingleton() throws Exception {
        assertThat(ToStringComposer.INSTANCE)
                .isNotNull()
                .isInstanceOf(ToStringComposer.class);
    }

    @Test
    public void testComposeWithBoolean() throws Exception {
        assertThat(this.composer.compose(true))
                .isEqualTo("true");
        assertThat(this.composer.compose(false))
                .isEqualTo("false");
    }

    @Test
    public void testComposeWithByte() throws Exception {
        range(0, LOOP_COUNT).forEach(i -> {
            // Given
            byte b = (byte) this.random.nextInt(Byte.MIN_VALUE, 1 + Byte.MAX_VALUE);
            log.info("GIVEN - b={}", b);

            // When
            String actual = this.composer.compose(b);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull()
                    .isEqualTo("" + b)
                    .isEqualTo(((Composer<Object>) this.composer).compose(b));
        });
    }

    @Test
    public void testComposeWithNullObject() throws Exception {
        assertThat(this.composer.compose((Object) null))
                .isEqualTo("null");
    }
}
