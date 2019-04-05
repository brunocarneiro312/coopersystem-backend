package br.com.coopersystem.backendcoopersystem.model;

import br.com.coopersystem.backendcoopersystem.enums.TipoTelefoneEnum;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_TELEFONE")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_telefone")
    @SequenceGenerator(name = "sequence_telefone", sequenceName = "seq_telefone")
    @Column(name = "ID_TELEFONE")
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private TipoTelefoneEnum tipoTelefoneEnum;

}
