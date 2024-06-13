package task_3.task_3_1_4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import task_3.task_3_1_4.service.AuthenticationService;
import task_3.task_3_1_4.service.UserService;

import java.util.Set;

@Controller
@RequestMapping("/user")

public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    AuthenticationService authenticationService;

    @ModelAttribute
    public void addAttributes(Model model) {
        if (authenticationService.getUser() != null) {
            model.addAttribute("userDetails", authenticationService.getUser());
            Set<String> roles = AuthorityUtils.authorityListToSet(authenticationService.getUser().getAuthorities());
            if (authenticationService.getUser().getAuthorities() != null) {
                model.addAttribute("role_admin", roles.contains("ROLE_ADMIN"));
                model.addAttribute("role_user", roles.contains("ROLE_USER"));
            }
        }
    }

    @GetMapping("")
    public String index(Model model) {
        return "user";
    }

}


