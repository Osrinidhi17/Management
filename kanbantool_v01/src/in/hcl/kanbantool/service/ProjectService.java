package in.hcl.kanbantool.service;

import in.hcl.kanbantool.exception.ProjectNotFoundException;
import in.hcl.kanbantool.model.Project;

public interface ProjectService {
	
	void createProject(Project project);
	void updateProject(Project project);
	void removeProject(Long id) throws ProjectNotFoundException;
	void showAllProject();
}
