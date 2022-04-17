package per.itachi.java.persist.hibernate.jpa.service;

import per.itachi.java.persist.hibernate.jpa.domain.vo.UserVO;

/**
 * Service layer should return VO object?
 * */
public interface UserService {

    UserVO getUserById(Long id);

    UserVO getUserByUsername(String username);

    void createUser(UserVO userVO);
}
