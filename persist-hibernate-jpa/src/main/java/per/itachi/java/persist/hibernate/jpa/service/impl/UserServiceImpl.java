package per.itachi.java.persist.hibernate.jpa.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.itachi.java.persist.hibernate.jpa.adapter.rdbms.UserPort;
import per.itachi.java.persist.hibernate.jpa.domain.rdbms.User;
import per.itachi.java.persist.hibernate.jpa.domain.vo.UserVO;
import per.itachi.java.persist.hibernate.jpa.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserPort userPort;

    @Override
    public UserVO getUserById(Long id) {
        User user = userPort.getUserById(id);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }

    @Override
    public UserVO getUserByUsername(String username) {
        return null;
    }

    @Override
    public void createUser(UserVO userVO) {
        userPort.createUser(userVO.getUsername());
    }
}
