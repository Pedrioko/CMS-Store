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
@Table(name = "ordering")
public @Data
class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Client client;

    private OrderStatus status_order;

    @Lob
    private String transaction_id;

    @Lob
    private String uuid_order;

    @ManyToOne
    private Address addressShipping;

    @ManyToOne
    private Address addressInvoice;

    @OneToMany
    private List<DetailOrder> detailOrderList;

}
