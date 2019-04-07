package br.com.coopersystem.backendcoopersystem.repository;

import br.com.coopersystem.backendcoopersystem.model.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório de Telefone
 */
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

}
