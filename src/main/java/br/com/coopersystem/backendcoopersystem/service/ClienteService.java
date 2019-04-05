package br.com.coopersystem.backendcoopersystem.service;

import br.com.coopersystem.backendcoopersystem.model.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente salvarCliente(Cliente cliente);

    Cliente removerCliente(Cliente cliente);

    Cliente removerClientePorId(Long idCliente);

    Cliente alterarCliente(Cliente cliente);

    Cliente buscarClientePorId(Long idCliente);

    List<Cliente> buscarClientes();

}
