/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carrental.sampledata;

import cz.muni.fi.pa165.CarRegister.conf.ServiceConfiguration;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author robha
 */

@Configuration
@Import(ServiceConfiguration.class)
@ComponentScan(basePackageClasses = {SampleDataLoadingFacadeImpl.class})
public class CarRentalWithSampleDataConfiguration {

    final static Logger log = LoggerFactory.getLogger(CarRentalWithSampleDataConfiguration.class);

    @Inject
    SampleDataLoadingFacade sampleDataLoadingFacade;

    @PostConstruct
    public void dataLoading() throws IOException {
        log.debug("dataLoading()");
        sampleDataLoadingFacade.loadData();
    }
}

