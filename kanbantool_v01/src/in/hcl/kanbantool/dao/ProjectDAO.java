package in.hcl.kanbantool.dao;

import in.hcl.kanbantool.exception.ProjectNotFoundException;
import in.hcl.kanbantool.model.Project;

public interface ProjectDAO {
	
	void addProject(Project project);
	void deleteProject(Long id)throws ProjectNotFoundException;
	void updateProject(Project project);
	void showProject();
}
