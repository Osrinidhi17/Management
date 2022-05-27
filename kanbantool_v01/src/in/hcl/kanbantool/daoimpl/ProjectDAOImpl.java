package in.hcl.kanbantool.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import in.hcl.kanbantool.dao.ProjectDAO;
import in.hcl.kanbantool.exception.ProjectNotFoundException;
import in.hcl.kanbantool.model.Project;
import in.hcl.kanbantool.util.DBUtil;

public class ProjectDAOImpl implements ProjectDAO {

	DBUtil dbutil = new DBUtil();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addProject(Project project) {
		String sql = "insert into projects(projectName, projectIdentifier, description, startDate, endDate) values(?,?,?,?,?)";
		PreparedStatement pstmt = dbutil.preparedStatement(sql);	
		try { 
			pstmt.setString(1, project.getProjectName());
			pstmt.setString(2, project.getProjectIdentifier());
			pstmt.setString(3, project.getDescription());
			pstmt.setString(4, project.getStartDate());
			pstmt.setString(5, project.getEndDate());
			pstmt.execute(); 
			System.out.println("project Created Successfully");
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		finally{
			dbutil.closePreparedStatement(); 
			dbutil.closeConnection();
		}
	}

	@Override
	public void deleteProject(Long id) throws ProjectNotFoundException {
		PreparedStatement pst = dbutil.preparedStatement("delete from projects where id= ?");
		try {
			pst.setLong(1, id);
			pst.execute(); 
			System.out.println("Project deleted Successfully");
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		finally{
			dbutil.closePreparedStatement(); 
			dbutil.closeConnection();
		}
	}

	@Override
	public void updateProject(Project project) {
		PreparedStatement ptst = dbutil.preparedStatement("update projects set projectName = ?, projectIdentifier = ?, description = ?, startDate = ?, endDate = ? where id =?");
		try {
			ptst.setString(1, project.getProjectName());
			ptst.setString(2, project.getProjectIdentifier());
			ptst.setString(3, project.getDescription());
			ptst.setString(4, project.getStartDate());
			ptst.setString(5, project.getEndDate());
			ptst.setLong(6, project.getId());
			ptst.execute(); 
			System.out.println("Employee updated Successfully");
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		finally{
			dbutil.closePreparedStatement(); 
			dbutil.closeConnection();
		}
	}

	@Override
	public void showProject() {
		PreparedStatement prdst = dbutil.preparedStatement("select * from projects");
		try { 
			ResultSet rs = prdst.executeQuery();
			System.out.println("Employee record's found");
			while(rs.next()) {
				System.out.print("Project ID "+rs.getLong("id")+", ");
				System.out.print("Project Name "+rs.getString("projectName")+", ");
				System.out.print("Project Identifier "+rs.getString("projectIdentifier")+", ");
				System.out.print("Description "+rs.getString("description")+", ");
				System.out.print("Start Date "+rs.getString("startDate")+", ");
				System.out.print("End Date "+rs.getString("endDate"));
				System.out.println();
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		finally{
			dbutil.closePreparedStatement(); 
			dbutil.closeConnection();
		}
	}

}
