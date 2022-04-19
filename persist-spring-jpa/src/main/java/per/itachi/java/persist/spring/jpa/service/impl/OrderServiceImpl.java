package per.itachi.java.persist.spring.jpa.service.impl;

import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import per.itachi.java.persist.spring.jpa.domain.rdbms.Order;
import per.itachi.java.persist.spring.jpa.domain.rdbms.User;
import per.itachi.java.persist.spring.jpa.domain.vo.OrderVO;
import per.itachi.java.persist.spring.jpa.repository.rdbms.OrderRepository;
import per.itachi.java.persist.spring.jpa.repository.rdbms.UserRepository;
import per.itachi.java.persist.spring.jpa.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    @Override
    public OrderVO getOrderByOrderNbr(String orderNbr) {
        Order order = orderRepository.getOrderByOrderNbr(orderNbr);
        OrderVO orderVO = new OrderVO();
        BeanUtils.copyProperties(order, orderVO);
        BeanUtils.copyProperties(order.getUser(), orderVO);
        return orderVO;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public void createOrder(Long userId, String orderNbr) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            throw new RuntimeException("User doesn't exist. ");
        }
        Order order = new Order(orderNbr, userOptional.get());
        orderRepository.save(order);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public void createOrder(String username, String orderNbr) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (!userOptional.isPresent()) {
            throw new RuntimeException("User doesn't exist. ");
        }
        Order order = new Order(orderNbr, userOptional.get());
        orderRepository.save(order);
    }

}
