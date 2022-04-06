package com.example.fuck.services;

import com.example.fuck.models.Role;
import com.example.fuck.models.User;
import com.example.fuck.repos.RoleRepository;
import com.example.fuck.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired // отмечает конструктор, поле или метод как требующий автозаполнения инъекцией зависимости Spring
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    public void saveUserWithDefaultRole(User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        Role roleUser = roleRepo.findByName("User");
        user.addRole(roleUser);

        userRepo.save(user);
    }
    public void save(User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);
    }
    public List<User> listAll(){
        return userRepo.findAll();
    }
    public User get(Long id){
        return userRepo.findById( id).get();
    }
    public List<Role> getRoles(){
        return roleRepo.findAll();
    }
    public void delete(Long id) {
        String sql = " DELETE FROM USERS WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}