package com.andrewwalkerscotland.ArestedDevelopment.steps;

import org.springframework.test.context.ContextConfiguration;

import com.andrewwalkerscotland.ArestedDevelopment.config.ApplicationConfig;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = ApplicationConfig.class)
public class UsersSteps {
    @Given("I hit the get endpoint for users")
    public void hitGetUsersEndpoint() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the response will have status {int}")
    public void assertResponseStatus(Integer statusCode) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
