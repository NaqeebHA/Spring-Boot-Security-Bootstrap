package task_3.task_3_1_4.controller;

import bootstrap_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;

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
