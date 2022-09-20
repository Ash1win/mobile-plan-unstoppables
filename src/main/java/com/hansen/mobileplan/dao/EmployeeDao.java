package com.hansen.mobileplan.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.hansen.mobileplan.model.Employee;

public interface EmployeeDao extends PagingAndSortingRepository<Employee, Long> {

}
