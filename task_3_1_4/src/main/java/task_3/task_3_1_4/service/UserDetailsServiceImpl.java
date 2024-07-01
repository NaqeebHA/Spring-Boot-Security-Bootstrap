package task_3.task_3_1_4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import task_3.task_3_1_4.model.User;
import task_3.task_3_1_4.repo.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
            this.userRepository = userRepository;
        }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (User) userRepository.findUserAndRolesByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found for Username: " + username));

    }
}

