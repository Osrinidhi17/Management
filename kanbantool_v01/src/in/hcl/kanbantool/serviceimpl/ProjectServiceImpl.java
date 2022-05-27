package in.hcl.kanbantool.serviceimpl;

import in.hcl.kanbantool.dao.ProjectDAO;
import in.hcl.kanbantool.daoimpl.ProjectDAOImpl;
import in.hcl.kanbantool.exception.ProjectNotFoundException;
import in.hcl.kanbantool.model.Project;
import in.hcl.kanbantool.service.ProjectService;

public class ProjectServiceImpl implements ProjectService{
	
	private ProjectDAO projectDAO;
	
	public ProjectServiceImpl() {
		projectDAO = new ProjectDAOImpl();
	}

	@Override
	public void createProject(Project project) {
		projectDAO.addProject(project);
	}

	@Override
	public void updateProject(Project project) {
		projectDAO.updateProject(project);
	}

	@Override
	public void removeProject(Long id) throws ProjectNotFoundException {
		try {
			projectDAO.deleteProject(id);
		}
		catch(ProjectNotFoundException p) {
			throw new ProjectNotFoundException(p.getMessage());
		}
	}

	@Override
	public void showAllProject() {
		projectDAO.showProject();
	}
	
	

}
