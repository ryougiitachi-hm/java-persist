package per.itachi.java.persist.spring.jpa.adaptee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.itachi.java.persist.spring.jpa.domain.vo.OrderVO;
import per.itachi.java.persist.spring.jpa.service.OrderService;

@RestController
@RequestMapping("/jpa/spring/v1")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders/{orderNbr}")
    public OrderVO getOrderByOrderNbr(@PathVariable String orderNbr) {
        return orderService.getOrderByOrderNbr(orderNbr);
    }

    @PostMapping("/orders")
    public void createOrder(@RequestBody OrderVO orderVO) {
        orderService.createOrder(orderVO.getUsername(), orderVO.getOrderNbr());
    }
}
