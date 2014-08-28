package com.deswaef.twitch.util;

import static org.fest.assertions.Fail.fail;

/**
 * User: Quinten
 * Date: 2-8-2014
 * Time: 00:06
 *
 * @author Quinten De Swaef
 */
public final class TwitchTestHelper {

    /**
     * asserts that a code block throws following exception
     *
     * @param expectedException
     * @param runBlock
     * @param <X>
     * @return
     */
    public static <X extends Throwable> Throwable assertThrows(final Class<X> expectedException,
                                                final Runnable runBlock) {
        try {
            runBlock.run();
        } catch(Throwable ex) {
            if(expectedException.isInstance(ex)) {
                return ex;
            }
            fail(String.format("Block of code throw wrong Exception.\nExpected: %s\nActual:%s", expectedException.getName(), ex.getClass().getName()));
            return null;
        }
        fail(String.format("Block of code did not throw an exception.\nExpected: %s", expectedException.getName()));
        return null;
    }

    /**
     * asserts that the codeblock throws following exception, but also provides ways to do additional assertions
     * @param expectedException
     * @param runBlock
     * @param assertionBlock
     * @param <X>
     * @return
     */
    public static <X extends Throwable> Throwable assertThrows(final Class<X> expectedException,
                                                               final Runnable runBlock,
                                                               final ExceptionAssertiable assertionBlock) {
        try {
            runBlock.run();

        } catch(Throwable ex) {
            if(expectedException.isInstance(ex)) {
                assertionBlock.apply(ex);
                return ex;
            }
            fail(String.format("Block of code throw wrong Exception.\nExpected: %s\nActual:%s", expectedException.getName(), ex.getClass().getName()));
            return null;
        }
        fail(String.format("Block of code did not throw an exception.\nExpected: %s", expectedException.getName()));
        return null;
    }


}
