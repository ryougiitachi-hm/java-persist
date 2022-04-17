package per.itachi.java.persist.hibernate.jpa.adapter.rdbms;

import per.itachi.java.persist.hibernate.jpa.domain.rdbms.User;

public interface UserPort {

    User getUserById(long id);

    User getUserByUsername(String username);

    void createUser(String username);
}
