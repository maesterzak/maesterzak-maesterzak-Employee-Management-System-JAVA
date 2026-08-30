package net.javaguides.ems_backend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.ems_backend.dto.CreateEmployeeDto;
import net.javaguides.ems_backend.dto.EmployeeDto;
import net.javaguides.ems_backend.entity.Employee;
import net.javaguides.ems_backend.entity.Unit;
import net.javaguides.ems_backend.exception.ResourceNotFound;
import net.javaguides.ems_backend.mapper.EmployeeMapper;
import net.javaguides.ems_backend.repository.EmployeeRepository;
import net.javaguides.ems_backend.repository.UnitRepository;
import net.javaguides.ems_backend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceimpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private UnitRepository unitRepository;


    //create employee
    @Override
    public EmployeeDto createEmployee(CreateEmployeeDto createEmployeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(createEmployeeDto);
        Unit unit = unitRepository.findById(createEmployeeDto.getUnitId())
                .orElseThrow(() ->
                        new ResourceNotFound("Unit not found"));

        employee.setUnit(unit);
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
    public EmployeeDto updateEmployeeById(Long employeeId, CreateEmployeeDto createEmployeeDto) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFound("Employee with id " + employeeId + " does not exist"));
        if (createEmployeeDto.getFirstName() != null &&
                !createEmployeeDto.getFirstName().isEmpty()) {

            employee.setFirstName(createEmployeeDto.getFirstName());
        }

        if (createEmployeeDto.getLastName() != null &&
                !createEmployeeDto.getLastName().isEmpty()) {

            employee.setLastName(createEmployeeDto.getLastName());
        }

        if (createEmployeeDto.getEmail() != null &&
                !createEmployeeDto.getEmail().isEmpty()) {

            employee.setEmail(createEmployeeDto.getEmail());
        }

        if (createEmployeeDto.getUnitId() != null ) {

            Unit unit = unitRepository.findById(createEmployeeDto.getUnitId())
                    .orElseThrow(() ->
                            new ResourceNotFound("Unit not found"));

            employee.setUnit(unit);
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
