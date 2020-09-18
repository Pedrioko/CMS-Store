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
class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String preview;

    private long quantity;

    private double cost;

    private double saleprice;

    @ManyToMany
    private List<Category> categoryList = new ArrayList<>();

    @ManyToMany
    private List<Tag> tagList = new ArrayList<>();


}
