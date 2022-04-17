package per.itachi.java.persist.hibernate.jpa.domain.rdbms;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "T_ORDER")
@Getter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "T_ORDER")
    private Long id;

    @Column(name = "ORDER_NBR")
    private String orderNbr;

    @Column(name = "USER_ID")
    private Long userId;

    @Column
    private LocalDateTime cdate;
}
