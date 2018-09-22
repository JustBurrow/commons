package kr.lul.commons.parser;

import kr.lul.commons.util.ParseException;
import kr.lul.commons.util.Strings;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.format;
import static kr.lul.commons.util.JavaLangConstants.PRIMITIVE_TYPES;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2018. 9. 18.
 */
public class ClassParserTest {
    private static final Logger log = getLogger(ClassParserTest.class);

    private ClassParser parser;

    private ThreadLocalRandom random;

    @Before
    public void setUp() throws Exception {
        this.parser = new ClassParser();

        if (null == this.random) {
            this.random = ThreadLocalRandom.current();
        } else {
            this.random.setSeed(this.random.nextLong());
        }
    }

    @Test
    public void testConvert_null() throws Exception {
        assertThat(this.parser.convert(null))
                .isNull();
    }

    @Test
    public void testConvert_기본_자료형() throws Exception {
        PRIMITIVE_TYPES.forEach(type -> {
            String name = type.getName();
            log.info("GIVEN - type={}, name={}", type, name);

            // When
            Class actual = this.parser.parse(name);
            log.info("WHEN - actual={}", actual);

            // Then
            assertThat(actual)
                    .isNotNull()
                    .isSameAs(type);
        });
    }

    @Test
    public void testConvert_일반적인_클래스() throws Exception {
        class TestClass {
        }

        List.of(Object.class, String.class, ClassParser.class, ClassParserTest.class, TestClass.class)
                .forEach(expected -> {
                    String name = expected.getName();
                    log.info("GIVEN - expected={}, name={}", expected, name);

                    // When
                    Class actual = this.parser.parse(name);
                    log.info("WHEN - actual={}", actual);

                    // Then
                    assertThat(actual)
                            .isNotNull()
                            .isSameAs(expected);
                });
    }

    @Test
    public void testConvert_존재하지_않는_클래스() throws Exception {
        // Given
        StringBuilder sb = new StringBuilder().append(randomAlphabetic(1, 5));
        for (int i = 0; i < 13; i++) {
            sb.append('.').append(randomAlphabetic(1, 10));
        }
        String name = format("%s.%s", sb.toString().toLowerCase(), Strings.capitalize(randomAlphabetic(2, 5)));
        log.info("GIVEN - name={}", name);

        // When & Then
        assertThatThrownBy(() -> this.parser.parse(name))
                .isInstanceOf(ParseException.class)
                .hasCauseInstanceOf(ClassNotFoundException.class)
                .hasMessageContaining(name);
    }
}
