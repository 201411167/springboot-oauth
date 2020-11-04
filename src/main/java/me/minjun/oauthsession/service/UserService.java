package me.minjun.oauthsession.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.minjun.oauthsession.domain.SessionUser;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    @Resource
    SessionUser sessionUser;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        Map<String, Object> attributes = oAuth2User.getAttributes();
        log.info("OAuth2UserService loadUser : " + attributes.toString());

        String email = (String) attributes.get("email");
        String name = (String) attributes.get("name");

        sessionUser.setEmail(email);
        sessionUser.setName(name);

        return oAuth2User;
    }
}
