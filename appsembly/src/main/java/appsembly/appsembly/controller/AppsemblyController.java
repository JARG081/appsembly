package appsembly.appsembly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppsemblyController {
    @GetMapping("/index")
    public String index(@RequestParam(required = false) String error, ModelMap model) {
        if (error != null) {
            model.put("error", "usuario o contraseña invalido");
        }
        return "index";
    }
}
