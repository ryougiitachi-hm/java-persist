package per.itachi.java.persist.spring.jpa.domain.rdbms;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "T_ORDER")
@Getter
public class Order {

    /**
     * Otherwise, No default constructor for entity
     * */
    public Order() {}

    public Order(String orderNbr, User user) {
        this.orderNbr = orderNbr;
        this.user = user;
        this.cdate = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "T_ORDER")
    private Long id;

    @Column(name = "ORDER_NBR")
    private String orderNbr;

//    @Column(name = "USER_ID", insertable = false)
//    private Long userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(updatable = false)
    private LocalDateTime cdate;
}
