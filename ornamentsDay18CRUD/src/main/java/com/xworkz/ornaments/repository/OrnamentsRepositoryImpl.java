package com.xworkz.ornaments.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.ornaments.entity.OrnamentsEntity;

@Repository
public class OrnamentsRepositoryImpl implements OrnamentsRepository {

	@Autowired
	private EntityManagerFactory entity;

	@Override
	public boolean save(OrnamentsEntity entity) {
		System.out.println("Inside the save method in OrnamentsRepositoryImpl () ");
		EntityManager em = this.entity.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(entity); 
		et.commit();
		em.close();
		return true;
	}

	@Override
	public OrnamentsEntity findById(int id) {
		System.out.println("Find by Id in Repository : " + id);
		EntityManager entityManager = this.entity.createEntityManager();
		OrnamentsEntity entity = entityManager.find(OrnamentsEntity.class, id);

		entityManager.clear();
		return entity;
	}

	@Override
	public List<OrnamentsEntity> findByName(String name) {
		System.out.println(" Running findByName in Repository");

		EntityManager manager = this.entity.createEntityManager();
		// Decide : 1)Transaction , 2) Query ?
		try {
			Query query = manager.createNamedQuery("findByName");
			query.setParameter("nam", name);
			System.out.println("query : " + query);
			List<OrnamentsEntity> list = query.getResultList();
			System.out.println("Total list found in Repository is : " + list.size());
			return list;
		} finally {
			manager.close();
			System.out.println("Released the Connection by close() in finally block");
		}

	}

	@Override
	public boolean update(OrnamentsEntity entity) {
		System.out.println(" Running Update in Repository");
		EntityManager manager = this.entity.createEntityManager();
		// Decide transaction
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.merge(entity); // new for update we use merge
			transaction.commit();
			return true;
		} finally {
			manager.close();
		}

	}

	/*
	 * @Override public OrnamentsEntity deleteById(int id) {
	 * System.out.println("Running delete by id:" + id); EntityManager manager =
	 * this.entity.createEntityManager();
	 * 
	 * OrnamentsEntity entity = manager.find(OrnamentsEntity.class, id);
	 * manager.remove(entity); EntityManager manager2 =
	 * this.entity.createEntityManager(); EntityTransaction transaction =
	 * manager.getTransaction(); OrnamentsEntity delete =
	 * manager.find(OrnamentsEntity.class, id); transaction.begin();
	 * manager.remove(delete); transaction.commit(); manager.close();
	 * 
	 * return entity; return delete; }
	 */

	@Override
	public OrnamentsEntity deleteById(int id) {
		System.out.println("Running delete by id:" + id);
		EntityManager manager = this.entity.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			OrnamentsEntity manager2 = manager.find(OrnamentsEntity.class, id);
			transaction.begin();
			manager.remove(manager2);
			transaction.commit();
			return manager2;
		} finally {
			manager.close();
		}
	}
	/*
	 * @Override public boolean onDelete(int id) {
	 * System.out.println(" Running Delete in Repository"); EntityManager manager =
	 * this.entity.createEntityManager(); // Decide transaction try {
	 * EntityTransaction transaction = manager.getTransaction(); if (entity!= null)
	 * { transaction.begin(); manager.merge(entity); // new for update we use merge
	 * transaction.commit(); //return true; } else {
	 * System.err.println("Data is not Deleted"); } return true; } finally {
	 * manager.close(); }
	 * 
	 * }
	 */
}
