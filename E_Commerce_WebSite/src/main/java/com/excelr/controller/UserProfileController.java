package com.excelr.controller;

import com.excelr.model.User;
import com.excelr.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/{id}")
    public User getUserProfile(@PathVariable Long id) {
        return userProfileService.getUserById(id);
    }

    @PutMapping
    public User updateUserProfile(@RequestBody User user) {
        return userProfileService.updateUserProfile(user);
    }
}
