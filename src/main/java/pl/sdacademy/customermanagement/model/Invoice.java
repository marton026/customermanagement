package pl.sdacademy.customermanagement.model;

import lombok.*;
import pl.sdacademy.customermanagement.dto.InvoiceDto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "invoices")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String invoiceNo;
    private Date createDate;
    private Date datePaid;

    public InvoiceDto toDto() {
        return InvoiceDto.builder()
                .id(id)
                .invoiceNo(invoiceNo)
                .createDate(createDate)
                .datePaid(datePaid)
                .build();
    }
}
