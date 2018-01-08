package com.org.learningCucumber;
import java.io.IOException;
//import java.util.Arrays;
//import java.util.Collection;

//import org.junit.Test;
//import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//import org.junit.runners.Parameterized.Parameters;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//import cucumber.runtime.junit.JUnitOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src\\main\\java",glue={"com\\org\\learningCucumber"})
public class RunnerTest {
	
	
	
}

