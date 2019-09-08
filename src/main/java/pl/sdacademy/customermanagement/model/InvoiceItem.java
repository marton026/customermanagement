package pl.sdacademy.customermanagement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.sdacademy.customermanagement.dto.InvoiceItemDto;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "invoice_items")

public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String contents;
    private Integer numberOfItems;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice linvoice;

    public InvoiceItemDto toDto() {
        return InvoiceItemDto.builder()
                .id(id)
                .contents(contents)
                .numberOfItems(numberOfItems)
                .price(price)
                .build();
    }

}
