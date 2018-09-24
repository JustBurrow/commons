package kr.lul.commons.util.converter;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.time.Period;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2018. 9. 24.
 */
public class PeriodComposerTest {
    private static final Logger log = getLogger(PeriodComposerTest.class);
    public static final int LOOP_COUNT = 100;

    public static Period[] periods(int length) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Period[] array = new Period[length];
        for (int i = 0; i < length; i++) {
            array[i] = Period.of(random.nextInt(), random.nextInt(), random.nextInt());
        }
        return array;
    }

    private PeriodComposer composer;

    private ThreadLocalRandom random;

    @Before
    public void setUp() throws Exception {
        this.composer = new PeriodComposer();

        if (null == this.random) {
            this.random = ThreadLocalRandom.current();
        } else {
            this.random.setSeed(this.random.nextLong());
        }
    }

    @Test
    public void testComposeWithNull() throws Exception {
        assertThat(this.composer.compose(null))
                .isNull();
    }

    @Test
    public void testCompose() throws Exception {
        asList(periods(this.random.nextInt(1, LOOP_COUNT))).forEach(expected -> {
            log.info("GIVEN - expected={}", expected);

            // When
            String actual = this.composer.compose(expected);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotEmpty();
            assertThat(Period.parse(actual))
                    .isEqualTo(expected);
        });
    }
}
