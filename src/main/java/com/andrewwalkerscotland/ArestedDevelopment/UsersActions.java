package com.andrewwalkerscotland.ArestedDevelopment;

import java.util.List;

import org.springframework.stereotype.Component;

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
        List<UsersItem> usersItems =
            response.getBody().jsonPath().getList("data", UsersItem.class);
        return usersItems;
    }

    public UsersItem getSingleUsersFromResponse() {
        return response.getBody().jsonPath().getObject("data", UsersItem.class);
    }
}
