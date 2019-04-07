package br.com.coopersystem.backendcoopersystem.model;

import br.com.coopersystem.backendcoopersystem.model.security.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entidade Endereco
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ENDERECO")
public class Endereco {

    public Endereco(String cep, String logradouro, String bairro, String cidade, String uf, String complemento) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.complemento = complemento;
    }

    public Endereco(String cep, String logradouro, String bairro, String cidade, String uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_endereco")
    @SequenceGenerator(name = "sequence_endereco", sequenceName = "seq_enderco", allocationSize = 1, initialValue = 3)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CEP", nullable = false)
    @NotNull // Campo obrigatório, conforme a regra especifica
    private String cep;

    @Column(name = "LOGRADOURO", nullable = false)
    @NotNull // Campo obrigatório, conforme a regra especifica
    private String logradouro;

    @Column(name = "BAIRRO", nullable = false)
    @NotNull // Campo obrigatório, conforme a regra especifica
    private String bairro;

    @Column(name = "CIDADE", nullable = false)
    @NotNull // Campo obrigatório, conforme a regra especifica
    private String cidade;

    @Column(name = "UF", nullable = false)
    @NotNull // Campo obrigatório, conforme a regra especifica
    private String uf;

    @Column(name = "COMPLEMENTO") // Complemento pode ser nulo, conforme regra.
    private String complemento;

    @JsonIgnore
    @OneToOne(mappedBy = "endereco")
    private User user;

}
