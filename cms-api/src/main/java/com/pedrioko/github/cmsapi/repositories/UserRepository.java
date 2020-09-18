package com.pedrioko.github.cmsapi.repositories;

import com.pedrioko.github.cmsapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
