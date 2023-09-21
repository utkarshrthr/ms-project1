package com.utkarshrthr.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/hey")
public class App {

    @GetMapping
    public String get(){
        return "Hello";
    }
}
