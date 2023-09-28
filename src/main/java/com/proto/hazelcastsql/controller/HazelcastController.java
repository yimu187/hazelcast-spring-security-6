package com.proto.hazelcastsql.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cache")
public class HazelcastController {

    @GetMapping(value = "/")
    public String getCityName(){
        return "Hazelcast Cache Controller";
    }
}
