package br.com.coopersystem.backendcoopersystem.repository;

import br.com.coopersystem.backendcoopersystem.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {

    String usersByUsersnameQuery = "select conta.usuario, conta.senha, conta.ativa" +
            " from tb_conta conta where conta.usuario = ?";

    String authoritiesByUsernameQuery = "select conta.usuario, role.role_name" +
            "  from tb_conta      conta," +
            "       tb_role       role," +
            "       tb_conta_role conta_role" +
            "  where conta.id_conta = conta_role.id_conta" +
            "    and role.id_role   = conta_role.id_role" +
            "    and conta.usuario  = ?";

}
