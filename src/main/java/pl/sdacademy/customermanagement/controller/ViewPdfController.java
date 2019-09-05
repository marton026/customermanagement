package pl.sdacademy.customermanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.sdacademy.customermanagement.service.InvoiceItemService;
import pl.sdacademy.customermanagement.service.PdfService;
import pl.sdacademy.customermanagement.service.ViewPdfService;

import java.io.IOException;

@Controller
@RequestMapping("/pdf")
@RequiredArgsConstructor
public class ViewPdfController {

    private final ViewPdfService viewPdfService;
    private final PdfService pdfService;
    private final InvoiceItemService invoiceItemService;

    @GetMapping("/view")
    ModelAndView getInvoicePreview(@RequestParam Long id) {
        ModelAndView mav = new ModelAndView("pdfView.html");
        mav.addObject("listPdf", viewPdfService.findById(id));

        //mav.addObject("sumTotal",viewPdfService.total(id));
        return mav;
    }

    @GetMapping("/gen")
    String testInvoiceGeneration(@RequestParam Long id) {
        try {
            pdfService.createPdf(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:../user/view";
    }
}
