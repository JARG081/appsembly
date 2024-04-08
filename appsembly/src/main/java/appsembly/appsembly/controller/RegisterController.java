package appsembly.appsembly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import appsembly.appsembly.service.UserServiceImpl;

@Controller
@RequestMapping("/registration")
public class RegisterController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping
    public String register(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email,
            @RequestParam String password, @RequestParam String passwordConfirm, @RequestParam String role,
            ModelMap model) {
        try {
            userServiceImpl.register(firstName, lastName, email, password, passwordConfirm, "USER", 12345, false);
            model.put("successful", "usuario registrado correctamente!");
            return "register";
        } catch (Exception e) {
            System.out.println("Estoy en el exception: ");

            model.put("error", e.getMessage());
            model.put("name", firstName);
            model.put("email", email);
            return "register";
        }
    }

    @GetMapping
    public String showRegistrationForm() {
        return "register";
    }

}
