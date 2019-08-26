package pl.sdacademy.customermanagement.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceItemViewPdfDto {

    private Long id;
    private String contents;
    private int numberOfItems;
    private BigDecimal price;
}
