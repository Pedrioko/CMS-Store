package com.pedrioko.github.cmsapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public @Data
class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstname;

    private String lastname;

    @OneToMany
    private List<Address> addresses = new ArrayList<>();

    @OneToOne
    private  User user;

}
