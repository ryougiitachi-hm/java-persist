package per.itachi.java.persist.spring.jpa.repository.rdbms;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import per.itachi.java.persist.spring.jpa.domain.rdbms.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
