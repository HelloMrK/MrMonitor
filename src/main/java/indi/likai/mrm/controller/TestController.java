package indi.likai.mrm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/getTestInfo")
    public String getTestInfo(){
        return "Hello World !";
    }


}
