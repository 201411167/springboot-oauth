package me.minjun.oauthsession.controller;

import me.minjun.oauthsession.domain.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserApiController {

    @Autowired
    SessionUser sessionUser;

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @GetMapping("/oauth")
    public String oauth2(){
        return "OAuth2 finished";
    }

    @GetMapping("/session")
    public String sessionInfo(){
        return sessionUser.getEmail();
    }
}
