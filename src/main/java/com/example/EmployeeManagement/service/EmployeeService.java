package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.dto.EmployeeDTO;
import com.example.EmployeeManagement.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {

    EmployeeDTO convertToDTO(Employee employee);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(Long id);
    void saveEmployee(EmployeeDTO employeeDTO);
    void deleteEmployeeById(Long id);
}
