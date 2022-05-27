package in.hcl.user_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.hcl.user_management.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>,JpaRepository<User, Long> {
}
