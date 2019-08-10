package pl.sdacademy.customermanagement.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "agreements")
@Getter
@Setter
public class Agreement {

    @Id @GeneratedValue
    private long id;
    private Date createAgrement;
    private Date endAgreement;
    private ListAgreement listAgreement;

}
