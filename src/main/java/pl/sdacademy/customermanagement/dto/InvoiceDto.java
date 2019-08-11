package pl.sdacademy.customermanagement.dto;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    private Date createDate;
    private Date datePaid;

}
