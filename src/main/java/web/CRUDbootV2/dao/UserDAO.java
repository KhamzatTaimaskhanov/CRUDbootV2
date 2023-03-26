package web.CRUDbootV2.dao;



import web.CRUDbootV2.models.User;

import java.util.List;

public interface UserDAO {
    List<User> index();
    User show(int id);
    void save(User user);
    void update(User user, int id);
    void delete(int id);
}
