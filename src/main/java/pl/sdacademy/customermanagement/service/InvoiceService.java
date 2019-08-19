package pl.sdacademy.customermanagement.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdacademy.customermanagement.dto.InvoiceDto;
import pl.sdacademy.customermanagement.model.Invoice;
import pl.sdacademy.customermanagement.repository.InvoiceRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

//    public Long create(InvoiceDto dto) {
//        return invoiceRepository.save(Invoice.fromDto(dto)).getId();
//    }

    public void createOrUpdate(InvoiceDto dto) {
        Invoice invoice = Invoice.builder()
                .id(dto.getId())
                .invoiceNo(dto.getInvoiceNo())
                .invoiceDate(dto.getInvoiceDate())
                .datePaid(dto.getDatePaid())
                .build();
        invoiceRepository.save(invoice);
    }

    public InvoiceDto findById(Long id) {
        return invoiceRepository.findById(id)
                .map(Invoice::toDto)
                .orElseThrow(() -> new IllegalStateException("nie ma takiej faktury"));
    }


    public void delete(Long id) {
        invoiceRepository.deleteById(id);

    }

    public List<InvoiceDto> findAll() {
        List<Invoice> list = invoiceRepository.findAll();
        return list.stream()
                .map(Invoice::toDto)
                .collect(Collectors.toList());
    }


}
