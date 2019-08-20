package pl.sdacademy.customermanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sdacademy.customermanagement.dto.InvoiceDto;
import pl.sdacademy.customermanagement.service.InvoiceService;

import java.util.List;

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

    @GetMapping("/view")
    ModelAndView getAll() {
        List<InvoiceDto> listInvoices = invoiceService.findAll();
        return new ModelAndView("viewInvoice.html", "listInvoices", listInvoices);
    }

    @GetMapping("/delete")
    String deleteInvoice(@RequestParam Long id) {
        invoiceService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit")
    ModelAndView editInvoice(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("createInvoice.html");
        modelAndView.addObject("invoice", invoiceService.findById(id));
        return modelAndView;
    }



}
