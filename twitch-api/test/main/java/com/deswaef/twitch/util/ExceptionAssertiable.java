package com.deswaef.twitch.util;

/**
 * User: Quinten
 * Date: 2-8-2014
 * Time: 00:25
 *
 * @author Quinten De Swaef
 */
@FunctionalInterface
public interface ExceptionAssertiable {
    <T extends Throwable> void apply(T throwable);
}
