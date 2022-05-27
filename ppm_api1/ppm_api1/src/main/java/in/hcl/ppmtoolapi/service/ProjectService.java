package in.hcl.ppmtoolapi.service;

import in.hcl.ppmtoolapi.domain.Project;

public interface ProjectService {

	public Project saveOrUpdate(Project project);
	public Project findProjectByIdentifier(String projectId);
	public Iterable<Project> findAllProject();
	public void deleteProjectByProjectIdentifier(String projectId);

}
