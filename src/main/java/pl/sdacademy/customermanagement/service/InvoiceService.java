package pl.sdacademy.customermanagement.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdacademy.customermanagement.dto.InvoiceDto;
import pl.sdacademy.customermanagement.model.Invoice;
import pl.sdacademy.customermanagement.repository.InvoiceRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;


    //zmienna pomocnicza
    //todo Trzeba wyciągnąć ostatni numer faktury z bazy danych
    private String lastInvoiceNoFromDb = "FV0000/19";   // ostatni numer faktury wyciągnięty z bazy danych

    //rok z ostatniej nazwy faktury w bazie danych
    private String yearFromlastInvoiceNoFromDb = lastInvoiceNoFromDb.substring(7,9); //  "FV0003/19" --> 19

    Date currentDate = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yy");
    String yearString = dateFormat.format(currentDate);

    //funkcja parsuje Stringa na int Np.: "FV0003/19" --> 3
    //jeśli jest kolejny rok rozpoczyna numerację od 1 np: FV0001/20
    public int getLastNoFromString() {
        if (yearFromlastInvoiceNoFromDb.equals(yearString)) {
            return Integer.parseInt(lastInvoiceNoFromDb.substring(2, 6));
        } else {
            return 0;
        }
    }
    //Funkcja ma generować kolejny numer faktury w zależności od aktualnego roku i poprzedniego numeru
    public String invoiceNoFromDbToNext(int invNo) {
        return "FV"+String.format("%04d", invNo+1)+"/"+yearString;
    }


    public void createOrUpdate(InvoiceDto dto) {
        Invoice invoice = Invoice.builder()
                .id(dto.getId())
                .invoiceNo(invoiceNoFromDbToNext(getLastNoFromString()))  //wstawienie numeru faktury do bazy
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



    //todo
//    public InvoiceDto findLastInvoiceNo() {
//
//        return null;
//    }



}
