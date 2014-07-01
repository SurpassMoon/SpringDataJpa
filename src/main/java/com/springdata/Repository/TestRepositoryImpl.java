package com.springdata.Repository;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.springdata.model.User;


@Repository("testRepository")
public class TestRepositoryImpl implements TestRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Collection<User> getAllUser() {
		return this.em.createQuery(
				"select user from User user order by id")
				.getResultList();
		
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		TestRepository bean = context.getBean("testRepository",TestRepository.class);
		Collection<User> users = bean.getAllUser();
		for (User user : users) {
			System.out.println(user.getName());
		}
		
	}
	
}