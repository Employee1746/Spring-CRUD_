package crud.userDAO;

import crud.Model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@SuppressWarnings("ALL")
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUser() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User userById(Long id) {
        TypedQuery<User> query = entityManager.createQuery("select user from User user where user.id = :id", User.class);
        query.setParameter("id", id);
        User result = query.getResultList().stream().filter(user -> user.getId() == id).findAny().orElse(null);
        System.out.println("user из userById" + result);
        return result;
    }

    @Override
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(User user) {
        System.out.println("user из updateUser" + user);
        entityManager.merge(user);
    }
}


