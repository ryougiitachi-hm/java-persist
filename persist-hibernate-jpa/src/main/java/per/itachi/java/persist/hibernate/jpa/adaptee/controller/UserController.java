package per.itachi.java.persist.hibernate.jpa.adaptee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import per.itachi.java.persist.hibernate.jpa.domain.vo.UserVO;
import per.itachi.java.persist.hibernate.jpa.service.UserService;

@RestController
@RequestMapping("/jpa/hibernate")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public UserVO getUserById(@RequestParam("id") Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/users/{username}")
    public UserVO getUserByUsername(@PathVariable("username") String username) {
        return null;
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserVO userVO) {
        userService.createUser(userVO);
    }

}
