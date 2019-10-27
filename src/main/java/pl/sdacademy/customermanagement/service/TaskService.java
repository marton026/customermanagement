package pl.sdacademy.customermanagement.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.customermanagement.dto.InvoiceDto;

@Service
@RequiredArgsConstructor
public class TaskService {

    private String to = "marton026@tlen.pl";
    private String from = "marton026@gmail.com";
    private String username = "marton026@gmail.com";
    private String password = "-----------";
    private String msg="Treść nowego maila z załącznikiem";
    private String subject = "temat wiadomości z załącznikiem";
    private String attachFile = "C:/install/konkurs.pdf";

    private final EmailService emailService;
    private final InvoiceService invoiceService;


    // @Scheduled(cron="0 0 3 5 1/1 ?") //metoda wykonuje się 5 dnia każdego miesiąca o godzinie 3am
   // @Scheduled(cron="0 0/1 * 1/1 * ?") //metoda wykonuje się co jedną minutę
    @Transactional
    public void invoiceSend() {

        //todo zrobić pętle wstawiając "to" oraz "attachedFile"
        emailService.send(to,from,username,password, msg, subject, attachFile);
    }

    // @Scheduled(cron="0 0 3 4 1/1 ?") //metoda wykonuje się 4 dnia każdego miesiąca o godzinie 3am
     @Scheduled(cron="0 0/1 * 1/1 * ?") //metoda wykonuje się co jedną minutę
    @Transactional
    public void invoiceCreate() {

        //invoiceService.generatingInvoices();


    }

}
