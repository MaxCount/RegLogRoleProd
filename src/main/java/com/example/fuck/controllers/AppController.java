package com.example.fuck.controllers;


import com.example.fuck.models.Product;
import com.example.fuck.models.User;
import com.example.fuck.repos.ProductRepository;
import com.example.fuck.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller // назначать шаблон данному классу, показывая его роль. Это значит, что диспетчер будет сканировать
// Controller-классы на предмет реализованных методов, проверяя @RequestMapping аннотации.
public class AppController {

    @Autowired // отмечает конструктор, поле или метод как требующий автозаполнения инъекцией зависимости Spring
    private UserRepository userRepo;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        return "register_success";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }



}