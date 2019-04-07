package br.com.coopersystem.backendcoopersystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMAIL")
public class Email {

    public Email(@javax.validation.constraints.Email String email) {
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_email")
    @SequenceGenerator(name = "sequence_email", sequenceName = "seq_email")
    @Column(name = "ID")
    private Long id;

    @javax.validation.constraints.Email
    @Column(name = "EMAIL")
    private String email;

}
