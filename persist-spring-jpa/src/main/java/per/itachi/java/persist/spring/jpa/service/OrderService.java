package per.itachi.java.persist.spring.jpa.service;

import per.itachi.java.persist.spring.jpa.domain.vo.OrderVO;

public interface OrderService {

    OrderVO getOrderByOrderNbr(String orderNbr);

    void createOrder(Long userId, String orderNbr);

    void createOrder(String username, String orderNbr);
}
