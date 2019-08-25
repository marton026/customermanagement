package pl.sdacademy.customermanagement.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceItemViewPdfDto {

    private String contents;
    private BigDecimal price;
}
