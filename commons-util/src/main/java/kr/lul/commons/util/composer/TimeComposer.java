package kr.lul.commons.util.composer;

import kr.lul.commons.util.ComposeException;
import kr.lul.commons.util.Composer;

import java.time.*;
import java.time.format.DateTimeFormatter;

import static kr.lul.commons.util.Arguments.notNull;
import static kr.lul.commons.util.JavaLangConstants.*;

/**
 * {@code java.time} 패키지의 클래스의 컴포저 위임.
 *
 * @author justburrow
 * @since 2018. 9. 24.
 */
public class TimeComposer implements Composer<Object> {
    private InstantComposer instantComposer;
    private ZoneIdComposer zoneIdComposer;

    private ZonedDateTimeComposer zonedDateTimeComposer;
    private OffsetDateTimeComposer offsetDateTimeComposer;
    private LocalDateTimeComposer localDateTimeComposer;
    private LocalDateComposer localDateComposer;
    private LocalTimeComposer localTimeComposer;

    private PeriodComposer periodComposer;
    private DurationComposer durationComposer;

    public TimeComposer() {
        this(ZonedDateTimeComposer.DEFAULT_FORMATTER,
                OffsetDateTimeComposer.DEFAULT_FORMATTER,
                LocalDateTimeComposer.DEFAULT_FORMATTER,
                LocalDateComposer.DEFAULT_FORMATTER,
                LocalTimeComposer.DEFAULT_FORMATTER);
    }

    public TimeComposer(DateTimeFormatter zonedDateTime, DateTimeFormatter offsetDateTime,
            DateTimeFormatter localDateTime, DateTimeFormatter localDate, DateTimeFormatter localTime) {
        notNull(zonedDateTime, "zonedDateTime");
        notNull(offsetDateTime, "offsetDateTime");
        notNull(localDateTime, "localDateTime");
        notNull(localDate, "localDate");
        notNull(localTime, "localTime");

        this.instantComposer = new InstantComposer();
        this.zoneIdComposer = new ZoneIdComposer();

        this.zonedDateTimeComposer = new ZonedDateTimeComposer(zonedDateTime);
        this.offsetDateTimeComposer = new OffsetDateTimeComposer(offsetDateTime);
        this.localDateTimeComposer = new LocalDateTimeComposer(localDateTime);
        this.localDateComposer = new LocalDateComposer(localDate);
        this.localTimeComposer = new LocalTimeComposer(localTime);

        this.periodComposer = new PeriodComposer();
        this.durationComposer = new DurationComposer();
    }

    public InstantComposer getInstantComposer() {
        return this.instantComposer;
    }

    public ZoneIdComposer getZoneIdComposer() {
        return this.zoneIdComposer;
    }

    public ZonedDateTimeComposer getZonedDateTimeComposer() {
        return this.zonedDateTimeComposer;
    }

    public OffsetDateTimeComposer getOffsetDateTimeComposer() {
        return this.offsetDateTimeComposer;
    }

    public LocalDateTimeComposer getLocalDateTimeComposer() {
        return this.localDateTimeComposer;
    }

    public LocalDateComposer getLocalDateComposer() {
        return this.localDateComposer;
    }

    public LocalTimeComposer getLocalTimeComposer() {
        return this.localTimeComposer;
    }

    public PeriodComposer getPeriodComposer() {
        return this.periodComposer;
    }

    public DurationComposer getDurationComposer() {
        return this.durationComposer;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Composer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public String compose(Object time) throws ComposeException {
        if (null == time) {
            return null;
        }

        switch (time.getClass().getName()) {
            case INSTANT_CLASS_NAME:
                return this.instantComposer.compose((Instant) time);
            case ZONE_ID_CLASS_NAME:
                return this.zoneIdComposer.compose((ZoneId) time);
            case ZONED_DATE_TIME_CLASS_NAME:
                return this.zonedDateTimeComposer.compose((ZonedDateTime) time);
            case OFFSET_DATE_TIME_CLASS_NAME:
                return this.offsetDateTimeComposer.compose((OffsetDateTime) time);
            case LOCAL_DATE_TIME_CLASS_NAME:
                return this.localDateTimeComposer.compose((LocalDateTime) time);
            case LOCAL_DATE_CLASS_NAME:
                return this.localDateComposer.compose((LocalDate) time);
            case LOCAL_TIME_CLASS_NAME:
                return this.localTimeComposer.compose((LocalTime) time);
            case PERIOD_CLASS_NAME:
                return this.periodComposer.compose((Period) time);
            case DURATION_CLASS_NAME:
                return this.durationComposer.compose((Duration) time);
            default:
                throw new IllegalArgumentException("unsupported time class : " + time.getClass());
        }
    }
}
