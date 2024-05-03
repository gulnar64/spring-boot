package aze.coders.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api")
public class HelloJSPController {

    @GetMapping("/jsp/hello")
    public String helloJSP() {
        return "hello";
    }
}
