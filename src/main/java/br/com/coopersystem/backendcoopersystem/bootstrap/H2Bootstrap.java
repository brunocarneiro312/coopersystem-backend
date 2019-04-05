package br.com.coopersystem.backendcoopersystem.bootstrap;

import br.com.coopersystem.backendcoopersystem.enums.TipoTelefoneEnum;
import br.com.coopersystem.backendcoopersystem.model.Cliente;
import br.com.coopersystem.backendcoopersystem.model.Email;
import br.com.coopersystem.backendcoopersystem.model.Endereco;
import br.com.coopersystem.backendcoopersystem.model.Telefone;
import br.com.coopersystem.backendcoopersystem.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
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

    private ClienteRepository clienteRepository;

    @Autowired
    public H2Bootstrap(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        System.out.println("\nIniciando carga de dados no banco de dados H2...");

        Cliente cliente = new Cliente();
        cliente.setNome("Bruno de Souza Ferreira Carneiro");
        cliente.setCpf("00825346169");
        cliente.setEndereco(gerarEndereco());
        cliente.setEmails(gerarEmails());
        cliente.setTelefones(gerarTelefones());

        this.clienteRepository.save(cliente);

        System.out.println("Carga de dados efetuada com sucesso!");
        System.out.println("Finalizando carga de dados...\n");
    }

    private Endereco gerarEndereco() {
        return new Endereco(
                "70765110",
                "sqn312 bl k",
                "asa norte",
                "brasília",
                "DF",
                "102");
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
