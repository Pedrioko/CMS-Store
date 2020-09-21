package com.pedrioko.github.cmsapi.repositories;

import com.pedrioko.github.cmsapi.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
