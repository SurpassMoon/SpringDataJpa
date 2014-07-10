package com.springdata.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.springdata.model.Tree;

@Repository("treeRepository")
public class TreeRepositoryImpl implements TreeRepository {

	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Tree> findAll(){
		
		return em.createQuery("select distinct t from Tree as t left outer join fetch t.trees where t.tree.id = 1 and t.id =6 ").getResultList();
		
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TreeRepository bean = context.getBean("treeRepository",TreeRepository.class);
		
		List<Tree> trees = bean.findAll();
		
		for (Tree tree : trees) {
System.err.println(tree.getName());
			for (Tree tree2 : tree.getTrees()) {
				System.out.print("------");
				System.out.print(tree2.getName());
				System.out.println();
			}
		}
		
		
	}
	
}
