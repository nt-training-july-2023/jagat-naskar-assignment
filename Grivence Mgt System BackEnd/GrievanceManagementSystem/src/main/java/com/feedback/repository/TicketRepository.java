package com.feedback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.feedback.entities.Department;
import com.feedback.entities.Ticket;
import com.feedback.entities.User;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

	@Query("SELECT t FROM Ticket t WHERE t.createdBy = :user")
    List<Ticket> findByUser(@Param("user") User user);

//	SELECT * FROM Ticket WHERE dept_id =101;
//    @Query("SELECT t FROM Ticket where t.dept_id = :departmentId")
//    List<Ticket> findByDepartment(@Param("departmentId") Integer departmentId);
    
//    
    @Query("SELECT t FROM Ticket t WHERE t.assignedDepartment = :department")
    List<Ticket> findByDepartment(@Param("department") Department department);


}

