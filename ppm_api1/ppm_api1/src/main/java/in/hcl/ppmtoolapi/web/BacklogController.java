package in.hcl.ppmtoolapi.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.hcl.ppmtoolapi.domain.ProjectTask;
import in.hcl.ppmtoolapi.service.ProjectTaskService;
import in.hcl.ppmtoolapi.serviceimpl.MapValidationErrorService;

@RestController
@RequestMapping("/api/backlog")
public class BacklogController {
	@Autowired(required = false)
	private ProjectTaskService projectTaskService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("/{backlog_id}")
	public ResponseEntity<?> addPTtoBacklog(@Valid @RequestBody ProjectTask projectTask, BindingResult result,
			@PathVariable String backlog_id){
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		ProjectTask createdProjectTask = projectTaskService.addProjectTask(backlog_id, projectTask);
		return new ResponseEntity<ProjectTask>(createdProjectTask, HttpStatus.CREATED);
	}
	
	@GetMapping("/{backlog_id}/{pt_id}")
	public ResponseEntity<?> getProjectTask(@PathVariable String backlog_id , @PathVariable String pt_id){
		ProjectTask projectTask = projectTaskService.findPTByProjectSequence(backlog_id, pt_id);
		return new ResponseEntity<ProjectTask>(projectTask, HttpStatus.OK);
	}
   @DeleteMapping("/{backlog_id}/{pt_id}")
   public ResponseEntity<?> deleteProjectTask(@PathVariable String backlog_id,@PathVariable String pt_id){
	  projectTaskService.deletePTByProjectTaskSequence(backlog_id, pt_id);
	  return new ResponseEntity<String>("Project Task '"+pt_id+"'deleted successfully!", HttpStatus.OK);
   }
	@PatchMapping("/{backlog_id}/{pt_id}")
	public ResponseEntity<?> updateSchedule(@RequestBody ProjectTask updatedProjectTask, @PathVariable String backlog_id, @PathVariable String pt_id, BindingResult result){
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		ProjectTask updatedProjtask = projectTaskService.updateByScheduleSequence(updatedProjectTask, backlog_id, pt_id);
		return new ResponseEntity<ProjectTask>(updatedProjtask,HttpStatus.OK); 
	}
}