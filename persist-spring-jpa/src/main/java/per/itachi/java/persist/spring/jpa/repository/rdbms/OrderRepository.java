package per.itachi.java.persist.spring.jpa.repository.rdbms;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import per.itachi.java.persist.spring.jpa.domain.rdbms.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @EntityGraph(value = "order.user", type = EntityGraph.EntityGraphType.FETCH)
    Order getOrderByOrderNbr(String orderNbr);// left join
}
