package in.hcl.ppmtoolapi.repository;

import org.springframework.data.repository.CrudRepository;
import in.hcl.ppmtoolapi.domain.ProjectTask;

public interface ProjectTaskRepository extends CrudRepository<ProjectTask,Long>{
        ProjectTask findByProjectTaskSequence(String projectTaskSequence);
}
