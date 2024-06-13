package task_3.task_3_1_4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import task_3.task_3_1_4.service.UserService;

public class PublicController {

    @Autowired
    UserService userService;
    @Autowired
    BCryptPasswordEncoder encoder;

    @GetMapping("/")
    public String index() {
        return "index";
    }

}
