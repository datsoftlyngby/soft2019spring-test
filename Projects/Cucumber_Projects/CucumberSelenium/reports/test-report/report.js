$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("cucumberselenium/sample.feature");
formatter.feature({
  "name": "Login Functionality Feature",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Login Functionality",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "user navigates to the-internet.herokuapp.com/login",
  "keyword": "* "
});
formatter.match({
  "location": "LoginTest.navigatePage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user logs in using Username as \"tomsmith\"",
  "keyword": "* "
});
formatter.match({
  "location": "LoginTest.user_logs_in_using_Username_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "password as \"SuperSecretPassword!\"",
  "keyword": "* "
});
formatter.match({
  "location": "LoginTest.password_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "login should be successful",
  "keyword": "* "
});
formatter.match({
  "location": "LoginTest.login_should_be_successful()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Home page should be displayed",
  "keyword": "* "
});
formatter.match({
  "location": "LoginTest.home_page_should_be_displayed()"
});
formatter.result({
  "status": "passed"
});
});