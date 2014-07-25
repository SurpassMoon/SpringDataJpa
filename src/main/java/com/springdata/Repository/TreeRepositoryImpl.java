package com.springdata.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		
//		将二级菜单放到一级菜单里面 
//		二级菜单的Pid==一级菜单的id
		
		List<Tree> trees = em.createQuery("from Tree").getResultList();
		
		List<Tree> list = new ArrayList<Tree>();
		for (int i = 0; i < trees.size(); i++) {
			if (trees.get(i).getLevel()==1) {//判断等级是否为1
				Set<Tree> set = new HashSet<Tree>();
				for (int j = 0; j < trees.size(); j++) {
					if (trees.get(j).getTree()!=null) {//判断没有父节点的时候 不能执行
						if (trees.get(i).getId()==(trees.get(j).getTree().getId())) { //当i的id和j的pid相等的时候添加入集合
							set.add(trees.get(j));
						}
					}
				}
				trees.get(i).setTrees(new ArrayList<Tree>(set));
				list.add(trees.get(i));
			}
		}
		
		
//		List list = em.createQuery("select distinct t from Tree as t left outer join fetch t.trees where t.id = 1 ").getResultList();
		return list;
		
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
