package per.itachi.java.persist.spring.jpa.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import per.itachi.java.persist.spring.jpa.domain.rdbms.User;
import per.itachi.java.persist.spring.jpa.domain.vo.UserVO;
import per.itachi.java.persist.spring.jpa.repository.rdbms.UserRepository;
import per.itachi.java.persist.spring.jpa.service.UserService;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public UserVO getUserByUsername(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (!userOptional.isPresent()) {
            throw new RuntimeException();
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userOptional.get(), userVO);
        return userVO;
    }

    /**
     * In mysql, this row can be saved without Transactional...
     * */
    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public void createUser(UserVO userVO) {
        User user = new User();
        BeanUtils.copyProperties(userVO, user);
        user.setCdate(LocalDateTime.now());
        user = userRepository.save(user);
        log.info("User id is {}. ", user.getId());
    }
}
