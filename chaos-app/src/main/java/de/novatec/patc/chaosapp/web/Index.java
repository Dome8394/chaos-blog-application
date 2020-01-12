package de.novatec.patc.chaosapp.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {

    @RequestMapping(value = "/")
    public String index() {
        return "Hello World!";
    }
}
