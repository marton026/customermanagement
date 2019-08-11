package pl.sdacademy.customermanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pl.sdacademy.customermanagement.dto.InvoiceDto;

@RestController
@RequestMapping("/invoice")
@RequiredArgsConstructor
public class InvoiceController {


    private final InvoiceService invoiceService;

    @GetMapping("/create")
    ModelAndView createInvoiceView() {
        ModelAndView modelAndView = new ModelAndView("createInvoice.html");
        modelAndView.addObject("invoice", new InvoiceDto());

        return modelAndView;
    }
}
