package br.com.coopersystem.backendcoopersystem.repository;

import br.com.coopersystem.backendcoopersystem.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório de Email
 */
public interface EmailRepository extends JpaRepository<Email, Long> {

}
