package com.example.musicPlayer.controllers;

import com.example.musicPlayer.domain.User;
import com.example.musicPlayer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class AppController {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String hello() {
        User user = new User("Dimka", "Komik");
        userService.addUser(user);
        return "hello_world";
    }


    @GetMapping("/show")
    public ModelAndView showUsers() {
        Iterable<User> users = userService.getUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("show");
        modelAndView.addObject("userList", users);
        return modelAndView;
    }

    @GetMapping("/editParam")
    public ModelAndView editPage(@RequestParam("id") int id) {
        Optional<User> user = userService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("user", user.get());
        return modelAndView;
    }


    @PostMapping("/add")
    public ModelAndView add(@ModelAttribute("user") User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/show");
        userService.addUser(user);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editFilm(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/show");
        userService.edit(user);
        return modelAndView;
    }
}

