package net.javaguides.ems_backend.service;

import net.javaguides.ems_backend.dto.DepartmentDto;
import net.javaguides.ems_backend.dto.UnitDto;

import java.util.List;

public interface DepartmentService {
    //create department
    DepartmentDto createDepartment(DepartmentDto departmentDto);

    // create unit
    UnitDto createDepartment(UnitDto unitDto);

    //Get department by id
    DepartmentDto getDepartmentById(Long departmentId);

    //Get all departments
    List<DepartmentDto> getAllEmployees();

    // Get all departments
    List<DepartmentDto> getAllDepartments();

    // update departments
    DepartmentDto updateDepartmentById(Long departmentId, DepartmentDto departmentDto);

    DepartmentDto deleteDepartmentById(Long departmentId);
}
