package in.hcl.ppmtoolapi.service;

import in.hcl.ppmtoolapi.domain.ProjectTask;

public interface ProjectTaskService {
	
  ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask);
  ProjectTask findPTByProjectSequence(String backlog_id, String projectTaskSeqeunce);
  void deletePTByProjectTaskSequence(String backlog_id, String pt_id);
  public ProjectTask updateByScheduleSequence(ProjectTask updatedProjectTask, String backlog_id, String pt_id);


  }
