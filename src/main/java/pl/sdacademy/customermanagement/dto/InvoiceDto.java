package pl.sdacademy.customermanagement.dto;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;
import pl.sdacademy.customermanagement.model.InvoiceItem;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDto {

    private Long id;
    private String invoiceNo;
    //@Temporal(TemporalType.TIMESTAMP)
   @CreatedDate
    private LocalDateTime invoiceDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datePaid;
    private List<InvoiceItem> items;
}
