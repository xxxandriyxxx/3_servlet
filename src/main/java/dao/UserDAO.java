package dao;

import models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserDAO {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("zxc");
    EntityManager manager = factory.createEntityManager();

    public void save(User user) {
        manager.getTransaction().begin();
        manager.persist(user);
        manager.getTransaction().commit();;

    }

    public List<User> findAll(){
        return manager.createQuery("select u from User u", User.class).getResultList();
    }

    public void close() {
        manager.close();
        factory.close();
    }
}
