package com.demo.security.repository;

import com.demo.security.entity.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityJpaRepository extends JpaRepository<AuthorityEntity, Integer> {
}
