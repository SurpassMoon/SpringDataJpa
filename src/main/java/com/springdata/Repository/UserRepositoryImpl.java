package com.springdata.Repository;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.springdata.model.Role;
import com.springdata.model.User;


@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Collection<User> getAllUser() {
		return this.em.createQuery(
				"select user from User user order by id")
				.getResultList();
		
	}
	@Override
	@Transactional
	public String save (User user) throws RuntimeException {
	  try{
		    em.persist(user);  
	    return "employee.dao保存成功";
	   }
	   catch(Exception e){
	    return "employee.dao保存出错";
	   }
		
	}
	
	
	@Override
	public User getUserJoinRole() {
		return (User) this.em.createQuery("from User as u left outer join fetch u.roles ")
				.getResultList().get(0);
		
	}
	
	public static void main (String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserRepository bean = context.getBean("userRepository",UserRepository.class);
			
			/*Collection<User> users = bean.getAllUser();
			for (User user : users) {
				System.out.println(user.getName());
			}
			
			User user = bean.getUserJoinRole();
			for (Role role : user.getRoles()) {
				System.out.println(role.getName());
			}
			
			User user2 = new User();
			user2.setName("hahahha");
			user2.setRoles(null);
			bean.save(user2);
			System.out.println(user2.getId());*/
			bean.getAllUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
