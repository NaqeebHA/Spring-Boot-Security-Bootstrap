package task_3.task_3_1_4;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import task_3.task_3_1_4.model.Role;
import task_3.task_3_1_4.model.User;
import task_3.task_3_1_4.repo.RoleRepository;
import task_3.task_3_1_4.repo.UserRepository;
import task_3.task_3_1_4.service.UserService;

import java.util.*;

@SpringBootTest
public class AppTest {

    private static final Logger log = LoggerFactory.getLogger(AppTest.class);
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder encoder;

    @Test
    public void testUser() throws Exception {
        Optional<User> adminUser = userRepository.findByEmail("admin@admin");
        if (!adminUser.isPresent()) {
            User admin = new User("admin", "admin", 36, "admin@admin", encoder.encode("admin"));
            Role adminRole = roleRepository.findByRole("ADMIN").get();
            Set<Role> roleAdmin = new HashSet<>();
            roleAdmin.add(adminRole);
            admin.setRoles(roleAdmin);
            userService.addUser(admin);
        }

        Optional<User> userUser = userRepository.findByEmail("user@user");
        if (!userUser.isPresent()) {
            User user = new User("user", "user", 63, "user@user", encoder.encode("user"));
            Role userRole = roleRepository.findByRole("USER").get();
            Set<Role> roleUser = new HashSet<>();
            roleUser.add(userRole);
            user.setRoles(roleUser);
            userService.addUser(user);
        }
    }

    @Test
    public void testAddUser() throws Exception {
        Optional<User> adminuserUser = userRepository.findByEmail("new@user");
        if (!adminuserUser.isPresent()) {
            User adminuser = new User("new", "user", 36, "new@user", encoder.encode("adminuser"));
            Role userRole = roleRepository.findByRole("USER").get();
            Set<Role> role = new HashSet<>();
            role.add(userRole);
            adminuser.setRoles(role);
            userService.addUser(adminuser);

            AppTest.log.info("adminuser added!");
        }
    }
}
