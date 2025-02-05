package com.example.mapping1_many.demo.repo;


import com.example.mapping1_many.demo.NameAndDept;
import com.example.mapping1_many.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT name FROM employee ", nativeQuery = true)
    List<String> findAllEmployeeNames();

    @Query(value = "SELECT e.name AS empName, d.name AS deptName " +
            "FROM Employee e " +
            "JOIN Department d ON e.department_id = d.id " +
            "WHERE e.id = :empId",
            nativeQuery = true)
    NameAndDept findEmployeeAndDepartmentNames(Long empId);

}
