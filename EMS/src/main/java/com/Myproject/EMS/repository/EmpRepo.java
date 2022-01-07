 package com.Myproject.EMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Myproject.EMS.entity.Employee;
@Repository
public interface EmpRepo  extends JpaRepository<Employee,Integer>{

}
