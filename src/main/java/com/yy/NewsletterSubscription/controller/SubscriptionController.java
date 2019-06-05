package com.yy.NewsletterSubscription.controller;

import com.yy.NewsletterSubscription.model.User;
import com.yy.NewsletterSubscription.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SubscriptionController {

    @Autowired
    private UserRepository userRepository;

//    @GetMapping("/subscribe")
//    public String showUsers(Model model)
//    {
//        model.addAttribute("user", new User()); // New Book to add
//        model.addAttribute("users", userRepository.findAll());
//        return "subscribe";
//    }

    @GetMapping("/")
    public String showUsers(Model model)
    {
        model.addAttribute("user", new User()); // New Book to add
        model.addAttribute("users", userRepository.findAll());
        return "home";
    }

    @GetMapping("/subscribe")
    public String addEmail(@RequestParam("email") String email, @RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastname )
    {
        userRepository.save(new User(firstName, lastname, email));
        return "thankyou";
    }


//    @PostMapping("/subscribe")
//    public String postEmail(@ModelAttribute("user") User user)
//    {
//        userRepository.save(user);
//        return "thankyou";
//    }

    @GetMapping("/unsubscribe")
    public String removeEmail(@RequestParam("email") String email)
    {
        Iterable<User> iterable = userRepository.findAll();

        for(User user : iterable)
        {
            if(user.getEmail().equals(email))
            {
                userRepository.delete(user);
                return "removed";
            }
        }

        return "usernotfound";
    }
}
