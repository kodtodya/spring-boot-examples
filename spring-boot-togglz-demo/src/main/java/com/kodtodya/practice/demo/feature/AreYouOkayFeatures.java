package com.kodtodya.practice.demo.feature;

import org.togglz.core.Feature;
import org.togglz.core.annotation.EnabledByDefault;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;

public enum AreYouOkayFeatures implements Feature {

    @Label("Are you Okay")
    //@EnabledByDefault
    FEATURE_RUOK;
    
    public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);
    }
    
}