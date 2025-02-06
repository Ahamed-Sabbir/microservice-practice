package com.sabbir.util;

import com.sabbir.model.CustomHttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseBuilder {

    public static ResponseEntity<CustomHttpResponse> buildSuccessResponse(HttpStatus httpStatus,
                                                                          Map<String, Object> responseBody){
        CustomHttpResponse successResponse = CustomHttpResponse
                .builder()
                .httpStatus(httpStatus)
                .responseBody(responseBody)
                .build();
        return new ResponseEntity<>(successResponse, httpStatus);
    }

    public static ResponseEntity<CustomHttpResponse> failureSuccessResponse(HttpStatus httpStatus,
                                                           Integer errorCode, String errorMessage){
        CustomHttpResponse errorResponse = CustomHttpResponse
                .builder()
                .httpStatus(httpStatus)
                .errorBody(Map.of("errorCode", errorCode, "errorMessage", errorMessage))
                .build();
        return new ResponseEntity<>(errorResponse, httpStatus);
    }
}
