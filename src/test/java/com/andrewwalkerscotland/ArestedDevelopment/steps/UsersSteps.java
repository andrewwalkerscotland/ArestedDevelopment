package com.andrewwalkerscotland.ArestedDevelopment.steps;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.andrewwalkerscotland.ArestedDevelopment.UsersActions;
import com.andrewwalkerscotland.ArestedDevelopment.UsersItem;
import com.andrewwalkerscotland.ArestedDevelopment.config.ApplicationConfig;

import io.cucumber.java.en.And;
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

    @Given("I hit the get endpoint for users page {string}")
    public void hitGetUsersEndpointPage(String pageNo) {
        usersActions.getUsers(pageNo);
    }

    @Then("the response will have status {int}")
    public void assertResponseStatus(Integer statusCode) {
        response = usersActions.getUsersResponse();
        assertThat(response.statusCode())
            .as("Response Code not 200")
            .isEqualTo(200);
    }

    @Given("I hit the get endpoint for user id {int}")
    public void hitTheGetEndpointForSingleUser(int userId) {
        usersActions.getSingleUser(userId);
    }

    @Then("the response will contain {int} users")
    public void theResponseWillContainUsers(int listSize) {
        List<UsersItem> responseList = usersActions.getUsersListFromResponse();
        assertThat(responseList.size())
            .as("Number of items in response not as expected")
            .isEqualTo(listSize);
    }

    @And("the user email will be {string}")
    public void theUserEmailWillBe(String expectedEmail) {
        UsersItem usersItem = usersActions.getSingleUsersFromResponse();
        assertThat(usersItem.getEmail())
            .as("Email address not as expected")
            .isEqualTo(expectedEmail);
    }

    @And("the user first name will be {string}")
    public void theUserFirstNameWillBe(String expectedFirstName) {
        UsersItem usersItem = usersActions.getSingleUsersFromResponse();
        assertThat(usersItem.getFirst_name())
            .as("First name not as expected")
            .isEqualTo(expectedFirstName);
    }

    @And("the user last name will be {string}")
    public void theUserLastNameWillBe(String expectedLastName) {
        UsersItem usersItem = usersActions.getSingleUsersFromResponse();
        assertThat(usersItem.getLast_name())
            .as("Last name not as expected")
            .isEqualTo(expectedLastName);
    }

    @And("the user avatar link will be {string}")
    public void theUserAvatarLinkWillBe(String expectedAvatar) {
        UsersItem usersItem = usersActions.getSingleUsersFromResponse();
        assertThat(usersItem.getAvatar())
            .as("Avatar not as expected")
            .isEqualTo(expectedAvatar);
    }
}
