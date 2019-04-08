package tests.suites;

import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.IncludeClassNamePatterns;
import tests.selenium.Selenium;

@RunWith(JUnitPlatform.class)
@SelectPackages("tests")
@SelectClasses({Selenium.class})
@IncludeClassNamePatterns({"^.*"})

public class Suite_All {}