package web.CRUDbootV2.dao;



import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.CRUDbootV2.models.User;


import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager em;

    public UserDAOImpl(EntityManager em) {
    }


    @Override
    public List<User> index() {
        return em.createQuery("from User",User.class).getResultList();
    }
    @Override
    public User show(int id) {
        return em.find(User.class, id);
    }
    @Override
    public void save(User user) {
        em.persist(user);
    }
    @Override
    public void update(User updatedUser,int id) {

        User userToBeUpdated = em.find(User.class, id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setLastName(updatedUser.getLastName());
    }
    @Override
    public void delete(int id) {
        em.remove(em.find(User.class, id));
    }
}
