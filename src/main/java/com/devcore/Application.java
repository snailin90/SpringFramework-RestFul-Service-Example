package com.devcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 *
 * @author Snailin Inoa
 * 
 * //{@EnableJpaAuditing} when this annotation is set correctly ,all the entities that have [@EntityListeners] will work.   
 */
@SpringBootApplication
@EnableJpaAuditing 
public class Application {

    public static void main(String args[]) {

        SpringApplication.run(Application.class, args);
    }
}
