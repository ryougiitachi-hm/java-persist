package per.itachi.java.persist.spring.jpa.domain.vo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserVO {

    private String username;

    private LocalDateTime cdate;
}
