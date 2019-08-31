package pl.sdacademy.customermanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sdacademy.customermanagement.dto.InvoiceDto;
import pl.sdacademy.customermanagement.service.InvoiceService;
import pl.sdacademy.customermanagement.service.PdfService;
import pl.sdacademy.customermanagement.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/invoice")
@RequiredArgsConstructor
public class InvoiceController {


    private final InvoiceService invoiceService;
    private final UserService userService;
    private final PdfService pdfService;


    @GetMapping("/create")
    ModelAndView createInvoiceView(@RequestParam("id") Long userId) {
        ModelAndView modelAndView = new ModelAndView("createInvoice.html");
        modelAndView.addObject("invoice", new InvoiceDto(userId));
        return modelAndView;
    }

    @PostMapping("/create")
    String createInvoice(@ModelAttribute InvoiceDto invoice) {
        Long id = invoiceService.createOrUpdate(invoice);
        pdfService.createPdf(id);
        return "redirect:/";
    }

    @GetMapping("/view")
    ModelAndView getAll(@RequestParam("id") Long userId) {
        ModelAndView mav = new ModelAndView("viewInvoice.html");
        mav.addObject("listInvoices", invoiceService.find(userId));
        mav.addObject("userCompany", userService.findById(userId).getCompany());
        mav.addObject("userIdNo", userService.findById(userId).getId());
        return mav;
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
