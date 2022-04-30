package per.itachi.java.persist.spring.jpa.adaptee.controller;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.itachi.java.persist.spring.jpa.domain.vo.UserVO;
import per.itachi.java.persist.spring.jpa.service.UserService;

@RestController
@RequestMapping("/jpa/spring/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{username}")
    public UserVO getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody UserVO userVO) {
        userVO.setUsername(UUID.randomUUID().toString().replace("-", ""));
        userService.createUser(userVO);
    }
}
