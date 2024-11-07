package dsalgo_TestRunner;

import org.junit.runner.RunWith;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import dsalgo_hooks.Hooks;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/Features"},
//tags = "@TS_Queue_03",
publish=true,
glue= {"dsalgo_stepdefinition","dsalgo_hooks"},
plugin={"pretty","html:target/CucumberReports/CucumberReport.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})

public class Runner {
	

}
