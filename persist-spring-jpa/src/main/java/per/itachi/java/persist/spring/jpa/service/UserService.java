package per.itachi.java.persist.spring.jpa.service;

import per.itachi.java.persist.spring.jpa.domain.vo.UserVO;

public interface UserService {

    UserVO getUserByUsername(String username);

    void createUser(UserVO userVO);
}
