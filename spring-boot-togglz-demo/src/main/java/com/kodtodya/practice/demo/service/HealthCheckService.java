package com.kodtodya.practice.demo.service;

import com.kodtodya.practice.demo.config.ToggleConfiguration;
import com.kodtodya.practice.demo.feature.AreYouOkayFeatures;
import com.kodtodya.practice.demo.config.FeatureAssociation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.repository.FeatureState;

import java.util.logging.Logger;

@Service
public class HealthCheckService {

    private static final Logger LOG = Logger.getLogger("HealthCheckService");

    @Autowired
    private ToggleConfiguration toggleConfiguration;

    @Autowired
    private FeatureManager featureManager;

    @FeatureAssociation(value = AreYouOkayFeatures.FEATURE_RUOK)
    public void validateAndRun() throws Exception {
        if( AreYouOkayFeatures.FEATURE_RUOK.isActive() ) {
            LOG.info("'Are you okay?' feature is Active.. and yeah, I'm feeling better.. let me disable this feature now.. ;)");
            featureManager.setFeatureState(new FeatureState(AreYouOkayFeatures.FEATURE_RUOK, false));
        } else {
            LOG.info("'Are you okay?' feature is not Active..activating now..");
            featureManager.setFeatureState(new FeatureState(AreYouOkayFeatures.FEATURE_RUOK, true));
        }
        LOG.info("---------------------------| Exit from validateAndRun |---------------------------");
    }

    public void enableFeature() throws Exception {
        LOG.info("'Are you okay?' feature is not Active..activating now..");
        featureManager.setFeatureState(new FeatureState(AreYouOkayFeatures.FEATURE_RUOK, true));
        LOG.info("---------------------------| Feature activated |---------------------------");
    }
}
