package task_3.task_3_1_4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import task_3.task_3_1_4.model.Role;
import task_3.task_3_1_4.model.User;
import task_3.task_3_1_4.repo.RoleRepository;
import task_3.task_3_1_4.service.UserService;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    UserService userService;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder encoder;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userRegistrationForm", new User());
        return "registration";
    }

    @PostMapping("/registered")
    public String registerUser(@Valid @ModelAttribute("userRegistrationForm") User newUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        String encodedPassword = encoder.encode(newUser.getPassword());
        newUser.setPassword(encodedPassword);
        Role userRole = roleRepository.findByRole("USER").get();
        List<Role> newRole = List.of(userRole);
        newUser.setRoles(new HashSet<Role>(newRole));
        userService.addUser(newUser);
        return "register_success";
    }
}
