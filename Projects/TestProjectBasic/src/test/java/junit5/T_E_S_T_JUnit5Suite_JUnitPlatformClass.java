package junit5;

import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeClassNamePatterns;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.ExcludeTags;

@RunWith(JUnitPlatform.class)
@SelectPackages("hamcrest")
@SelectClasses({TestSimpleJUnit5.class, T_E_S_T_JUnit5.class})
@IncludeClassNamePatterns({"^.*Test.*|^.*T_E_S_T_.*"})
@ExcludeClassNamePatterns({""})
@IncludeTags({"JUnit5"})
@ExcludeTags({"NonExistentTag"})
public class T_E_S_T_JUnit5Suite_JUnitPlatformClass {}