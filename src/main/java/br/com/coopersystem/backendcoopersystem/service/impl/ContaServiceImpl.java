package br.com.coopersystem.backendcoopersystem.service.impl;

import br.com.coopersystem.backendcoopersystem.model.Conta;
import br.com.coopersystem.backendcoopersystem.repository.ContaRepository;
import br.com.coopersystem.backendcoopersystem.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaServiceImpl /*implements ContaService*/ {

    /*private ContaRepository contaRepository;

    @Autowired
    public ContaServiceImpl(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Override
    public Conta criarConta(Conta conta) {
        return this.contaRepository.save(conta);
    }

    @Override
    public Conta removerConta(Conta conta) {
        this.contaRepository.delete(conta);
        return conta;
    }

    @Override
    public Conta removerContaPorId(Long idConta) {
        Conta conta = this.contaRepository.findById(idConta).get();
        this.contaRepository.delete(conta);
        return conta;
    }

    @Override
    public Conta alterarConta(Conta conta) {
        return this.contaRepository.saveAndFlush(conta);
    }

    @Override
    public Conta buscarContaPorId(Long idConta) {
        return this.contaRepository.findById(idConta).get();
    }

    @Override
    public List<Conta> buscarContas() {
        return this.contaRepository.findAll();
    }*/
}
