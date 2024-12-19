package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@RestController
@Controller
@RequestMapping("/login")
public class LoginController {
    private final AuthService authService;
    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    //@RequestMapping(method = RequestMethod.GET, value = "/login")
    @GetMapping
    public String getLoginPage(@RequestParam(required = false) String error, Model model ) {
        if (error != null) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        return "login";
    }
    @PostMapping
    public String login(HttpServletRequest request, Model model) {
        User user = null;

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            user = authService.login(username, password);
            request.getSession().setAttribute("user", user);
            // Redirect to the home page
            return "redirect:/events";

        } catch (RuntimeException ex) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", ex.getMessage());
            return "login";
        }
    }
}
