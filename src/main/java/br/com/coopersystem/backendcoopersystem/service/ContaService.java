package br.com.coopersystem.backendcoopersystem.service;

import br.com.coopersystem.backendcoopersystem.model.Conta;

import java.util.List;

public interface ContaService {

    Conta criarConta(Conta conta);

    Conta removerConta(Conta conta);

    Conta removerContaPorId(Long idConta);

    Conta alterarConta(Conta conta);

    Conta buscarContaPorId(Long idConta);

    List<Conta> buscarContas();

}
