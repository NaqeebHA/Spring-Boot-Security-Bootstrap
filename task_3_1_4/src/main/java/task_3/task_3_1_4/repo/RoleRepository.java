package task_3.task_3_1_4.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import task_3.task_3_1_4.model.Role;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRole(String role);
}
