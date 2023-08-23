package com.feedback.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.feedback.entities.User;

/**
 * User repo for connecting the user table from the database
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	String qu="SELECT * from users where user_name =:userName";
	@Query(value = qu,nativeQuery = true)
	User getUserByUsername(@Param("userName") String userName);
}
