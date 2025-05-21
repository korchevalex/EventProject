package com.events.EventsProject.repository;

import com.events.EventsProject.model.entity.Role;
import com.events.EventsProject.model.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(UserRoleEnum role);
}
