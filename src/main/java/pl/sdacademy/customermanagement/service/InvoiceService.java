package pl.sdacademy.customermanagement.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdacademy.customermanagement.dto.InvoiceDto;
import pl.sdacademy.customermanagement.model.Invoice;
import pl.sdacademy.customermanagement.model.User;
import pl.sdacademy.customermanagement.repository.InvoiceRepository;
import pl.sdacademy.customermanagement.repository.UserRepository;

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
    private final UserRepository userRepository;

    public String invoiceNoFromDbToNext(int invNo) {
        return "FV"+String.format("%04d", invNo)+"/"+String.valueOf(LocalDate.now().getYear()).substring(2);
    }

    public Long createOrUpdate(InvoiceDto dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalStateException("Użytkownik nie istnieje"));

        Invoice invoice = Invoice.builder()
                .id(dto.getId())
                .invoiceNo(invoiceNoFromDbToNext(findNextInvoiceNumber()))
                .invoiceDate(LocalDateTime.now())
                .datePaid(dto.getDatePaid())
                .luser(user)
                .build();
        return invoiceRepository.save(invoice).getId();
    }

    public InvoiceDto findById(Long id) {
        return invoiceRepository.findById(id)
                .map(Invoice::toDto)
                .orElseThrow(() -> new IllegalStateException("nie ma takiej faktury"));
    }


    public void delete(Long id) {
        invoiceRepository.deleteById(id);

    }

    public List<InvoiceDto> find(Long userId) {
        List<Invoice> list = userId == null ? invoiceRepository.findAll() :
                invoiceRepository.findByLuser_Id(userId);
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
