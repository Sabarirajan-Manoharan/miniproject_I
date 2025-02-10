package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.dto.EmployeeDTO;
import com.example.EmployeeManagement.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Tag(
        name="CRUD API's for User Resource",
        description = "CRUD API's for User Resources"
)

@Controller
@AllArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Operation(
            summary="Creating entry to the database table",
            description="insert employee first, lastname and email"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )
    @GetMapping("/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new EmployeeDTO());
        return "employee-add";

    }

    @Operation(
            summary="Get list",
            description="List of user's from database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )
    @GetMapping
    public String listEmployees(Model model) {

        List<EmployeeDTO> employeeDTOS = employeeService.getAllEmployees();
        model.addAttribute("employeeDTOS", employeeDTOS);
        return "employee-list";
    }

    @Operation(
            summary="Insert",
            description="Insert employee first, lastname and email"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )
    @PostMapping
    public String saveEmployee(@ModelAttribute("employeeDTO") EmployeeDTO employeeDTO) {
        employeeService.saveEmployee(employeeDTO);
        return "redirect:/employees?success";
    }

    @Operation(
            summary="Update or Edit",
            description="Update or Edit employee first, lastname and email using ID"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )
    @GetMapping("/edit/{id}")
    public String showEditEmployeeForm(@PathVariable("id") Long id, Model model) {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employeeDTO);
        return "employee-form";
    }

    @Operation(
            summary="Delete",
            description="Delete employee first, lastname and email using ID"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }

    @Operation(
            summary="Delete",
            description="view employee first, lastname and email using ID"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )
    @GetMapping("/view/{id}")
    public String viewEmployee(@PathVariable("id") Long id, Model model) {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employeeDTO);
        return "employee-view";
    }

}
