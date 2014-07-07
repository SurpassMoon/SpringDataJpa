package com.springdata.Repository;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.springdata.model.Role;
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
	
	@Override
	public User getUserJoinRole() {
		return (User) this.em.createQuery("from User as u left outer join fetch u.roles ")
				.getResultList().get(0);
		
	}
	
	public static void main(String[] args) {
		/*ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		TestRepository bean = context.getBean("testRepository",TestRepository.class);
		Collection<User> users = bean.getAllUser();
		for (User user : users) {
			System.out.println(user.getName());
		}*/
		
		try {
			
			
			User bean = new User();
			bean.setName("lizhe");
			String property = BeanUtils.getProperty(bean, "name");
			System.out.println(property);
		} catch (IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		User user = bean.getUserJoinRole();
		for (Role role : user.getRoles()) {
			System.out.println(role.getName());
		}
		
	}
	
}
