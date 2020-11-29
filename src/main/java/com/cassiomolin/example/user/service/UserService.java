package com.cassiomolin.example.user.service;

import com.cassiomolin.example.security.domain.AccountType;
import com.cassiomolin.example.security.domain.Authority;
import com.cassiomolin.example.user.domain.Account;
import com.cassiomolin.example.user.domain.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@ApplicationScoped
public class UserService {

    @Inject
    private EntityManager em;

    /**
     * 
     * @param identifier
     * @return
     */
    public User findByUserType(String identifier) {
        List<User> users = em.createQuery("SELECT u FROM User u WHERE u.userType = :identifier", User.class)
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

	public void addUser(Long userId, String userType) {
		em.getTransaction().begin();
		User user = new User();
    	user.setFirstName("a");
    	user.setLastName("b");
    	user.setPassword("c");
    	user.setUserType(userType);
    	user.setId(userId);
    	Set<Authority> authority = new HashSet<Authority>();
    	authority.add(Authority.EMP);
    	user.setAuthorities(authority);
		em.persist(user);
		em.getTransaction().commit();
	}
}
