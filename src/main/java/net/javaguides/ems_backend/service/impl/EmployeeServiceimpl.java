package net.javaguides.ems_backend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.ems_backend.dto.EmployeeDto;
import net.javaguides.ems_backend.entity.Employee;
import net.javaguides.ems_backend.exception.ResourceNotFound;
import net.javaguides.ems_backend.mapper.EmployeeMapper;
import net.javaguides.ems_backend.repository.EmployeeRepository;
import net.javaguides.ems_backend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceimpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    //create employee
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee saveEmployee =  employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(saveEmployee);
    }


    //Get employee by id
    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFound("Employee with id " + employeeId + " does not exist"));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    //Get all employees
    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        return employees.stream()
                .map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployeeById(Long employeeId, EmployeeDto employeeDto) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFound("Employee with id " + employeeId + " does not exist"));
        if (employeeDto.getFirstName() != null &&
                !employeeDto.getFirstName().isEmpty()) {

            employee.setFirstName(employeeDto.getFirstName());
        }

        if (employeeDto.getLastName() != null &&
                !employeeDto.getLastName().isEmpty()) {

            employee.setLastName(employeeDto.getLastName());
        }

        if (employeeDto.getEmail() != null &&
                !employeeDto.getEmail().isEmpty()) {

            employee.setEmail(employeeDto.getEmail());
        }


        Employee updatedEmployee= employeeRepository.save(employee);


        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public EmployeeDto deleteEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFound("Employee with id " + employeeId + " does not exist"));

       employeeRepository.deleteById(employeeId);


        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}
