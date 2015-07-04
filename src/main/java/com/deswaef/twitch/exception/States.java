package com.deswaef.twitch.exception;

/**
 * User: Quinten
 * Date: 5-7-2015
 * Time: 00:23
 *
 * @author Quinten De Swaef
 */
public class States {
    public static void state(boolean state, String errorMessage) {
        if (!state) {
            throw new IllegalStateException(errorMessage);
        }
    }
}
