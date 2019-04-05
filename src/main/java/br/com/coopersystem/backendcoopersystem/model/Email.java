package br.com.coopersystem.backendcoopersystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_EMAIL")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_email")
    @SequenceGenerator(name = "sequence_email", sequenceName = "seq_email")
    @Column(name = "ID_EMAIL")
    private Long id;

    @javax.validation.constraints.Email
    @Column(name = "EMAIL")
    private String email;

}
