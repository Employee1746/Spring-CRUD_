package crud.userDAO;

import crud.Model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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
    public void deleteUser(User user) {
        entityManager.remove(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.refresh(user);
    }
}
//Через сессион фактори работает!!!
//    @Override
//    @SuppressWarnings("unchecked")
//    public List<User> getAllUser() {
//        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
//        return query.getResultList();
//    }
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    @Override
//    public void saveUser(User user) {
//        System.out.println((user)+"user from dao");
//        sessionFactory.getCurrentSession().save(user);
//}



