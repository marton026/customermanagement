package pl.sdacademy.customermanagement.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.customermanagement.dto.InvoiceItemViewPdfDto;
import pl.sdacademy.customermanagement.dto.InvoiceViewPdfDto;
import pl.sdacademy.customermanagement.model.Invoice;
import pl.sdacademy.customermanagement.model.InvoiceItem;
import pl.sdacademy.customermanagement.repository.InvoiceRepository;

import java.util.stream.Collectors;

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
                .invoiceId(invoice.getId())
                .items(invoice.getInvoice_items().stream()
                        .map(item -> invoiceItemToPdfDto(item))
                        .collect(Collectors.toList()))
                .build();
    }

    private InvoiceItemViewPdfDto invoiceItemToPdfDto(InvoiceItem item) {
        return InvoiceItemViewPdfDto.builder()
                .contents(item.getContents())
                .price(item.getPrice())
                .build();
    }
}
