package pl.sdacademy.customermanagement.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdacademy.customermanagement.dto.InvoiceDto;
import pl.sdacademy.customermanagement.model.Invoice;
import pl.sdacademy.customermanagement.repository.InvoiceRepository;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public void create(InvoiceDto dto) {
        Invoice invoice = Invoice.builder()
                .id(dto.getId())
                .invoiceNo(dto.getInvoiceNo())
                .createDate(dto.getCreateDate())
                .datePaid(dto.getDatePaid())
                .build();
        invoiceRepository.save(invoice);
    }

    public InvoiceDto findById(Long id) {
        return invoiceRepository.findById(id)
                .map(Invoice::toDto)
                .orElseThrow(() -> new IllegalStateException("nie ma takiej faktury"));
    }



    public void delete(Long invoiceId) {
        invoiceRepository.deleteById(invoiceId);

    }
}
