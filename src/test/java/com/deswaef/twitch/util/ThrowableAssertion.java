package com.deswaef.twitch.util;


import static org.fest.assertions.Assertions.assertThat;

public class ThrowableAssertion {

    public static ThrowableAssertion assertThrown(ExceptionThrower exceptionThrower) {
        try {
            exceptionThrower.throwException();
        } catch (Throwable caught) {
            return new ThrowableAssertion(caught);
        }
        throw new ExceptionNotThrownAssertionError();
    }

    private final Throwable caught;

    public ThrowableAssertion(Throwable caught) {
        this.caught = caught;
    }

    public ThrowableAssertion isInstanceOf(Class<? extends Throwable> exceptionClass) {
        assertThat(caught).isInstanceOf(exceptionClass);
        return this;
    }

    public ThrowableAssertion hasMessage(String expectedMessage) {
        assertThat(caught.getMessage()).isEqualTo(expectedMessage);
        return this;
    }

    public ThrowableAssertion hasNoCause() {
        assertThat(caught.getCause()).isNull();
        return this;
    }

    public ThrowableAssertion hasCauseInstanceOf(Class<? extends Throwable> exceptionClass) {
        assertThat(caught.getCause()).isNotNull();
        assertThat(caught.getCause()).isInstanceOf(exceptionClass);
        return this;
    }
}