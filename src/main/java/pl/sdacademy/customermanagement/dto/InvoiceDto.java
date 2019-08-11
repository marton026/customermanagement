package pl.sdacademy.customermanagement.dto;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class InvoiceDto {

    @Id @GeneratedValue
    private Long id;
    private String invoiceNo;
    private LocalDateTime createDate;
    private LocalDateTime datePaid;

}
