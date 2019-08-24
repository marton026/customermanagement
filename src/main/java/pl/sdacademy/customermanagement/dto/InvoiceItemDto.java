package pl.sdacademy.customermanagement.dto;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class InvoiceItemDto {

    private Long id;
    private String contents;
    private BigDecimal price;
    private Long invoiceId;

    public InvoiceItemDto(Long invoiceId) {
        this.invoiceId = invoiceId;
    }
}
