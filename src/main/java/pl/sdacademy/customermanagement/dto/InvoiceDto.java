package pl.sdacademy.customermanagement.dto;

import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
import java.util.Date;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDto {
    private Long id;
    private String invoiceNo;
    //@Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate invoiceDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datePaid;

}
