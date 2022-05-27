package in.hcl.jpafinalassignment.daoimpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import in.hcl.jpafinalassignment.dao.UserDAO;
import in.hcl.jpafinalassignment.domain.Food;
import in.hcl.jpafinalassignment.domain.User;

public class UserDAOImpl implements UserDAO {

	Scanner sc = new Scanner(System.in);
	@Override
	public void addUser(User user) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		System.out.println(emf);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	@Override
	public void deleteUser(int id) {
// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(User user) {
// TODO Auto-generated method stub

	}

	@Override
	public void showUser() {
// TODO Auto-generated method stub

	}

}