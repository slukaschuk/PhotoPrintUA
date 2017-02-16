package ua.com.spiritus.config;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.*;


public class SecurityConfigurationTest {
    @Test
    public void testConfigereGlobal(){
        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }
}