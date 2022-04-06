package com.example.fuck.controllers;

import com.example.fuck.models.Role;
import com.example.fuck.models.User;
import com.example.fuck.repos.UserRepository;
import com.example.fuck.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller // назначать шаблон данному классу, показывая его роль. Это значит, что диспетчер будет сканировать
// Controller-классы на предмет реализованных методов, проверяя @RequestMapping аннотации.
public class AppController {

    @Autowired // отмечает конструктор, поле или метод как требующий автозаполнения инъекцией зависимости Spring
    private UserRepository userRepo;

    @Autowired
    private UserService service;

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
        service.saveUserWithDefaultRole(user);

        return "register_success";
    }
    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }
    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model){
        User user = service.get(id);
        List<Role> listRoles = service.getRoles();
        model.addAttribute("user",user);
        model.addAttribute("listRoles", listRoles);
        return "user_form";
    }
    @PostMapping("/users/save")
    public String saveUser(User user){
        service.save(user);
        return"redirect:/users";
    }
    @RequestMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id){
        service.delete(id);
        return "redirect:/";
    }
}