package pl.sdacademy.customermanagement.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "invoices")
@Getter
@Setter
public class Invoice {

    @Id @GeneratedValue
    private long id;
    private String invoiceNo;
    private Date createDate;
    private Date datePaid;
    private UserAddress address;
}
