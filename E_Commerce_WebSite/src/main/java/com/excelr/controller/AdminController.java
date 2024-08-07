package com.excelr.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.excelr.service.UserService;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @PostMapping("/admin/assign-role")
    public String assignRoleToUser(@RequestParam String email, @RequestParam String roleName) {
        userService.assignRoleToUser(email, roleName);
        return "redirect:/admin";
    }
}
