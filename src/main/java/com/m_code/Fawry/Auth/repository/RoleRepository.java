package com.m_code.Fawry.Auth.repository;

import java.util.Optional;

import com.m_code.Fawry.Auth.models.ERole;
import com.m_code.Fawry.Auth.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
