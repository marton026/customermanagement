package pl.sdacademy.customermanagement.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdacademy.customermanagement.dto.InvoiceDto;
import pl.sdacademy.customermanagement.model.Invoice;
import pl.sdacademy.customermanagement.repository.InvoiceRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    //Funkcja ma generować kolejny numer faktury w zależności od aktualnego roku i poprzedniego numeru
    public String invoiceNoFromDbToNext(int invNo) {
        return "FV"+String.format("%04d", invNo)+"/"+String.valueOf(LocalDate.now().getYear()).substring(2);
    }

    public void createOrUpdate(InvoiceDto dto) {
        Invoice invoice = Invoice.builder()
                .id(dto.getId())
                .invoiceNo(invoiceNoFromDbToNext(findNextInvoiceNumber()))  //wstawienie numeru faktury do bazy
                .invoiceDate(LocalDateTime.now())
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

    public Integer findNextInvoiceNumber() {
        Optional<String> lastInvoiceNumber = invoiceRepository.findlastInvoiceDate().map(Invoice::getInvoiceNo);
        if (!lastInvoiceNumber.isPresent()) {
            return 1;
        }

        String invoiceNumber =  lastInvoiceNumber.get();
        String yearFromlastInvoiceNoFromDb = invoiceNumber.substring(7,9); //  "FV0003/19" --> 19

        String currentYear = String.valueOf(LocalDate.now().getYear()).substring(2);

        if (yearFromlastInvoiceNoFromDb.equals(currentYear)) {
            return Integer.parseInt(invoiceNumber.substring(2, 6)) + 1;
        } else {
            return 1;
        }
    }






}
