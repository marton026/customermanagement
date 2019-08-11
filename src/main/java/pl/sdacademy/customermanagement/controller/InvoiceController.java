package pl.sdacademy.customermanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sdacademy.customermanagement.dto.InvoiceDto;

@Controller
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

    @PostMapping("/create")
    String createInvoice(@ModelAttribute InvoiceDto invoice) {
        invoiceService.createOrUpdate(invoice);
        return "redirect:/";
    }


}
