package per.itachi.java.persist.spring.jpa.domain.vo;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderVO {

    private String username;

    private String orderNbr;

    private LocalDateTime cdate;
}
