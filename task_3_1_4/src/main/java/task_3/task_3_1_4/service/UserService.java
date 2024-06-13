package task_3.task_3_1_4.service;

import task_3.task_3_1_4.model.User;

import java.util.List;


public interface UserService {

    public void addUser(User user);

    public List<User> getUserList();

    public User getUserById(Long id) throws Exception;

    public User getUserByEmail(String email);

    public void updateUser(User user);

    public void deleteUserById(Long id);
}
