package pl.sdacademy.customermanagement.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceViewPdfDto {

    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String zipCode;
    private String company;
    private String idNumber;
    private String invoiceNo;
    private LocalDateTime invoiceDate;
    private LocalDate datePaid;
    private Long invoiceId;

    private List<InvoiceItemViewPdfDto> items;
    private BigDecimal total;


}
