/**
 * @see https://github.com/JustBurrow/common
 */
package kr.lul.util;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Just Burrow
 * @since 2016. 9. 2.
 */
@RunWith(Suite.class)
@SuiteClasses({ Base64UrlNonceCodecTest.class, NonceGeneratorTest.class, NonceTest.class })
public class NonceTestSuite {
  public static final String HEX_CHARACTERS = "0123456789abcdef";
}
