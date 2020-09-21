package com.pedrioko.github.cmsapi.repositories;

import com.pedrioko.github.cmsapi.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
