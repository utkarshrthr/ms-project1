package com.utkarshrthr.app.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public final class ApiResponse {

    public static ResponseEntity<Object> getResponse(HttpStatus status, Object response) {
        Map<String, Object> map = new HashMap<>();
        if(response != null)
            map.put("data", response);
        return get(status, map);
    }

    public static ResponseEntity<Object> getError(HttpStatus status, Object response) {
        Map<String, Object> map = new HashMap<>();
        if(response != null)
            map.put("error", response);
        map.put("message", status.getReasonPhrase());
        return get(status, map);
    }

    private static ResponseEntity<Object> get(HttpStatus status, Map map) {
        map.put("timestamp", new Timestamp(System.currentTimeMillis()));
        map.put("status", status.value());
        return ResponseEntity
                .status(status.value())
                .body(map);
    }

    private ApiResponse(){}
}