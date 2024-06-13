package task_3.task_3_1_4.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import task_3.task_3_1_4.model.User;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public User getUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
