package com.example.employeermanager.services;

import com.example.employeermanager.exceptions.UserNotFoundException;
import com.example.employeermanager.models.Employee;
import com.example.employeermanager.models.JobTitle;
import com.example.employeermanager.repo.EmployeeRepo;
import com.example.employeermanager.repo.JobTitleRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final JobTitleRepo jobTitleRepo;

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
//        JobTitle byId = jobTitleRepo
//                .findById(Long.parseLong(employee.getJobTitle().getName()))
//                .orElseThrow(() -> new IllegalArgumentException("NOT FOUND"));
//        employee.setJobTitle(byId);
        return employeeRepo.save(employee);
    }

    @Transactional
    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findById(id).orElseThrow(() -> new UserNotFoundException("not found by id " + id));
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
}
