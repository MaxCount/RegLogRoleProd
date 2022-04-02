package com.example.fuck.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity // Указывает, что данный бин (класс) является сущностью.
@Table(name = "users") //  указывает на имя таблицы, которая будет отображаться в этой сущности.
public class User {

    @Id //id колонки
    @GeneratedValue(strategy = GenerationType.IDENTITY) //  указывает, что данное свойство будет создаваться согласно указанной стратегии.
    private Long id;

    @Column(nullable = false, unique = true, length = 45) //  указывает на имя колонки, которая отображается в свойство сущности.
    private String email;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @Column(name = "enabled")
    private boolean enabled = true;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn (name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public Long getUser_id() {
        return id;
    }

    public void setUser_id(Long user_id) {
        this.id = user_id;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

//    public Set<Role> getRoles( /*Long id*/ ) {
//        return roles;
//    }
//
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role){
        this.roles.add(role);
    }
}