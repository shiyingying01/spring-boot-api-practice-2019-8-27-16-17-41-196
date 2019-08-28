package com.tw.apistackbase.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jxzhong on 18/08/2017.
 */
@RestController
@RequestMapping("/hello")
public class HelloResource {

    @GetMapping(path = "/{userName}")
    public ResponseEntity<String> getAll(@PathVariable String userName) {

        return ResponseEntity.ok("Hello:" + userName);
    }


}
