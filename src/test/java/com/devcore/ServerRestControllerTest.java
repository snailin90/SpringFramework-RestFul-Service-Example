package com.devcore;

import com.devcore.controllers.ServerController;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author sinoa
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerRestControllerTest {

    @Autowired
    private ServerController serverController;

    @Test
    public void checkServerStatus() {
        String value = serverController.pingServer();
        Assert.assertThat(value, Matchers.is("Server is Running"));
    }
}
