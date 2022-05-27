package in.hcl.ppmtoolapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.hcl.ppmtoolapi.domain.Backlog;

@Repository
public interface BacklogRepository  extends CrudRepository<Backlog,Long>{
      
	Backlog findByProjectIdentifier(String projectIdentifier);
}
