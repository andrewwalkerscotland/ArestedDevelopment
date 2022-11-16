package com.andrewwalkerscotland.ArestedDevelopment;

import org.springframework.stereotype.Component;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@Component
public class UsersActions {
    Response response;
    public void getUsers() {
        response = RestAssured.get("https://reqres.in/api/users?page=2");
    }

    public Response getUsersResponse() {
        return response;
    }
}
