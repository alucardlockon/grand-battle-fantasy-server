package com.alucardlockon.grandbf.controller;

import com.alucardlockon.grandbf.model.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/register")
    public Account Register(){
        return new Account();
    }

}
