package task_3.task_3_1_4.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import task_3.task_3_1_4.model.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
