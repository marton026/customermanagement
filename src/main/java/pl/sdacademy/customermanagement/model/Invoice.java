package pl.sdacademy.customermanagement.model;

import lombok.*;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;
import pl.sdacademy.customermanagement.dto.InvoiceDto;


import javax.persistence.*;
import java.time.LocalDate;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter

@Entity

@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String invoiceNo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate invoiceDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datePaid;

    /*public static Invoice fromDto(InvoiceDto dto) {
        return Invoice.builder()
                .id(dto.getId())
                .invoiceNo(dto.getInvoiceNo())
                .invoiceDate(dto.getInvoiceDate())
                .datePaid(dto.getDatePaid())
                .build();
    }*/

    public InvoiceDto toDto() {
        return InvoiceDto.builder()
                .id(id)
                .invoiceNo(invoiceNo)
                .invoiceDate(invoiceDate)
                .datePaid(datePaid)
                .build();
    }
}
