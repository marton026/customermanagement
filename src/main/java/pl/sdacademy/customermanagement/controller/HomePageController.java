package pl.sdacademy.customermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
public class HomePageController {

    @RequestMapping
    ModelAndView homePageView() {
        ModelAndView mav = new  ModelAndView("index.html");
        mav.addObject("today", LocalDate.now());
        return mav;
    }


}
