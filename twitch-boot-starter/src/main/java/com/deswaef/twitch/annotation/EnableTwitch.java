package com.deswaef.twitch.annotation;

import com.deswaef.twitch.configuration.TwitchBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * User: Quinten
 * Date: 28-8-2014
 * Time: 14:38
 *
 * @author Quinten De Swaef
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(TwitchBeanDefinitionRegistrar.class)
public @interface EnableTwitch {
}
