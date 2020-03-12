package com;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GameDao {
	
	@Autowired
	EntityManagerFactory emf;
	public void add(Input i)
	{
		
		System.out.println("Adding to Database");
		EntityManager manager=emf.createEntityManager();
		Query qry=manager.createNativeQuery("insert into Input(inp,t) values(:abc,:ret)");
		qry.setParameter("abc", i.getInp());
		qry.setParameter("ret", i.getT());
		manager.getTransaction().begin();
		qry.executeUpdate();
		manager.getTransaction().commit();
		System.out.println("Finished");
		System.out.println("Input"+i.getS()+" Time :"+i.getT());
		
	}

}
