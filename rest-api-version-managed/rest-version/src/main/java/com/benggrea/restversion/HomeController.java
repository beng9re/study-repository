package com.benggrea.restversion;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${service.version}")
    private String version;

    @GetMapping("/home")
    public String echo() {
        return "hello " + version;

    }
}
