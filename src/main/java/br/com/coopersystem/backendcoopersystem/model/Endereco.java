package br.com.coopersystem.backendcoopersystem.model;

import br.com.coopersystem.backendcoopersystem.model.security.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
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
    @SequenceGenerator(name = "sequence_endereco", sequenceName = "seq_enderco")
    @Column(name = "ID")
    private Long id;

    @Column(name = "CEP", nullable = false)
    private String cep;

    @Column(name = "LOGRADOURO", nullable = false)
    private String logradouro;

    @Column(name = "BAIRRO", nullable = false)
    private String bairro;

    @Column(name = "CIDADE", nullable = false)
    private String cidade;

    @Column(name = "UF", nullable = false)
    private String uf;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @JsonIgnore
    @OneToOne(mappedBy = "endereco")
    private User user;

}
