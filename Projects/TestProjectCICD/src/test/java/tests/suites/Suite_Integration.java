package tests.suites;

import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;

@RunWith(JUnitPlatform.class)
@SelectPackages("tests.integration")
@IncludeClassNamePatterns({"^.*Integration.*"})

public class Suite_Integration {}