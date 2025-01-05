package cucumber;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = { "stepDefination",
		"SwagLabs" }, tags = "@Reg", plugin = "json:target/jsonReports/testreports.json")
public class TestRunner {

}