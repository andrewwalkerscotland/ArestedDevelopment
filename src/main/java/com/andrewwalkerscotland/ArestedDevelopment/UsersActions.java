package com.andrewwalkerscotland.ArestedDevelopment;

import java.util.List;

import org.springframework.stereotype.Component;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.Json;
import io.restassured.RestAssured;
import io.restassured.response.Response;

@Component
public class UsersActions {
    Response response;

    public void getUsers(String pageNo) {
        response = RestAssured.get("https://reqres.in/api/users?page=" + pageNo);
    }

    public Response getUsersResponse() {
        return response;
    }

    public void getSingleUser(int userId) {
        response = RestAssured.get("https://reqres.in/api/users/" + userId);
    }

    public List<UsersItem> getUsersListFromResponse() {
        return response.getBody().jsonPath().getList("data", UsersItem.class);
    }

    public UsersItem getSingleUsersFromResponse() {
        return response.getBody().jsonPath().getObject("data", UsersItem.class);
    }

    public void getUsersList(int pageNo) {
        List<Json> responseData
            = RestAssured.given()
            .baseUri("https://reqres.in/api/users?page=" + pageNo)
            .when()
            .get()
            .getBody()
            .jsonPath()
            .getList("data");
        int wqerewq = responseData.size();
    }
}
