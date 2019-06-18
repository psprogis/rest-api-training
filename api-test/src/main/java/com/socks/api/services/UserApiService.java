package com.socks.api.services;

import com.socks.api.assertions.AssertableResponse;
import com.socks.api.payloads.UserPayload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserApiService extends ApiService {
    public AssertableResponse registerUser(UserPayload user) {
        return new AssertableResponse(setup()
                .body(user)
                .when()
                .post("register"));
    }
}
