/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.co.seatec.fulltestspingboot.service;

import java.util.List;
import java.util.Optional;
import ke.co.seatec.fulltestspingboot.entity.TUSERS;
import ke.co.seatec.fulltestspingboot.model.UserModel;

/**
 *
 * @author ASimiyu
 */
public interface UserService {

    List<TUSERS> createUser(UserModel newUser);

    List<TUSERS> getAllUsers();

    Optional<TUSERS> getUserById(int userId);

    List<TUSERS> deleteUser(int userId);

    TUSERS updateUser(int id, UserModel updateUser);

    Optional<TUSERS> getUserByPhone(String phone);

    Optional<TUSERS> getUserByEmail(String email);

    Optional<TUSERS> getUserByUsername(String username);

}
