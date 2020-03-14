package com.example.warehouseAccounting.controller;
import com.example.warehouseAccounting.domain.User;
import com.example.warehouseAccounting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.validation.Valid;
import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model)
    {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@RequestParam String username,
                          @RequestParam String password,
                          Model model)
    {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        System.out.println("ПАРОЛЬ " + user.getUsername() + " ПАРОЛЬ " + user.getPassword());

        if (!userService.saveUser(user)) {
            model.addAttribute("message", "пользователь с таким именем уже существует");
            return "registration";
        }

        return "redirect:/";

    }



}
