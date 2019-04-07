package br.com.coopersystem.backendcoopersystem.security.repository;

import br.com.coopersystem.backendcoopersystem.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório do User
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}