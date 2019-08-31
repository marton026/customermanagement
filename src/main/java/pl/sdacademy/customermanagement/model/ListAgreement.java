package pl.sdacademy.customermanagement.model;

import javax.persistence.*;

@Entity
@Table(name = "listagremnts")
public class ListAgreement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Long agreementTime;
}
