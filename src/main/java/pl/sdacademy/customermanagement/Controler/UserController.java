package pl.sdacademy.customermanagement.Controler;

//import org.springframework.stereotype.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sdacademy.customermanagement.model.User;

import javax.validation.Valid;

@Controller
public class UserController {

    @GetMapping("/signup")
    public String showRegistrationForm(User user) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        } else {
            userRepository.save(user);
            model.addAttribute("users", userRepository.findAll());
            return index;
        }
    }
}