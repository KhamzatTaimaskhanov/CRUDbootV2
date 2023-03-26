package web.CRUDbootV2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.CRUDbootV2.dao.UserDAO;
import web.CRUDbootV2.models.User;


import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public List<User> findAllUser() {
        return userDAO.index();
    }

    @Override
    @Transactional
    public User findUserById(int id) {
        return userDAO.show(id);
    }

    @Override
    @Transactional
    public void saveUserByUser(User user) {
        userDAO.save(user);
    }

    @Override
    @Transactional
    public void updateUserByUserAndId(User user, int id) {
        userDAO.update(user, id);
    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        userDAO.delete(id);
    }
}
