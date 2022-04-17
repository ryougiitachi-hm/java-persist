package per.itachi.java.persist.hibernate.jpa.service;

import per.itachi.java.persist.hibernate.jpa.domain.vo.OrderVO;

public interface OrderService {

    OrderVO getOrderByOrderNbr(String orderNbr);

    void createOrder(OrderVO orderVO);
}
