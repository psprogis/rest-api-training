package com.socks.api.conditions;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Conditions {
    public StatusCodeCondition statusCode(int code) {
        return new StatusCodeCondition(code);
    }
}
