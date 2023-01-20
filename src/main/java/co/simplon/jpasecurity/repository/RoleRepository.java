package co.simplon.jpasecurity.repository;

import co.simplon.jpasecurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}