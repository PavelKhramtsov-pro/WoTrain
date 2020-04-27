package com.example.WoTrain.entity.table;

import lombok.Data;

import javax.persistence.*;

@Entity
//@Table(schema = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

}
