package pl.sdacademy.customermanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sdacademy.customermanagement.dto.InvoiceDto;
import pl.sdacademy.customermanagement.dto.InvoiceItemDto;
import pl.sdacademy.customermanagement.service.InvoiceItemService;
import pl.sdacademy.customermanagement.service.InvoiceService;
import pl.sdacademy.customermanagement.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/item")
@RequiredArgsConstructor
public class InvoiceItemController {


    private final InvoiceItemService invoiceItemService;
    private final InvoiceService invoiceService;


    @GetMapping("/create")
    ModelAndView createItemView(@RequestParam("id") Long invoiceId) {
        ModelAndView modelAndView = new ModelAndView("createInvoiceItem.html");
        modelAndView.addObject("item", new InvoiceItemDto(invoiceId));
        return modelAndView;
    }

    @PostMapping("/create")
    String createItem(@ModelAttribute InvoiceItemDto invoiceItemDto) {
        invoiceItemService.createOrUpdate(invoiceItemDto);
        return "redirect:/";
    }

    @GetMapping("/view")
    ModelAndView getAll(@RequestParam("id") Long invoiceId) {
        List<InvoiceItemDto> listItems = invoiceItemService.find(invoiceId);
        ModelAndView mav = new ModelAndView("viewInvoiceItem.html");
        mav.addObject("listItems", listItems);
        mav.addObject("itemInvoiceNo", invoiceService.findById(invoiceId).getInvoiceNo());
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



}
