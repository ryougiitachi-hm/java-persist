package per.itachi.java.persist.hibernate.jpa.domain.vo;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVO {

    private String username;

    private LocalDateTime cdate;
}
