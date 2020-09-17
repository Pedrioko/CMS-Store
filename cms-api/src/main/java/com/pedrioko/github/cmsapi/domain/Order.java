package com.pedrioko.github.cmsapi.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public @Data
class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Client client;

    private OrderStatus status;

    private String transaction_id;

    private String uuid;

    @ManyToOne
    private Address addressShipping;

    @ManyToOne
    private Address addressInvoice;

    @OneToMany
    private List<DetailOrder> detailOrderList;

}
