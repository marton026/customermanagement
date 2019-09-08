package pl.sdacademy.customermanagement.service;

import lombok.RequiredArgsConstructor;
import org.apache.el.lang.ELArithmetic;
import org.hibernate.cfg.ObjectNameSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.customermanagement.dto.InvoiceItemViewPdfDto;
import pl.sdacademy.customermanagement.dto.InvoiceViewPdfDto;
import pl.sdacademy.customermanagement.model.Invoice;
import pl.sdacademy.customermanagement.model.InvoiceItem;
import pl.sdacademy.customermanagement.repository.InvoiceRepository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.apache.el.lang.ELArithmetic.BIGDECIMAL;
import static org.apache.el.lang.ELArithmetic.multiply;

@Service
@RequiredArgsConstructor
public class ViewPdfService {

    private final InvoiceRepository invoiceRepository;

    @Transactional(readOnly = true)
    public InvoiceViewPdfDto findById(Long id) {
        return invoiceRepository.findById(id)
                .map(this::invoiceToPdfDto)
                .orElseThrow(() -> new IllegalStateException("brak widoku pdf"));
    }

    private InvoiceViewPdfDto invoiceToPdfDto(Invoice invoice) {
        return InvoiceViewPdfDto.builder()
                .firstName(invoice.getLuser().getFirstName())
                .lastName(invoice.getLuser().getLastName())
                .street(invoice.getLuser().getStreet())
                .city(invoice.getLuser().getCity())
                .zipCode(invoice.getLuser().getZipCode())
                .company(invoice.getLuser().getCompany())
                .idNumber(invoice.getLuser().getIdNumber())
                .invoiceNo(invoice.getInvoiceNo())
                .invoiceDate(invoice.getInvoiceDate())
                .datePaid(invoice.getDatePaid())
                .invoiceId(invoice.getId())
                .items(invoice.getInvoice_items().stream()
                        .map(item -> invoiceItemToPdfDto(item))
                        .collect(Collectors.toList()))
                .total(invoice.getInvoice_items().stream()
                .map(item1 -> BigDecimal.valueOf(item1.getNumberOfItems()).multiply(item1.getPrice()))
                .reduce(BigDecimal.ZERO,BigDecimal::add))
                .build();
    }

    private InvoiceItemViewPdfDto invoiceItemToPdfDto(InvoiceItem item) {
        return InvoiceItemViewPdfDto.builder()
                .id(item.getId())
                .contents(item.getContents())
                .numberOfItems(item.getNumberOfItems())
                .price(item.getPrice())
                .build();
    }
}
