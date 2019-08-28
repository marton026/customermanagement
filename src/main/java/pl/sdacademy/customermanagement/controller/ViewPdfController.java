package pl.sdacademy.customermanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.sdacademy.customermanagement.service.ViewPdfService;

@Controller
@RequestMapping("/pdf")
@RequiredArgsConstructor
public class ViewPdfController {

    private final ViewPdfService viewPdfService;

    @GetMapping("/view")
    ModelAndView getInvoicePreview(@RequestParam Long id) {
        ModelAndView mav = new ModelAndView("pdfView.html");
        mav.addObject("listPdf", viewPdfService.findById(id));
        return mav;
    }
}
