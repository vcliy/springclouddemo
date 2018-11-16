package com.cloud.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@RefreshScope
public class DemoController {

    @Value("${demo.param1}")
    private String param1;

    @Autowired
    private Environment environment;

    @RequestMapping(value = "/param1", method = RequestMethod.GET)
    public String getParam1() {
        return param1;
    }
    @RequestMapping(value = "/param2", method = RequestMethod.GET)
    public String getParam2() {
        return environment.getProperty("demo.param1","未定义");
    }
}
