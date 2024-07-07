package com.te.loginpage.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.te.loginpage.dto.LoginDTO;
import com.te.loginpage.entity.User;

@Repository
public class LoginRepositoryimpl implements LoginRepository {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MysqlLogin");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void user() {
		entityTransaction.begin();

		User user = User.builder().password("password").userName("userName").build();
		entityManager.persist(user);

		entityTransaction.commit();

	}

	@Override
	public boolean loginRepository(String username, String password) {

		User usernames = entityManager.find(User.class, username);

		if (usernames != null) {
			return usernames.getPassword().equals(password);
		}

		return false;
	}

}
