package com.pedrioko.github.cmsapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public @Data
class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Lob
    private String street;
    @Lob
    private String city;
    @Lob
    private String codepostal;
    @Lob
    private String code_country;
    @Lob
    private String country;
    @Lob
    private String cellphone;

    private boolean bydefault;
    @Lob
    private String region;

}
