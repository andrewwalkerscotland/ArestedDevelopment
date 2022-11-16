package com.andrewwalkerscotland.ArestedDevelopment.steps;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.andrewwalkerscotland.ArestedDevelopment.UsersActions;
import com.andrewwalkerscotland.ArestedDevelopment.config.ApplicationConfig;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.response.Response;

@CucumberContextConfiguration
@ContextConfiguration(classes = ApplicationConfig.class)
public class UsersSteps {

    @Autowired
    UsersActions usersActions;
    Response response;

    public UsersSteps(UsersActions usersActions) {
        this.usersActions = usersActions;
    }

    @Given("I hit the get endpoint for users")
    public void hitGetUsersEndpoint() {
        usersActions.getUsers();
    }

    @Then("the response will have status {int}")
    public void assertResponseStatus(Integer statusCode) {
        response = usersActions.getUsersResponse();
        assertThat(response.statusCode())
            .as("Response Code not 200")
            .isEqualTo(200);
    }
}
