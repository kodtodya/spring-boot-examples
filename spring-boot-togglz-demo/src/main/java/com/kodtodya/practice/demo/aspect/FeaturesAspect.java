package com.kodtodya.practice.demo.aspect;

import com.kodtodya.practice.demo.config.FeatureAssociation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class FeaturesAspect {

    private static final Logger LOG = Logger.getLogger("FeaturesAspect");

    @Around("@within(featureAssociation) || @annotation(featureAssociation)")
    public Object checkAspect(ProceedingJoinPoint joinPoint, FeatureAssociation featureAssociation) throws Throwable {
 
        if (featureAssociation.value().isActive()) {
            return joinPoint.proceed();
        } else {
            LOG.info("Feature " + featureAssociation.value().name() + " is not enabled!");
            return null;
        }
    }
}