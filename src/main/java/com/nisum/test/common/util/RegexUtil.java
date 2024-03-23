package com.nisum.test.common.util;

import java.util.regex.Pattern;

public class RegexUtil {

    public static boolean validateRegex(String value, String pattern) {
        return Pattern.compile(pattern).matcher(value).matches();
    }
}
