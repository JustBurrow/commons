package kr.lul.commons.test;

import org.junit.Before;

import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author justburrow
 * @since 2018. 9. 17.
 */
public class AbstractTest {
    private ThreadLocalRandom random;
    private Instant instantBefore;

    @Before
    public void setUp() throws Exception {
        if (null == this.random) {
            this.random = ThreadLocalRandom.current();
        } else {
            this.random.setSeed(this.random.nextLong());
        }

        this.instantBefore = Instant.now();
    }
}
