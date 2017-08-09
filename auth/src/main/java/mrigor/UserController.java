package mrigor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @RequestMapping("/user/me")
    public Principal user(Principal principal) {
        System.out.println(principal);
        return principal;
    }

    @RequestMapping("/")
    public String hello(){

        return "auth server" ;
    }
}
