package pl.sdacademy.customermanagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "listagremnts")
public class ListAgreement {
    @Id
    private String name;
    private long agreementTime;
}
