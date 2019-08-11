package pl.sdacademy.customermanagement.model;

import lombok.*;
import pl.sdacademy.customermanagement.dto.InvoiceDto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "invoices")
public class Invoice {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String invoiceNo;
    private LocalDateTime createDate;
    private LocalDateTime datePaid;

    public InvoiceDto toDto() {
        return InvoiceDto.builder()
                .id(id)
                .invoiceNo(invoiceNo)
                .createDate(createDate)
                .datePaid(datePaid)
                .build();
    }
}
