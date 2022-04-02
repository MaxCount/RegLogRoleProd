package com.example.fuck.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    private String name;

    public Role(){

    }
    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Role( String name) {
        this.name = name;
    }
    public Role(Long id) {
        this.id = id;

    }


//    @ManyToMany(mappedBy = "roles")
//   private Set<User> users = new HashSet<>();
//
//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}