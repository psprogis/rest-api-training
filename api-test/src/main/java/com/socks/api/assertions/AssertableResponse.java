package com.socks.api.assertions;

import com.socks.api.conditions.Condition;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AssertableResponse {

    private final Response register;

    public AssertableResponse shouldHave(Condition condition) {
        condition.check(register);

        return this;
    }
}
