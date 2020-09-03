/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.co.seatec.fulltestspingboot.controller;

import ke.co.seatec.fulltestspingboot.model.UserModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author ASimiyu
 */
public class UserControllerTest {
    
    public UserControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getHelloMessage method, of class UserController.
     */
    @Test
    public void testGetHelloMessage() {
        System.out.println("getHelloMessage");
        String firstName = "";
        UserController instance = new UserController();
        ResponseEntity expResult = null;
        ResponseEntity result = instance.getHelloMessage(firstName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserById method, of class UserController.
     */
    @Test
    public void testGetUserById() {
        System.out.println("getUserById");
        int id = 0;
        UserController instance = new UserController();
        ResponseEntity expResult = null;
        ResponseEntity result = instance.getUserById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeUser method, of class UserController.
     */
    @Test
    public void testRemoveUser() {
        System.out.println("removeUser");
        int id = 0;
        UserController instance = new UserController();
        ResponseEntity expResult = null;
        ResponseEntity result = instance.removeUser(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUser method, of class UserController.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("updateUser");
        int id = 0;
        UserModel userModel = null;
        UserController instance = new UserController();
        ResponseEntity expResult = null;
        ResponseEntity result = instance.updateUser(id, userModel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createUser method, of class UserController.
     */
    @Test
    public void testCreateUser() {
        System.out.println("createUser");
        UserModel userModel = null;
        UserController instance = new UserController();
        ResponseEntity expResult = null;
        ResponseEntity result = instance.createUser(userModel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllUsers method, of class UserController.
     */
    @Test
    public void testGetAllUsers() {
        System.out.println("getAllUsers");
        UserController instance = new UserController();
        ResponseEntity expResult = null;
        ResponseEntity result = instance.getAllUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserByPhone method, of class UserController.
     */
    @Test
    public void testGetUserByPhone() {
        System.out.println("getUserByPhone");
        String phone = "";
        UserController instance = new UserController();
        ResponseEntity expResult = null;
        ResponseEntity result = instance.getUserByPhone(phone);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserEmail method, of class UserController.
     */
    @Test
    public void testGetUserEmail() {
        System.out.println("getUserEmail");
        String email = "";
        UserController instance = new UserController();
        ResponseEntity expResult = null;
        ResponseEntity result = instance.getUserEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserByUsername method, of class UserController.
     */
    @Test
    public void testGetUserByUsername() {
        System.out.println("getUserByUsername");
        String username = "";
        UserController instance = new UserController();
        ResponseEntity expResult = null;
        ResponseEntity result = instance.getUserByUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    
}
