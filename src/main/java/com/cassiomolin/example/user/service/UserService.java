package com.cassiomolin.example.user.service;

import com.cassiomolin.example.user.domain.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 * Service that provides operations for {@link User}s.
 */
@ApplicationScoped
public class UserService {

    @Inject
    private EntityManager em;

    /**
     * Find a user by username or email.
     *
     * @param identifier
     * @return
     */
    public User findByUsername(String identifier) {
        List<User> users = em.createQuery("SELECT u FROM User u WHERE u.username = :identifier", User.class)
                .setParameter("identifier", identifier)
                .setMaxResults(1)
                .getResultList();
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    /**
     * Find all users.
     *
     * @return
     */
    public List<User> findAll() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    /**
     * Find a user by id.
     *
     * @param userId
     * @return
     */
    public Optional<User> findById(Long userId) {
        return Optional.ofNullable(em.find(User.class, userId));
    }
    
    public void deleteUser(Long identifier) {
    	em.getTransaction().begin();
    	em.createQuery("DELETE FROM User u WHERE u.id = :identifier").setParameter("identifier", identifier).executeUpdate();
    	em.getTransaction().commit();
    }
    
}
