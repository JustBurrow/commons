package kr.lul.commons.util.parser;

import kr.lul.commons.util.ParseException;
import kr.lul.commons.util.Parser;

/**
 * 사용하는 측에서 타입에 따라 분기를 할 필요 없도록 하기 위한 클래스.
 *
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class StringParser implements Parser<String> {
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Parser
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public String parse(String text) throws ParseException {
        return text;
    }
}
