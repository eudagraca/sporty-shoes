package com.shoes.sporty.responses;

import com.google.gson.annotations.SerializedName;
import org.springframework.http.HttpStatus;

public class CustomResponse {
    @SerializedName("statusCode")
    private HttpStatus statusCode;
    @SerializedName("message")
    private String message;
    @SerializedName("body")

    private Object body;

    public CustomResponse(HttpStatus statusCode, String message, Object body) {
        this.statusCode = statusCode;
        this.message = message;
        this.body = body;
    }
}
