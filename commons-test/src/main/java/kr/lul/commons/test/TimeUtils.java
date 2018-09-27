package kr.lul.commons.test;

import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * @author justburrow
 * @since 2018. 9. 24.
 */
public abstract class TimeUtils {
    /**
     * @return 임의의 인스턴트.
     */
    public static Instant instant() {
        ThreadLocalRandom random = current();
        return Instant.ofEpochSecond(random.nextLong(-31557014167219200L, 31556889864403200L),
                random.nextLong(1000_000_000L));
    }

    /**
     * @return 임의의 시간대 ID.
     */
    public static ZoneId zoneId() {
        List<String> zoneIds = new ArrayList<>(ZoneId.SHORT_IDS.values());

        return ZoneId.of(zoneIds.get(current().nextInt(zoneIds.size())));
    }

    /**
     * @return 임의의 {@link ZoneOffset}.
     */
    public static ZoneOffset zoneOffset() {
        return ZoneOffset.ofTotalSeconds(current().nextInt(-64800, 64801));
    }

    /**
     * @return 임의의 {@link ZonedDateTime}.
     */
    public static ZonedDateTime zonedDateTime() {
        return instant().atZone(zoneId());
    }

    /**
     * @return 임의의 {@link OffsetDateTime}.
     */
    public static OffsetDateTime offsetDateTime() {
        return OffsetDateTime.ofInstant(instant(), zoneId());
    }

    /**
     * @return 임의의 {@link OffsetTime}
     */
    public static OffsetTime offsetTime() {
        return OffsetTime.ofInstant(instant(), zoneId());
    }

    /**
     * @return 임의의 {@link LocalDateTime}.
     */
    public static LocalDateTime localDateTime() {
        ThreadLocalRandom random = current();

        LocalDateTime ldt = null;
        do {
            try {
                ldt = LocalDateTime.of(random.nextInt(), random.nextInt(1, 13), random.nextInt(1, 31),
                        random.nextInt(24), random.nextInt(60), random.nextInt(60),
                        random.nextInt(1_000_000_000));
            } catch (DateTimeException e) {
            }
        } while (null == ldt);

        return ldt;
    }

    /**
     * @return 임의의 {@link LocalDate}.
     */
    public static LocalDate localDate() {
        ThreadLocalRandom random = current();

        LocalDate ld = null;
        do {
            try {
                ld = LocalDate.of(random.nextInt(),
                        random.nextInt(1, 13),
                        random.nextInt(1, 31));
            } catch (DateTimeException e) {
            }
        } while (null == ld);

        return ld;
    }

    /**
     * @return 임의의 {@link LocalTime}.
     */
    public static LocalTime localTime() {
        ThreadLocalRandom random = current();

        LocalTime lt = null;
        do {
            try {
                lt = LocalTime.of(random.nextInt(0, 24),
                        random.nextInt(60),
                        random.nextInt(60),
                        random.nextInt(1_000_000_000));
            } catch (DateTimeException e) {
            }
        } while (null == lt);

        return lt;
    }

    /**
     * @return 임의의 {@link Period}.
     */
    public static Period period() {
        ThreadLocalRandom random = current();
        return Period.of(random.nextInt(), random.nextInt(), random.nextInt());
    }

    /**
     * @return 임의의 {@link Duration}.
     */
    public static Duration duration() {
        return Duration.ofSeconds(current().nextLong(), current().nextLong());
    }

    private TimeUtils() {
        throw new UnsupportedOperationException();
    }
}
