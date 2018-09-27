package kr.lul.commons.test;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;

import java.io.File;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author justburrow
 * @since 2018. 9. 17.
 */
public class AbstractTest {
    protected final ThreadLocalRandom random = ThreadLocalRandom.current();
    private Instant before;

    protected final Set<File> testFiles = new HashSet<>();

    @Before
    protected void setUp() throws Exception {
        this.random.setSeed(this.random.nextLong());
        this.before = Instant.now();
    }

    @After
    protected void tearDown() throws Exception {
        for (File file : this.testFiles) {
            FileUtils.deleteQuietly(file);
        }
        this.testFiles.clear();
    }
}
