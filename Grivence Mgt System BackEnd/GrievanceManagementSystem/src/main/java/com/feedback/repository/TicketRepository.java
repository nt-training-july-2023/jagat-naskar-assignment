package com.feedback.repository;

import java.util.List;

import org.springframework.data.domain.AbstractPageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.feedback.entities.Department;
import com.feedback.entities.EStatus;
import com.feedback.entities.Ticket;
import com.feedback.entities.User;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

	@Query("SELECT t FROM Ticket t WHERE t.createdBy = :user")
    Page<Ticket> findByUser(@Param("user") User user, Pageable pageable);

//	SELECT * FROM Ticket WHERE dept_id =101;
//    @Query("SELECT t FROM Ticket where t.dept_id = :departmentId")
//    List<Ticket> findByDepartment(@Param("departmentId") Integer departmentId);
    
//    
//    @Query("SELECT t FROM Ticket t WHERE t.assignedDepartment = :department")
//    List<Ticket> findByDepartment(@Param("department") Department department);
	
	
//	@Query("SELECT t FROM Ticket t WHERE t.assignedDepartment = :department")
	@Query("SELECT t FROM Ticket t WHERE t.assignedDepartment = :department")
    Page<Ticket> findByDepartment(@Param("department") Department department, Pageable pageable);

    
//    @Query("SELECT t FROM Ticket t WHERE t.assignedDepartment = :department AND t.ticketStatus = :status")
//    List<Ticket> findByDepartmentAndStatus(@Param("department") Department department, @Param("status") EStatus status);

	@Query("SELECT t FROM Ticket t WHERE t.assignedDepartment = :department AND t.ticketStatus = :status")
    Page<Ticket> findByDepartmentAndStatus(@Param("department") Department department, @Param("status") EStatus status, Pageable pageable);

    
    
	Page<Ticket> findByCreatedByAndTicketStatus(User user, EStatus filterStatus, Pageable pageable);
	
	 Page<Ticket> findByTicketStatus(EStatus status, Pageable pageable);

}

