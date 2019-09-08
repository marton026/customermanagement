package pl.sdacademy.customermanagement.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {

    @Scheduled(cron="0 0 3 5 1/1 ? *") //metoda wykonuje się 5 dnia każdego miesiąca o godzinie 3am
    public void invoiceSend() {

    }

}
