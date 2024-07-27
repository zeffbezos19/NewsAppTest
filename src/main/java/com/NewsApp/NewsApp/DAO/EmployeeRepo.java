package com.NewsApp.NewsApp.DAO;


import org.springframework.data.jpa.repository.JpaRepository;

import com.NewsApp.NewsApp.Entities.Employee;

/**
 * Repository is an interface that provides access to data in a database
 */
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}