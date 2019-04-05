package br.com.coopersystem.backendcoopersystem.bootstrap;

import br.com.coopersystem.backendcoopersystem.enums.TipoTelefoneEnum;
import br.com.coopersystem.backendcoopersystem.model.*;
import br.com.coopersystem.backendcoopersystem.repository.ClienteRepository;
import br.com.coopersystem.backendcoopersystem.repository.ContaRepository;
import br.com.coopersystem.backendcoopersystem.service.ClienteService;
import br.com.coopersystem.backendcoopersystem.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Para efetuar os testes de integração com a base de dados, optei por utilizar o H2.
 * Essa classe irá realizar uma carga inicial de dados.
 */
@Component
public class H2Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ContaService contaService;

    private ClienteService clienteService;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public H2Bootstrap(ContaService contaService, ClienteService clienteService, PasswordEncoder passwordEncoder) {
        this.contaService = contaService;
        this.clienteService = clienteService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        System.out.println("\nIniciando carga de dados no banco de dados H2...");

        // Cadastrando cliente...
        Cliente cliente = new Cliente();
        cliente.setNome("Bruno de Souza Ferreira Carneiro");
        cliente.setCpf("00825346169");
        cliente.setEndereco(gerarEndereco());
        cliente.setEmails(gerarEmails());
        cliente.setTelefones(gerarTelefones());
        this.clienteService.salvarCliente(cliente);

        // Cadastrando roles e contas
        Role roleAdmin = new Role("ADMIN");
        Role roleUser = new Role("USER");
        Conta contaAdmin = new Conta();
        contaAdmin.setUsuario("admin");
        contaAdmin.setSenha(passwordEncoder.encode("123456"));
        contaAdmin.setAtiva(true);
        contaAdmin.setRoles(Arrays.asList(roleAdmin));
        this.contaService.criarConta(contaAdmin);

        System.out.println("Carga de dados efetuada com sucesso!");
        System.out.println("Finalizando carga de dados...\n");

    }

    private Endereco gerarEndereco() {
        return new Endereco(
                "70765110",
                "sqn312 bl k",
                "asa norte",
                "brasília",
                "DF");
    }

    private List<Telefone> gerarTelefones() {

        List<Telefone> telefones = new ArrayList<>();

        telefones.addAll(
                Arrays.asList(
                        new Telefone(TipoTelefoneEnum.COMERCIAL, "6120022020"),
                        new Telefone(TipoTelefoneEnum.RESIDENCIAL, "6133471304"),
                        new Telefone(TipoTelefoneEnum.CELULAR, "61985770401")));

        return telefones;
    }

    private List<Email> gerarEmails() {

        List<Email> emails = new ArrayList<>();

        emails.addAll(
                Arrays.asList(
                        new Email("sql2@hotmail.com"),
                        new Email("bruno.carneiro312@gmail.com")));

        return emails;
    }
}
