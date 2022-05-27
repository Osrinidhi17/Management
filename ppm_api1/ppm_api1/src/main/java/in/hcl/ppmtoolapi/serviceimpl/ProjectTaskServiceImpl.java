package in.hcl.ppmtoolapi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hcl.ppmtoolapi.domain.Backlog;
import in.hcl.ppmtoolapi.domain.ProjectTask;
import in.hcl.ppmtoolapi.exception.ProjectNotFoundException;
import in.hcl.ppmtoolapi.repository.BacklogRepository;
import in.hcl.ppmtoolapi.repository.ProjectTaskRepository;
import in.hcl.ppmtoolapi.service.ProjectTaskService;
@Service
public class ProjectTaskServiceImpl implements ProjectTaskService {

	@Autowired
	private BacklogRepository backlogRepository;

	@Autowired
	private ProjectTaskRepository projectTaskRepository;

	@Override
	public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask) {
		try {
			// Exception Project not found
			// ProjectTasks to be added to a specific project , project!= null, BacklogExist
			Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier.toUpperCase());
			// Set the Backlog to projectTask
			projectTask.setBacklog(backlog);
			// We Want our project sequence to be like : IDPRO-1, IDPRO-2
			Integer backlogSequence = backlog.getPTSequence();
			// Update the backlog sequence
			backlogSequence++;
			backlog.setPTSequence(backlogSequence);
			// Add sequence to project task
			projectTask.setProjectTaskSequence(projectIdentifier + "-" + backlogSequence);// FP01-1
			projectTask.setProjectIdentifier(projectIdentifier);
			// initial priority when Priority is null
			if (projectTask.getPriority() == null) {
				projectTask.setPriority(3);
			}
			// initial status when status is null
			if (projectTask.getStatus() == null || projectTask.getStatus() == "") {
				projectTask.setStatus("TO-DO");
			}
			return projectTaskRepository.save(projectTask);
		} catch (Exception ex) {
			throw new ProjectNotFoundException("Project not Found");
		}
	}

	public ProjectTask findPTByProjectTaskSequence(String backlog_id, String projectTaskSequence) {
		return projectTaskRepository.findByProjectTaskSequence(projectTaskSequence);
	}

	@Override
	public ProjectTask findPTByProjectSequence(String backlog_id, String projectTaskSequence) {
		// Make sure that we are searching under existing backlog_id
		Backlog backlog = backlogRepository.findByProjectIdentifier(backlog_id);
		if (backlog == null) {
			throw new ProjectNotFoundException("Project with id : '" + backlog_id + "' does not exist");
		}
		ProjectTask projectTask = projectTaskRepository.findByProjectTaskSequence(projectTaskSequence);
		if (projectTask == null) {
			throw new ProjectNotFoundException("Project Task with id : '" + projectTaskSequence + "' does not exist");
		}
		return projectTask;
	}

	@Override
	public void deletePTByProjectTaskSequence(String backlog_id, String pt_id) {
		ProjectTask projectTask = findPTByProjectSequence(backlog_id, pt_id);
		Backlog backlog = projectTask.getBacklog();
		List<ProjectTask> projectTasks = backlog.getProjectTasks();
		projectTasks.remove(projectTask);
		backlogRepository.save(backlog);
		projectTaskRepository.delete(projectTask);
	}
	@Override
	public ProjectTask updateByScheduleSequence(ProjectTask updatedProjectTask, String backlog_id, String pt_id) {
		ProjectTask projectTask = projectTaskRepository.findByProjectTaskSequence(pt_id);
		projectTask = updatedProjectTask;
		return projectTaskRepository.save(projectTask);
	}

}
