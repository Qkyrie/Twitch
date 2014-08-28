package com.deswaef.twitch.configuration;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * User: Quinten
 * Date: 28-8-2014
 * Time: 14:43
 *
 * @author Quinten De Swaef
 */
public class TwitchBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //TODO: register Twitch Bean
    }
}
