package br.com.coopersystem.backendcoopersystem.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Para efetuar os testes de integração com a base de dados, optei por utilizar o H2.
 * Essa classe irá realizar uma carga inicial de dados.
 */
@Component
public class H2Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        System.out.println("\nIniciando carga de dados no banco de dados H2...\n");
    }
}
