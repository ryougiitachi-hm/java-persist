package per.itachi.java.persist.hibernate.jpa.adapter.rdbms;

import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.itachi.java.persist.hibernate.jpa.domain.rdbms.User;

/**
 * Event trx mgmt is not needed.
 * */
@Slf4j
@Component
public class UserAdapter implements UserPort {

    @Autowired
    private EntityManager entityManager;

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getUserByUsername(String username) {
//        entityManager.getCriteriaBuilder().
        return null;
    }

    @Override
    public void createUser(String username) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            User user = new User();
            user.setUsername(username);
            user.setCdate(LocalDateTime.now());
            entityManager.persist(user);
            transaction.commit();
        }
        catch (Exception e) {
            log.error("Error occured. ", e);
            transaction.rollback();
        }
    }
}
