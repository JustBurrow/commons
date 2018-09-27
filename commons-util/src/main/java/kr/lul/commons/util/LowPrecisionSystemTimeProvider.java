package kr.lul.commons.util;

import java.time.Instant;
import java.time.ZoneId;

/**
 * 시스템 시각 설정을 기준으로 밀리세컨드 단위의 낮은 정밀도로 시각 정보를 제공한다.
 *
 * @author justburrow
 * @since 2018. 9. 27.
 */
public class LowPrecisionSystemTimeProvider implements TimeProvider {
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.TimeProvider
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public ZoneId zoneId() {
        return ZoneId.systemDefault();
    }

    @Override
    public Instant now() {
        return Instant.ofEpochMilli(System.currentTimeMillis());
    }
}
