package com.kodtodya.practice.demo.config;

import com.kodtodya.practice.demo.feature.AreYouOkayFeatures;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
public @interface FeatureAssociation {
    AreYouOkayFeatures value();
}