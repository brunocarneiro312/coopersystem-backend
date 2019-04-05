package br.com.coopersystem.backendcoopersystem.model;

import br.com.coopersystem.backendcoopersystem.enums.TipoTelefoneEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_TELEFONE")
public class Telefone {

    public Telefone(TipoTelefoneEnum tipoTelefoneEnum, String numero) {
        this.tipoTelefoneEnum = tipoTelefoneEnum;
        this.numero = numero;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_telefone")
    @SequenceGenerator(name = "sequence_telefone", sequenceName = "seq_telefone")
    @Column(name = "ID_TELEFONE")
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "TIPO_TELEFONE")
    private TipoTelefoneEnum tipoTelefoneEnum;

    @Column(name = "NUMERO", nullable = false)
    private String numero;

}
