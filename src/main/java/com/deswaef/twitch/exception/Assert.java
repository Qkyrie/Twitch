package com.deswaef.twitch.exception;

/**
 * User: Quinten
 * Date: 5-7-2015
 * Time: 00:25
 *
 * @author Quinten De Swaef
 */
public class Assert {
    public static void notNull(Object input, String errorMessage) {
        if (input == null) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
