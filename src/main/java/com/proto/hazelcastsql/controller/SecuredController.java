package com.proto.hazelcastsql.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/secured")
public class SecuredController {

    @GetMapping(value = "/")
    public String getSecuredInfo(){
        return "Secured Info";
    }
}
