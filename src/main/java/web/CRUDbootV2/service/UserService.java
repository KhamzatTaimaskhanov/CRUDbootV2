package web.CRUDbootV2.service;



import web.CRUDbootV2.models.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();
    User findUserById(int id);
    void saveUserByUser(User user);
    void updateUserByUserAndId(User user, int id);
    void deleteUserById(int id);
}
