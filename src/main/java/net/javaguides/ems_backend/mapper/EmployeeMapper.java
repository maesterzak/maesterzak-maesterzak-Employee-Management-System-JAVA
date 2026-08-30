package net.javaguides.ems_backend.mapper;

import net.javaguides.ems_backend.dto.CreateEmployeeDto;
import net.javaguides.ems_backend.dto.EmployeeDto;
import net.javaguides.ems_backend.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                UnitMapper.mapToUnitDto(employee.getUnit())

        );
    }

//    public static Employee mapToEmployee(EmployeeDto employeeDto) {
//        return new Employee(
//                employeeDto.getId(),
//                employeeDto.getFirstName(),
//                employeeDto.getLastName(),
//                employeeDto.getEmail(),
//                employeeDto.getUnit()
//
//        );
//    }

    public static Employee mapToEmployee(CreateEmployeeDto employeeDto) {
        return new Employee(

                null,
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                null


        );
    }
}
