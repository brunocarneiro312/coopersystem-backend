package br.com.coopersystem.backendcoopersystem.repository;

import br.com.coopersystem.backendcoopersystem.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
