package com.socks.api.services;

import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ApiService {
    protected RequestSpecification setup() {
        return RestAssured
                .given().contentType(ContentType.JSON)
                .filters(getFilters());
    }

    private List<Filter> getFilters() {
        Boolean enableLog = Boolean.valueOf(System.getProperty("logging", "true"));

        if (enableLog) {
            return Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter());
        }

        return Collections.emptyList();
    }
}
