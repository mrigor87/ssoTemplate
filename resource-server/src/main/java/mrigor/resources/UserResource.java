package mrigor.resources;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController

public class UserResource {

    @RequestMapping("/me")
    public Principal user(Principal user) {
        return user;
    }
}
