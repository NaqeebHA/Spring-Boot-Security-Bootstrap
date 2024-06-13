package task_3.task_3_1_4.dto;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import task_3.task_3_1_4.model.Role;
import task_3.task_3_1_4.model.User;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class UserDTO {

    @NotEmpty(message = "First name cannot be empty.")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty.")
    private String lastName;

    @NotNull(message = "Age must be between 0 and 200")
    @Range(min = 0, max = 200)
    private Integer age;

    @NotEmpty(message = "Email cannot be empty.")
    private String email;

    private String password;

    private Set<Role> roles = new HashSet<>();

    public UserDTO() {}

    public UserDTO(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.age = user.getAge();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = user.getRoles();
    }

    public UserDTO(String firstName, String lastName, Integer age, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public UserDTO(String firstName, String lastName, Integer age, String email, String password, Set<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public String getUsername() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "User{firstName=" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
