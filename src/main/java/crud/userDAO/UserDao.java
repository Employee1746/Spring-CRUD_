package crud.userDAO;

import crud.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUser();

    public void saveUser(User user);

    public void deleteUser(Long id);

    public void updateUser(User user);

    public User getUserById(Long id);
}
