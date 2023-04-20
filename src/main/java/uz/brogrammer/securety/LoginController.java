package uz.brogrammer.securety;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
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


    @RequestMapping(value = {"/login"} , method = RequestMethod.GET)
    public String home(){
        return "security/login.html";
    }
    @RequestMapping(value = {"/valid"} , method = RequestMethod.POST)
    public String login(@RequestParam("username")String username, @RequestParam("password") String password , RedirectAttributes massage){
        for (Admin admin: adminService.admins()){
            if (admin.getPassword().equals(password) && admin.getUsername().equals(username)){
                return "redirect:/admin/auth/candidates";
            }
        }
        massage.addFlashAttribute("warning","password or username is wrong. please try again... ");
        return "redirect:/login";
    }

}
