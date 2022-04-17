package per.itachi.java.persist.hibernate.jpa.domain.rdbms;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "T_USER")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "T_USER")
    private Long id;

    @Column
    private String username;

    @Column
    private LocalDateTime cdate;
}
