package com.example.myspringexample.controller;

import com.example.myspringexample.domain.User;
import com.example.myspringexample.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class HelloController {
    private static final Logger logger= LoggerFactory.getLogger(HelloController.class);
    private UserService userService;

    @Autowired
    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    ModelAndView myFirstView(ModelAndView modelAndView, @RequestParam(defaultValue = "Wiola :P") String name){
        logger.info("name: {}",name);

        modelAndView.addObject("user",name);
        modelAndView.setViewName("home");
        return modelAndView;
    }
    @GetMapping("/tree")
    ModelAndView myFirstView2(ModelAndView modelAndView, @RequestParam(defaultValue = "Wiola") String name,@RequestParam(defaultValue = "Cegiełka") String surname,@RequestParam(defaultValue = "12") int age){
        logger.info("name: {}",name);

        modelAndView.addObject("name",name);
        modelAndView.addObject("surname",surname);
        modelAndView.addObject("age",age);
        modelAndView.setViewName("nowa");
        return modelAndView;
    }
    @GetMapping("/users")
    ModelAndView readAllUsers(ModelAndView modelAndView){
        List<User> users=userService.getAllUsers();
        logger.info("users: [{}]",users);
        modelAndView.addObject("allUsers",users);
        modelAndView.addObject("new-attribute","empty");
        modelAndView.setViewName("hello/users");
        return modelAndView;
    }
}
