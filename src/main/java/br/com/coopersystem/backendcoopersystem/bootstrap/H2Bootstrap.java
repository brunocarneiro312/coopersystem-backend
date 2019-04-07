package br.com.coopersystem.backendcoopersystem.bootstrap;

import org.springframework.stereotype.Component;

/**
 * Para efetuar os testes de integração com a base de dados, optei por utilizar o H2.
 * Essa classe irá realizar uma carga inicial de dados.
 */
@Component
public class H2Bootstrap /*implements ApplicationListener<ContextRefreshedEvent>*/ {

    //    private ContaService contaService;
//
//    private ClienteService clienteService;
//
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public H2Bootstrap(ContaService contaService, ClienteService clienteService, PasswordEncoder passwordEncoder) {
//        this.contaService = contaService;
//        this.clienteService = clienteService;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//
//        System.out.println("\nIniciando carga de dados no banco de dados H2...");
//
//        // Cadastrando cliente...
//        Cliente cliente = new Cliente();
//        cliente.setNome("Bruno de Souza Ferreira Carneiro");
//        cliente.setCpf("00825346169");
//        cliente.setEndereco(gerarEndereco());
//        cliente.setEmails(gerarEmails());
//        cliente.setTelefones(gerarTelefones());
//        this.clienteService.salvarCliente(cliente);
//
//        // Cadastrando roles e contas
//        Role roleAdmin = new Role("ROLE_ADMIN");
//        Role roleUser = new Role("ROLE_COMUM");
//
//        // conta admin
//        Conta contaAdmin = new Conta();
//        contaAdmin.setUsuario("admin");
//        contaAdmin.setSenha(passwordEncoder.encode("123456"));
//        contaAdmin.setAtiva(true);
//        contaAdmin.setRoles(Arrays.asList(roleAdmin));
//
//        // conta comum
//        Conta contaComum = new Conta();
//        contaComum.setUsuario("comum");
//        contaComum.setSenha(passwordEncoder.encode("123456"));
//        contaComum.setAtiva(true);
//        contaComum.setRoles(Arrays.asList(roleUser));
//
//        this.contaService.criarConta(contaAdmin);
//        this.contaService.criarConta(contaComum);
//
//        System.out.println("Carga de dados efetuada com sucesso!");
//        System.out.println("Finalizando carga de dados...\n");
//
//    }
//
//    private Endereco gerarEndereco() {
//        return new Endereco(
//                "70765110",
//                "sqn312 bl k",
//                "asa norte",
//                "brasília",
//                "DF");
//    }
//
//    private List<Telefone> gerarTelefones() {
//
//        List<Telefone> telefones = new ArrayList<>();
//
//        telefones.addAll(
//                Arrays.asList(
//                        new Telefone(TipoTelefoneEnum.COMERCIAL, "6120022020"),
//                        new Telefone(TipoTelefoneEnum.RESIDENCIAL, "6133471304"),
//                        new Telefone(TipoTelefoneEnum.CELULAR, "61985770401")));
//
//        return telefones;
//    }
//
//    private List<Email> gerarEmails() {
//
//        List<Email> emails = new ArrayList<>();
//
//        emails.addAll(
//                Arrays.asList(
//                        new Email("sql2@hotmail.com"),
//                        new Email("bruno.carneiro312@gmail.com")));
//
//        return emails;
//    }
}
