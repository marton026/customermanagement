package pl.sdacademy.customermanagement.dto;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class invoiceItemDto {

    private Long id;
    private String contents;
    private BigDecimal price;
}
