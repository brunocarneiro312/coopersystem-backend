package br.com.coopersystem.backendcoopersystem.model;

import lombok.*;

import javax.persistence.*;

/**
 * Entidade Email
 */
@Getter
@Setter
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
    @SequenceGenerator(name = "sequence_email", sequenceName = "seq_email", allocationSize = 1, initialValue = 5)
    @Column(name = "ID")
    private Long id;

    @javax.validation.constraints.Email
    @Column(name = "EMAIL")
    private String email;

}
