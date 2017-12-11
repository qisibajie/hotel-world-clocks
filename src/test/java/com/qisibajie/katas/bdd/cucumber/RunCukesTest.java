package com.qisibajie.katas.bdd.cucumber;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(format = {"pretty", "html:target/cucumber-html-report", "json-pretty:target/cucumber-report.json"}
                        , features = "src/test/resources")
public class RunCukesTest {
}
