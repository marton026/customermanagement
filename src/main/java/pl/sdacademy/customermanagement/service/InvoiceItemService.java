package pl.sdacademy.customermanagement.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdacademy.customermanagement.dto.InvoiceItemDto;
import pl.sdacademy.customermanagement.model.Invoice;
import pl.sdacademy.customermanagement.model.InvoiceItem;
import pl.sdacademy.customermanagement.repository.InvoiceItemRepository;
import pl.sdacademy.customermanagement.repository.InvoiceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvoiceItemService {

    private final InvoiceItemRepository invoiceItemRepository;
    private final InvoiceRepository invoiceRepository;


    public void createOrUpdate(InvoiceItemDto dto) {
        Invoice invoice = invoiceRepository.findById(dto.getInvoiceId())
                .orElseThrow(()-> new IllegalStateException("Faktura nie istnieje"));

        InvoiceItem invoiceItem= InvoiceItem.builder()
                .id(dto.getId())
                .contents(dto.getContents())
                .numberOfItems(dto.getNumberOfItems())
                .price(dto.getPrice())
                .linvoice(invoice)
                .build();

        invoiceItemRepository.save(invoiceItem);
    }

    public InvoiceItemDto findById(Long id) {
        return invoiceItemRepository.findById(id)
                .map(InvoiceItem::toDto)
                .orElseThrow(() -> new IllegalStateException("nie ma takiej faktury"));
    }


    public void delete(Long id) {
        invoiceItemRepository.deleteById(id);

    }

    public List<InvoiceItemDto> find(Long invoiceId) {
        List<InvoiceItem> list = invoiceId == null ? invoiceItemRepository.findAll() :
                invoiceItemRepository.findByLinvoice_Id(invoiceId);
        return list.stream()
                .map(InvoiceItem::toDto)
                .collect(Collectors.toList());
    }







}
