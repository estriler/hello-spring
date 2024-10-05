package org.launchcode.hello_spring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class HelloController {

    //Handles request at /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    //Handles request at /goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //Handles request of the form /hello?name=LaunchCode
//  @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
//    @ResponseBody
//    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language){
//        if (Objects.equals(name, "")){
//            name = "World";
//        }
//        return createMessage(name, language);
//    }
    

    public static String createMessage(String n, String l){
        String greeting = "";

        if(l.equals("english")){
            greeting = "Hello";
        }
        else if (l.equals("french")){
            greeting = "Bonjour";
        }
        else if(l.equals("italian")){
            greeting = "Bonjourno";
        }
        else if(l.equals("spanish")){
            greeting = "Hola";
        } else if (l.equals("german")) {
            greeting = "Hallo";
        }
        return greeting + " " + n;
    }

    //Handles requests of the form /hello/LaunchCode
//    @GetMapping("hello/{name}")
//    @ResponseBody
//    public String helloWithPathParam(@PathVariable String name){
//        return "Hello, " + name + "!";
//    }

    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    // Responds to /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String hello(@RequestParam String name, Model model){
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names",names);
        return "hello-list";
    }

}
