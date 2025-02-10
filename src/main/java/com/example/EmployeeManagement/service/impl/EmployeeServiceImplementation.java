package com.example.EmployeeManagement.service.impl;

import com.example.EmployeeManagement.dto.EmployeeDTO;
import com.example.EmployeeManagement.entity.Employee;
import com.example.EmployeeManagement.repository.EmployeeRepository;
import com.example.EmployeeManagement.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImplementation implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    @Override
    public EmployeeDTO convertToDTO(Employee employee) {
        return null;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream().map(employee -> modelMapper.map(employee, EmployeeDTO.class)).toList();
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .orElse(null);
    }

    @Transactional
    @Override
    public void saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee= modelMapper.map(employeeDTO, Employee.class);
//        if (employee.getId()!=null && employeeRepository.existsById(employee.getId())){
          if (employee.getId()!=null){
//            Employee existingEmployee = employeeRepository.findById(employee.getId()).orElseThrow(() ->
//                    new RuntimeException("Employee not found with id: " + employee.getId()));
//            existingEmployee.setFirstName(employee.getFirstName());
//            existingEmployee.setLastName(employee.getLastName());
//            existingEmployee.setEmailId(employee.getEmailId());
              employeeRepository.setUserInfoById(employee.getFirstName(), employee.getLastName(), employee.getEmailId(), employee.getId());
              System.out.println(employee.getFirstName().toString());
        }else{
            employeeRepository.save(employee);
        }

    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}
