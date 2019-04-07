package br.com.coopersystem.backendcoopersystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
//@Entity
//@Table(name = "TB_CONTA")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_conta")
    @SequenceGenerator(name = "sequence_conta", sequenceName = "seq_conta")
    @Column(name = "ID_CONTA")
    private Long id;

    @Column(name = "USUARIO", unique = true, nullable = false)
    private String usuario;

    @Column(name = "SENHA", nullable = false)
    private String senha;

    @Column(name = "ATIVA", nullable = false)
    private boolean ativa;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TB_CONTA_ROLE",
            joinColumns = @JoinColumn(name = "ID_CONTA"),
            inverseJoinColumns = @JoinColumn(name = "ID_ROLE"))
    private List<Role> roles = new ArrayList<>();

}
