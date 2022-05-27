package in.hcl.ppmtoolapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.hcl.ppmtoolapi.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long>{
         //TODO: no need to add CRUD operations over here, if any customization is required, we can customize the CRUD methods.
	 Project findByProjectIdentifier(String projectIdentifier);
	//Iterable<Project> findAll();
}
