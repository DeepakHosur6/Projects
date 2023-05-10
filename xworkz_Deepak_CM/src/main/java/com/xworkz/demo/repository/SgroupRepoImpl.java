package com.xworkz.demo.repository;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.demo.entity.SgroupEntity;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class SgroupRepoImpl implements SgroupRepo {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public boolean save(SgroupEntity entity) {
	//	log.info("Running save() method at SgroupRepoImpl :" + entity);
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(entity);
			transaction.commit();
			return true;
		} finally {
			manager.close();
		}

	}

	@Override
	public List<SgroupEntity> findAll() {
	//	log.info("Running findAll() method at SgroupRepoImpl :");
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("find");
			List<SgroupEntity> list = query.getResultList();
			log.info("Total list size in Repository " + list.size());
			return list;
		} finally {
			manager.close();
		}
	}

	@Override
	public Long findByEmail(String email) {
	//	log.info("Running findByEmail() method at SgroupRepoImpl :");
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("emailId");
			query.setParameter("emailBy", email);
			Object object = query.getSingleResult();
			Long value = (Long) object;
			log.info(""+value);
			return value;
		} finally {
			manager.close();
		}
	}

	@Override
	public Long findByUser(String user) {
	//	log.info("Running findByUser() method at SgroupRepoImpl :");
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("userId");
			query.setParameter("userBy", user);
			Object object = query.getSingleResult();
			Long value = (Long) object;
			log.info(""+value);
			return value;
		} finally {
			manager.close();
		}
	}

	@Override
	public Long findByMobile(Long mobile) {
//		log.info("Running findByUser() method at SgroupRepoImpl :");
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("mobileId");
			query.setParameter("mobileBy", mobile);
			Object object = query.getSingleResult();
			Long value = (Long) object;
			log.info(""+value);
			return value;
		} finally {
			manager.close();
		}
	}

	@Override
	public SgroupEntity userSignIn(String userId) {
	//	log.info("Running userSignIn() method at SgroupRepoImpl :"+userId);
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("userANDpassword");
			query.setParameter("ui", userId);
			// query.setParameter("pwd", password);
			Object object = query.getSingleResult();
			SgroupEntity entity = (SgroupEntity) object;
			log.info("" + entity);
			return entity;
		} finally {
			manager.close();
		}
	}

	@Override
	public boolean logincount(String userId, int count) {
	//	log.info("Running logincount() method at SgroupRepoImpl :");
		log.info("Count -->: " + count);
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {

			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Query query = manager.createNamedQuery("updateLoginCount");
			query.setParameter("ui", userId);
			query.setParameter("count", count);
			query.executeUpdate();
			transaction.commit();
			return true;
		} finally {
			manager.close();
		}
	}

	@Override
	public boolean update(SgroupEntity entity) {
	//	log.info("Running update() method at SgroupRepoImpl :");
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {

			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.merge(entity);
			transaction.commit();
			return true;
		} finally {
			manager.close();
		}
	}

	@Override
	public SgroupEntity reSetPassword(String email) {
	//	log.info("Running reSetPassword() method at SgroupRepoImpl :");
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {

			Query query = manager.createNamedQuery("emailid");
			query.setParameter("ei", email);
			Object object = query.getSingleResult();
			SgroupEntity entity = (SgroupEntity) object;
			log.info("" + entity);
			return entity;
		} finally {
			manager.close();
		}
	}

	@Override
	public boolean updatePassword(String userId, String password, Boolean resetPassword,
			LocalTime passwordChangedTime) {
	//	log.info("Running updatePassword() method at SgroupRepoImpl :");
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {

			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Query query = manager.createNamedQuery("updatePassword");
			query.setParameter("uu", userId);
			query.setParameter("up", password);
			query.setParameter("urp", resetPassword);
			query.setParameter("pct", passwordChangedTime);
			query.executeUpdate();
			return true;
		} finally {
			manager.close();
		}
	}

}