package in.hcl.jpafinalassignment.daoimpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		for(Food f : user.getFoods()) {
			em.persist(f);
		}
		em.persist(user);
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	@Override
	public void deleteUser(int id)  {
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

// @Override
// public void deleteUser(int id) throws UserNotFoundException {
// PreparedStatement pst = dbutil.preparedStatement("delete from projects where id= ?");
// try {
// pst.setLong(1, id);
// pst.execute();
// System.out.println("Project deleted Successfully");
// }
// catch(SQLException ex) {
// System.out.println(ex.getMessage());
// }
// finally{
// dbutil.closePreparedStatement();
// dbutil.closeConnection();
// }
// }
//
// @Override
// public void updateUser(User user) {
// PreparedStatement ptst = dbutil.preparedStatement("update projects set projectName = ?, projectIdentifier = ?, description = ?, startDate = ?, endDate = ? where id =?");
// try {
// ptst.setString(1, project.getProjectName());
// ptst.setString(2, project.getProjectIdentifier());
// ptst.setString(3, project.getDescription());
// ptst.setString(4, project.getStartDate());
// ptst.setString(5, project.getEndDate());
// ptst.setLong(6, project.getId());
// ptst.execute();
// System.out.println("Employee updated Successfully");
// }
// catch(SQLException ex) {
// System.out.println(ex.getMessage());
// }
// finally{
// dbutil.closePreparedStatement();
// dbutil.closeConnection();
// }
// }
//
// @Override
// public void showUser() {
// PreparedStatement prdst = dbutil.preparedStatement("select * from projects");
// try {
// ResultSet rs = prdst.executeQuery();
// System.out.println("Employee record's found");
// while(rs.next()) {
// System.out.print("Project ID "+rs.getLong("id")+", ");
// System.out.print("Project Name "+rs.getString("projectName")+", ");
// System.out.print("Project Identifier "+rs.getString("projectIdentifier")+", ");
// System.out.print("Description "+rs.getString("description")+", ");
// System.out.print("Start Date "+rs.getString("startDate")+", ");
// System.out.print("End Date "+rs.getString("endDate"));
// System.out.println();
// }
// }
// catch(SQLException ex) {
// System.out.println(ex.getMessage());
// }
// finally{
// dbutil.closePreparedStatement();
// dbutil.closeConnection();
// }
// }
// }

}