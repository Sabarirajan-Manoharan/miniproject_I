package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Modifying
    @Query(value = "update employee e set e.first_name = ?1, e.last_name = ?2,e.email_id=?3 where e.id = ?4", nativeQuery = true)
    void setUserInfoById(String firstName, String lastName,String emailId, Long id);
}
