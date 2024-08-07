package com.excelr.service;

import java.util.HashSet;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;



import com.excelr.model.Role;
import com.excelr.model.User;
import com.excelr.repo.RoleRepository;
import com.excelr.repo.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));

        // Assign default role (e.g., ROLE_CUSTOMER)
        Role role = roleRepository.findByName("ROLE_CUSTOMER");
        user.setRoles(new HashSet<>(Set.of(role)));

        return userRepository.save(user);
    }

    public void assignRoleToUser(String email, String roleName) {
        User user = userRepository.findByEmail(email);
        Role role = roleRepository.findByName(roleName);

        if (user != null && role != null) {
            user.getRoles().add(role);
            userRepository.save(user);
        }
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}