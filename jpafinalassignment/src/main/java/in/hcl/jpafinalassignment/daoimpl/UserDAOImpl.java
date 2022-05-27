package in.hcl.jpafinalassignment.daoimpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import in.hcl.jpafinalassignment.dao.UserDAO;
import in.hcl.jpafinalassignment.domain.Food;
import in.hcl.jpafinalassignment.domain.User;
import in.hcl.jpafinalassignment.exception.UserNotFoundException;

public class UserDAOImpl implements UserDAO {

	Scanner sc = new Scanner(System.in);

	@Override
	public void addUser(User user) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		System.out.println(emf);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.persist(user.getFood());
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	@Override
	public void deleteUser(int id) throws UserNotFoundException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		System.out.println(emf);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		User user = em.find(User.class, id);		
		em.remove(user);
		em.remove(user.getFood());
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	@Override
	public void updateUser(User user1) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		System.out.println(emf);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		User user = em.find(User.class, user1.getId());	
		Food food = em.find(Food.class, user.getFood().getId());
		user1.getFood().setId(user.getFood().getId());		
		user.setName(user1.getName());
		user.setMob(user1.getMob());
		user.setOrderId(user1.getOrderId());
		user.setAddr(user1.getAddr());
		user.setFood(user1.getFood());		
		food.setName(user1.getFood().getName());
		food.setCost(user1.getFood().getCost());
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	@Override
	public void showUser() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		System.out.println(emf);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("from User");
		List<User> user = q.getResultList();
		for(User u : user) {
			System.out.println("UserOrder [userId=" + u.getId() + ", userNamame=" + u.getName() + ", "
					+ "foodId=" + u.getFood().getId() + ", foodName=" + u.getFood().getName() + ", foodCost=" + u.getFood().getCost() + "]");
		}
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	}






