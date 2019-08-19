package pl.sdacademy.customermanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sdacademy.customermanagement.dto.UserDto;
import pl.sdacademy.customermanagement.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;


    @GetMapping("/create")
    ModelAndView createUserView() {
        ModelAndView modelAndView = new ModelAndView("createUser.html");
        modelAndView.addObject("user", new UserDto());
        return modelAndView;
    }

    @PostMapping("/create")
    String createUser(@ModelAttribute UserDto user) {
        userService.createOrUpdate(user);
        return "redirect:/";
    }

    @GetMapping("/view")
    ModelAndView getAll() {
        List<UserDto> listUsers = userService.findAll();
        return new ModelAndView("viewUser.html", "listUsers", listUsers);
    }

    @GetMapping("/delete")
    String deleteUser(@RequestParam Long id) {
        userService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit")
    ModelAndView editUser(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("createUser.html");
        modelAndView.addObject("user", userService.findById(id));
        return modelAndView;
    }


}
