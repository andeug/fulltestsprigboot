package ke.co.seatec.fulltestspingboot.config;

import ke.co.seatec.fulltestspingboot.serviceimpl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author ASimiyu on 8/27/20
 * @Project fulltestspingboot
 */
public class WebSecurityConfig {
    private  static final Logger LOGGER =  LoggerFactory.getLogger(WebSecurityConfig.class);
    public void printLn(){
        LOGGER.info("System.out.println");
    }
}
