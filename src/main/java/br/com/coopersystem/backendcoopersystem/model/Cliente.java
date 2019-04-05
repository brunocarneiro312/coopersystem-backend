package br.com.coopersystem.backendcoopersystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_cliente")
    @SequenceGenerator(name = "sequence_cliente", sequenceName = "seq_cliente")
    @Column(name = "ID_CLIENTE")
    private Long id;

    @Column(name = "NOME", length = 100, nullable = false)
    private String nome;

    @Column(name = "CPF", length = 11, unique = true, nullable = false)
    private String cpf;


}
