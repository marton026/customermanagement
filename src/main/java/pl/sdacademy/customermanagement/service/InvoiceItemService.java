package pl.sdacademy.customermanagement.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdacademy.customermanagement.dto.InvoiceDto;
import pl.sdacademy.customermanagement.dto.InvoiceItemDto;
import pl.sdacademy.customermanagement.model.Invoice;
import pl.sdacademy.customermanagement.model.InvoiceItem;
import pl.sdacademy.customermanagement.repository.InvoiceItemRepository;
import pl.sdacademy.customermanagement.repository.InvoiceRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvoiceItemService {

    private final InvoiceItemRepository invoiceItemRepository;


    public void createOrUpdate(InvoiceItemDto dto) {
        InvoiceItem invoiceItem= InvoiceItem.builder()
                .id(dto.getId())
                .contents(dto.getContents())
                .price(dto.getPrice())
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

    public List<InvoiceItemDto> findAll() {
        List<InvoiceItem> list = invoiceItemRepository.findAll();
        return list.stream()
                .map(InvoiceItem::toDto)
                .collect(Collectors.toList());
    }







}
