package pl.sdacademy.customermanagement.dto;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;



@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class InvoiceDto {


    private Long id;
    private String invoiceNo;
    private LocalDate createDate;
    private LocalDate datePaid;

}
