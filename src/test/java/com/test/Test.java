package com.test;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.springdata.Repository.TestRepository;
import com.springdata.Repository.TestRepositoryImpl;
import com.springdata.model.User;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@TransactionConfiguration(defaultRollback=false)
public class Test extends TestRepositoryImpl {

	@Autowired
	@Qualifier("testRepository")
    protected TestRepository bean;
	
	@Before
	public void setUp() throws Exception {
	}

	@org.junit.Test
	@Transactional
	public void test() {
		/*ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestRepository bean = context.getBean("testRepository",TestRepository.class);*/
		
		User user2 = new User();
		user2.setName("hahahha");
		user2.setRoles(null);
		
		bean.save(user2);
	}

}
