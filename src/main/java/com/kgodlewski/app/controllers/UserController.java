package com.kgodlewski.app.controllers;

import com.kgodlewski.app.entities.User;
import com.kgodlewski.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/showReg")
    public String showRegistrationPage(){
        return "login/registerUser";
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user){
        System.out.println(user);
        userRepository.save(user);
        return "login/login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelMap){
        System.out.println(email);
        Optional<User> optional = userRepository.findByEmail(email);
        if(optional.isPresent()){
            User user = optional.get();
            if(user.getPassword().equals(password)){
                return "findFlights";
            }
            else {
                modelMap.addAttribute("msg","Invalid password. Please try again");
            }
        }
        else {
            modelMap.addAttribute("msg","Cannot find email. Please try again");
        }
        return "login/login";
    }

}
