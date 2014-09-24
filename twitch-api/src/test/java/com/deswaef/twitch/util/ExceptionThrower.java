package com.deswaef.twitch.util;

@FunctionalInterface
public interface ExceptionThrower {
    void throwException() throws Throwable;
}