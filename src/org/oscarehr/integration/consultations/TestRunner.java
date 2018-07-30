package org.oscarehr.integration.consultations;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature"
//		,glue={"org.oscarehr.integration.consultations"}
		)
 
public class TestRunner {
 
}
