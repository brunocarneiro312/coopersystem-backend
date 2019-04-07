package br.com.coopersystem.backendcoopersystem.model.security;

import br.com.coopersystem.backendcoopersystem.model.Email;
import br.com.coopersystem.backendcoopersystem.model.Endereco;
import br.com.coopersystem.backendcoopersystem.model.Telefone;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    private Long id;

    @Column(name = "USERNAME", length = 50, unique = true)
    @NotNull
    @Size(min = 4, max = 50)
    private String username;

    @Column(name = "PASSWORD", length = 100)
    @NotNull
    @Size(min = 4, max = 100)
    private String password;

    @Column(name = "NOME", length = 100, nullable = false)
    @NotNull
    @Size(min = 3, max = 100)
    private String nome;

    @Column(name = "CPF", length = 11, unique = true, nullable = false)
    private String cpf;

    @Column(name = "ATIVO")
    @NotNull
    private Boolean ativo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "USER_AUTHORITY",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID")})
    private List<Authority> authorities;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "USER_ENDERECO",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "EMAIL_ID", referencedColumnName = "ID")})
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "USER_TELEFONE",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "TELEFONE_ID", referencedColumnName = "ID")})
    private List<Telefone> telefones;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "USER_EMAIL",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "EMAIL_ID", referencedColumnName = "ID")})
    private List<Email> emails;

}
