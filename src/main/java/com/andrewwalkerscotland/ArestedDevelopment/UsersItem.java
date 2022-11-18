package com.andrewwalkerscotland.ArestedDevelopment;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;

public class UsersItem {

    @JsonProperty
    private int id;

    @JsonProperty
    private String email;

    @JsonProperty
    private String first_name;

    @JsonProperty
    private String last_name;

    @JsonProperty
    private String avatar;

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAvatar() {
        return avatar;
    }
}
