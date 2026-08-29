package net.javaguides.ems_backend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.ems_backend.dto.DepartmentDto;
import net.javaguides.ems_backend.dto.UnitDto;
import net.javaguides.ems_backend.entity.Department;
import net.javaguides.ems_backend.exception.ResourceNotFound;
import net.javaguides.ems_backend.mapper.DepartmentMapper;
import net.javaguides.ems_backend.repository.DepartmentRepository;
import net.javaguides.ems_backend.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceimp implements DepartmentService {
    private DepartmentRepository departmentRepository;

    // create department
    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {

        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department saveDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(saveDepartment);
    }

    @Override
    public UnitDto createDepartment(UnitDto unitDto) {
        return null;
    }

    // Get department by id
    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFound("Department with id " + departmentId + " does not exist"));

        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllEmployees() {
        return List.of();
    }

    // Get all departments
    @Override
    public List<DepartmentDto> getAllDepartments() {

        List<Department> departments = departmentRepository.findAll();

        return departments.stream()
                .map(DepartmentMapper::mapToDepartmentDto)
                .collect(Collectors.toList());
    }

    // update departments
    @Override
    public DepartmentDto updateDepartmentById(Long departmentId, DepartmentDto departmentDto) {

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFound("Department with id " + departmentId + " does not exist"));
        if (departmentDto.getName() != null &&
                !departmentDto.getName().isEmpty()) {

            department.setName(departmentDto.getName());
        }

        if (departmentDto.getDescription() != null &&
                !departmentDto.getDescription().isEmpty()) {

            department.setDescription(departmentDto.getDescription());
        }

        Department updatedDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(updatedDepartment);
    }

    @Override
    public DepartmentDto deleteDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFound("Department with id " + departmentId + " does not exist"));

        departmentRepository.deleteById(departmentId);

        return DepartmentMapper.mapToDepartmentDto(department);
    }
}
