package br.com.coopersystem.backendcoopersystem.service.impl;

import br.com.coopersystem.backendcoopersystem.model.Cliente;
import br.com.coopersystem.backendcoopersystem.repository.ClienteRepository;
import br.com.coopersystem.backendcoopersystem.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl /*implements ClienteService*/ {

    /*private ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente salvarCliente(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    @Override
    public Cliente removerCliente(Cliente cliente) {
        this.clienteRepository.delete(cliente);
        return cliente;
    }

    @Override
    public Cliente removerClientePorId(Long idCliente) {
        Cliente cliente = this.clienteRepository.findById(idCliente).get();
        this.clienteRepository.delete(cliente);
        return cliente;
    }

    @Override
    public Cliente alterarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente buscarClientePorId(Long idCliente) {
        return clienteRepository.findById(idCliente).get();
    }

    @Override
    public List<Cliente> buscarClientes() {
        return clienteRepository.findAll();
    }*/
}
