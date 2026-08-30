package net.javaguides.ems_backend.controller;


import lombok.AllArgsConstructor;
import net.javaguides.ems_backend.dto.CreateEmployeeDto;
import net.javaguides.ems_backend.dto.EmployeeDto;
import net.javaguides.ems_backend.dto.MessageResponse;
import net.javaguides.ems_backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody CreateEmployeeDto employeeDto){
        EmployeeDto savedEmployees = employeeService.createEmployee(employeeDto);
        return  new ResponseEntity<>(savedEmployees, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDto employee = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employee);
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employees =  employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PatchMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(@PathVariable("id") Long employeeId, @RequestBody CreateEmployeeDto createEmployeeDto) {
        EmployeeDto employee = employeeService.updateEmployeeById(employeeId, createEmployeeDto);
        return new ResponseEntity<>(employee, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public <Object> ResponseEntity<MessageResponse> deleteEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDto employee = employeeService.deleteEmployeeById(employeeId);
        MessageResponse response = new MessageResponse(
                "Employee with id " + employeeId + " has been deleted successfully"
        );

        return ResponseEntity.ok(response);
    }

}
