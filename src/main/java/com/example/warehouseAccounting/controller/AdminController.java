package com.example.warehouseAccounting.controller;

import com.example.warehouseAccounting.domain.Role;
import com.example.warehouseAccounting.domain.User;
import com.example.warehouseAccounting.repos.RoleRepo;
import com.example.warehouseAccounting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepo roleRepo;

    @GetMapping("/user")
    public String userList(Model model)
    {
        model.addAttribute("users", userService.allUsers());
        return "user";
    }

    @GetMapping("user/{user}")
    public String editUser(@PathVariable User user, Model model)
    {
        HashSet<String> roles = new HashSet<>();

        for(Role role : roleRepo.findAll())
        {
            roles.add(role.getName());
        }

        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "userEdit";
    }

    @PostMapping("/user")
    public String userSave(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam("userId") Long userId,
            @RequestParam Map<String, String> form,
            RedirectAttributes redirectAttributes)
    {

        User user = userService.findUserById(userId);

        if (user == null){

        }

        if (password.trim().length() == 0)
        {
            redirectAttributes.addFlashAttribute("errorMessage", "Введите пароль");
            return "redirect:/admin/user/" + Long.toString(userId);
        }

        if (username.trim().length() == 0)
        {
            redirectAttributes.addFlashAttribute("errorMessage", "Введите имя пользователя");
            return "redirect:/admin/user/" + Long.toString(userId);
        }

        List<Role> rolesFromDb = roleRepo.findAll();
        Set<Role> rolesFromUser = new HashSet<>();

        for(Role role : rolesFromDb)
        {
            System.out.println(role.getName() + " " + form.get(role.getName()));
            if (form.get(role.getName()) != null && form.get(role.getName()).equals("on"))
            {
                rolesFromUser.add(role);
            }
        }

        userService.editUser(user, username, password, rolesFromUser);

        return "redirect:/admin/user";
    }


}
