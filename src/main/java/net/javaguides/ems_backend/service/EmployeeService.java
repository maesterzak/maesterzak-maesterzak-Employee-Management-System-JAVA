package net.javaguides.ems_backend.service;

import net.javaguides.ems_backend.dto.CreateEmployeeDto;
import net.javaguides.ems_backend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(CreateEmployeeDto createEmployeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployeeById(Long employeeId, CreateEmployeeDto createEmployeeDto);


    EmployeeDto deleteEmployeeById(Long employeeId);
}
