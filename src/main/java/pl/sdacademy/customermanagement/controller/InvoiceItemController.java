package pl.sdacademy.customermanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sdacademy.customermanagement.dto.InvoiceDto;
import pl.sdacademy.customermanagement.dto.InvoiceItemDto;
import pl.sdacademy.customermanagement.service.InvoiceItemService;
import pl.sdacademy.customermanagement.service.InvoiceService;
import pl.sdacademy.customermanagement.service.PdfService;
import pl.sdacademy.customermanagement.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/item")
@RequiredArgsConstructor
public class InvoiceItemController {


    private final InvoiceItemService invoiceItemService;
    private final InvoiceService invoiceService;
    private final PdfService pdfService;


    @GetMapping("/create")
    ModelAndView createItemView(@RequestParam("id") Long invoiceId) {
        ModelAndView modelAndView = new ModelAndView("createInvoiceItem.html");
        modelAndView.addObject("item", new InvoiceItemDto(invoiceId));
        return modelAndView;
    }

    @PostMapping("/create")
    String createItem(@ModelAttribute InvoiceItemDto invoiceItemDto) {
        invoiceItemService.createOrUpdate(invoiceItemDto);
        //InvoiceItemDto byId = invoiceItemService.findById(invoiceItemDto.getInvoiceId());
        return "redirect:./view?id="+invoiceItemDto.getInvoiceId();
    }

    @GetMapping("/view")
    ModelAndView getAll(@RequestParam("id") Long invoiceId) {
        List<InvoiceItemDto> listItems = invoiceItemService.find(invoiceId);
        ModelAndView mav = new ModelAndView("viewInvoiceItem.html");
        mav.addObject("listItems", listItems);
        mav.addObject("itemInvoiceNo", invoiceService.findById(invoiceId).getInvoiceNo());
        mav.addObject("itemInvoiceID", invoiceService.findById(invoiceId).getId());
        return mav;
    }

    @GetMapping("/delete")
    String deleteItem(@RequestParam Long id) {
        invoiceItemService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit")
    ModelAndView editItem(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("createInvoiceItem.html");
        modelAndView.addObject("item", invoiceItemService.findById(id));
        return modelAndView;
    }
   /* @PostMapping("/save")
    String saveInvoice(@ModelAttribute InvoiceDto invoice) {
        Long id = invoiceService.createOrUpdate(invoice);
       // pdfService.createPdf(id);
        return pdfService.createPdf(id) ;
    }*/


    @PostMapping("/save")
    String saveInvoice(@ModelAttribute InvoiceDto invoice) {
        Long id = invoiceService.createOrUpdate(invoice);
        pdfService.createPdf(id);
        return "redirect:/";
    }
    }




