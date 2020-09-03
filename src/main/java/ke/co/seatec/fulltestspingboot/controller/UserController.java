/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.co.seatec.fulltestspingboot.controller;

import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import ke.co.seatec.fulltestspingboot.entity.TUSERS;
import ke.co.seatec.fulltestspingboot.model.UserModel;
import ke.co.seatec.fulltestspingboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASimiyu
 */
@RestController
@RequestMapping(value = "/v1/app")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private JmsTemplate jmsTemplate;

    @ApiOperation(value = "Welome Message to the system")
    @GetMapping(value = "/get-hello-message", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getHelloMessage(@RequestParam("first-name") String firstName) {
        String message = firstName.isEmpty() ? " no name specified" : "hello ".concat(firstName);
        Map map = new HashMap();
        map.put("status", !message.isEmpty());
        map.put("message", message);
        LOGGER.info("getting welcome Message..");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @ApiOperation(value = "get user by their defined id")
    @GetMapping(value = "/getUserById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUserById(@PathVariable("id") int id) {
        LOGGER.info("getting User by id -> {}", id);
        TUSERS user = new TUSERS();
        Optional<TUSERS> entity = userService.getUserById(id);
        if (entity.isPresent()) {
            user = entity.get();
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete user based on their id")
    @DeleteMapping(value = "/deleteUser/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity removeUser(@PathVariable("id") int id) {
        LOGGER.info("Deleting user id -> {} ", id);
        List<TUSERS> users = userService.deleteUser(id);
        return new ResponseEntity<>(users, HttpStatus.FORBIDDEN);
    }

    @ApiOperation(value = "Update User endpoint")
    @PostMapping(value = "/updateUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUser(@RequestParam(name = "id", required = true, defaultValue = "0") int id,
            @RequestBody @Valid UserModel userModel) {
        LOGGER.info("Updating User -> {} ", userModel);
        TUSERS entity = userService.updateUser(id, userModel);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @ApiOperation(value = "Create new user endpoint")
    @PostMapping(value = "/createUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser(@RequestBody UserModel userModel) {
        LOGGER.info("Creating User -> {}", userModel);
        List<TUSERS> entity = userService.createUser(userModel);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @ApiOperation(value = "Fetch all users")
    @GetMapping(value = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllUsers() {
        LOGGER.info("Fetching Users -> ");
        List<TUSERS> entity = userService.getAllUsers();
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @ApiOperation(value = "get user by their phone nummber")
    @GetMapping(value = "/getUserByPhone/{phone}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUserByPhone(@PathVariable("phone") String phone) {
        LOGGER.info("getting User by phone number -> {}", phone);
        TUSERS user = new TUSERS();
        Optional<TUSERS> entity = userService.getUserByPhone(phone);
        if (entity.isPresent()) {
            user = entity.get();
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @ApiOperation(value = "get user by their email addresses")
    @GetMapping(value = "/getUserByEmail/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUserEmail(@PathVariable("email") String email) {
        LOGGER.info("getting User by email Address -> {} ", email);
        TUSERS user = new TUSERS();
        Optional<TUSERS> entity = userService.getUserByEmail(email);
        if (entity.isPresent()) {
            user = entity.get();
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @ApiOperation(value = "get user by their username")
    @GetMapping(value = "/getUserByUsername/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUserByUsername(@PathVariable("username") String username) {
        TUSERS user = new TUSERS();
        Optional<TUSERS> entity = userService.getUserByUsername(username);
        if (entity.isPresent()) {
            user = entity.get();
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

 /*   @Scheduled(fixedRate = 15000)
    public void getHeadValue() {
        LOGGER.info("Value: {Scheduled method...........}");
    }
*/
    @PostMapping(value = "/send", produces = MediaType.APPLICATION_JSON_VALUE)
    public void send(@RequestBody TUSERS transaction) {
        LOGGER.info("Sending a transaction.");
        jmsTemplate.convertAndSend("OrderTransactionQueue", transaction);
    }

    @PostMapping(value = "/sendMsg", produces = MediaType.APPLICATION_JSON_VALUE)
    public void sendMessage() {
        LOGGER.info("Send message from Andrew...");
        jmsTemplate.convertAndSend("Greetings", "Andrew is coming");
    }
}
