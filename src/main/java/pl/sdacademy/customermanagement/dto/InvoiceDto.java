package pl.sdacademy.customermanagement.dto;

import lombok.Getter;
import lombok.Setter;
import pl.sdacademy.customermanagement.model.UserAddress;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "invoices")
@Getter
@Setter
public class InvoiceDto {

    @Id @GeneratedValue
    private long id;
    private String invoiceNo;
    private Date createDate;
    private Date datePaid;
    private UserAddress address;
}
