package crud.userDAO;

import crud.Model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUser();

    public void saveUser(User user);
}
