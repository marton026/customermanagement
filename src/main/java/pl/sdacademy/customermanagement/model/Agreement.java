package pl.sdacademy.customermanagement.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "agreements")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Agreement {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Date createAgrement;
    private Date endAgreement;
    @OneToMany
    private Set<ListAgreement> listAgreement;


}
