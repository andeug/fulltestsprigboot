/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.co.seatec.fulltestspingboot.serviceimpl;

import java.util.*;
import javax.transaction.Transactional;
import ke.co.seatec.fulltestspingboot.entity.TUSERS;
import ke.co.seatec.fulltestspingboot.model.UserModel;
import ke.co.seatec.fulltestspingboot.repository.UserRepository;
import ke.co.seatec.fulltestspingboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASimiyu
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<TUSERS> createUser(UserModel newUser) {
        try {
            TUSERS user = new TUSERS();
            user.setId(null);
            user.setEmail(newUser.getEmail());
            user.setPassword(newUser.getPassword());
            user.setPhone(newUser.getPhone());
            user.setFirstname(newUser.getFirstname());
            user.setSurname(newUser.getSurname());
            user.setGender(newUser.getGender());
            user.setUsername(newUser.getUsername());
            user.setDateCreated(new Date());
            user.setDateUpdated(new Date());
            user.setId(newUser.getId());
            userRepository.save(user);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
        }
        return userRepository.findAll();
    }

    @Override
    public List<TUSERS> getAllUsers() {
        try {
            List<TUSERS> result = userRepository.findAll();
            if (!result.isEmpty()) {
                return result;
            } else {
                return new ArrayList<>();
            }
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public Optional<TUSERS> getUserById(int userId) {
        try {
            return userRepository.findById(userId);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<TUSERS> deleteUser(int userId) {
        Optional<TUSERS> user = getUserById(userId);
        if (user.isPresent()) {
            userRepository.deleteById(userId);
            return getAllUsers();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public TUSERS updateUser(int id, UserModel updateUser) {

        TUSERS newEntity = new TUSERS();

        newEntity.setUsername(updateUser.getUsername());
        newEntity.setPassword(updateUser.getPassword());
        newEntity.setPhone(updateUser.getPhone());
        newEntity.setEmail(updateUser.getEmail());
        newEntity.setGender(updateUser.getGender());
        newEntity.setFirstname(updateUser.getFirstname());
        newEntity.setSurname(updateUser.getSurname());
        newEntity.setId(updateUser.getId());
        newEntity.setDateUpdated(new Date());
        newEntity = userRepository.save(newEntity);
        return newEntity;

    }

    @Override
    public Optional<TUSERS> getUserByPhone(String phone) {
        try {
            return userRepository.findByPhone(phone);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<TUSERS> getUserByEmail(String email) {
        try {
            return userRepository.findByEmail(email);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<TUSERS> getUserByUsername(String username) {
        try {
            return userRepository.findByUsername(username);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            return Optional.empty();
        }
    }

}
