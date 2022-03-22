package com.example.fuck.models;

import javax.persistence.*;

@Entity
@Table( name = "users_roles")
public class TableRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "users")
    @TableGenerator(name = "users", allocationSize = 1, table = "users", pkColumnName = "id")
    Long user_id ;

    @Column(name = "role_id")
    int role_id = 1;

}
