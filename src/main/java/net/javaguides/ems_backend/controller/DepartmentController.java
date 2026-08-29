package net.javaguides.ems_backend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems_backend.dto.DepartmentDto;
import net.javaguides.ems_backend.dto.EmployeeDto;
import net.javaguides.ems_backend.dto.MessageResponse;
import net.javaguides.ems_backend.service.DepartmentService;
import net.javaguides.ems_backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDepartments = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartments, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId) {
        DepartmentDto department = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(department);
    }

    @GetMapping()
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        List<DepartmentDto> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    @PatchMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartmentById(@PathVariable("id") Long departmentId,
            @RequestBody DepartmentDto departmentDto) {
        DepartmentDto department = departmentService.updateDepartmentById(departmentId, departmentDto);
        return new ResponseEntity<>(department, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public <Object> ResponseEntity<MessageResponse> deleteDepartmentById(@PathVariable("id") Long departmentId) {
        DepartmentDto department = departmentService.deleteDepartmentById(departmentId);
        MessageResponse response = new MessageResponse(
                "Department with id " + departmentId + " has been deleted successfully");

        return ResponseEntity.ok(response);
    }

}
