package me.minjun.oauthsession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;

@SpringBootApplication
public class OauthSessionApplication {

    public static void main(String[] args) {
//        SpringApplication.run(OauthSessionApplication.class, args);
        SpringApplication app = new SpringApplication(OauthSessionApplication.class);
        app.addListeners((ApplicationStartedEvent event) -> {
            System.out.println("+++++ APP STARTED +++++");
        });
        app.run(args);
    }

}
