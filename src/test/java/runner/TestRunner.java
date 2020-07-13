package runner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions (features ="src/test/java/features"  ,
tags =  "@end2end",
glue = {"steps"},plugin = {"pretty","html:target/cucumber-html-report"})
public class TestRunner extends TestBase {
	
}
