package uz.brogrammer.securety;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uz.brogrammer.admin.model.Admin;
import uz.brogrammer.admin.service.AdminService;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final AdminService adminService;


    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String home() {
        return "security/login.html";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model) {
        Authentication authentication =
                new UsernamePasswordAuthenticationToken(username, password);
        System.err.println("authentication" + authentication.getPrincipal());
        System.err.println("authentication" + authentication.isAuthenticated());
        AuthenticationManager authenticationManager =
                (AuthenticationManager) SecurityContextHolder.getContext().getAuthentication();
        Authentication result = authenticationManager.authenticate(authentication);
        SecurityContextHolder.getContext().setAuthentication(result);
        return "redirect:/admin/auth/candidates";
    }

}
