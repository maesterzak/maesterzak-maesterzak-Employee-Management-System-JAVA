package net.javaguides.ems_backend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems_backend.dto.CreateUnitDto;
import net.javaguides.ems_backend.dto.EmployeeDto;
import net.javaguides.ems_backend.dto.MessageResponse;
import net.javaguides.ems_backend.dto.UnitDto;
import net.javaguides.ems_backend.service.DepartmentService;
import net.javaguides.ems_backend.service.EmployeeService;
import net.javaguides.ems_backend.service.UnitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/units")
public class UnitController {

    private UnitService unitService;

    @PostMapping
    public ResponseEntity<UnitDto> createUnit(@RequestBody CreateUnitDto unitDto) {
        UnitDto savedUnits = unitService.createUnit(unitDto);
        return new ResponseEntity<>(savedUnits, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UnitDto> getUnitById(@PathVariable("id") Long UnitId) {
        UnitDto unit = unitService.getUnitById(UnitId);
        return ResponseEntity.ok(unit);
    }

    @GetMapping()
    public ResponseEntity<List<UnitDto>> getAllUnits() {
        List<UnitDto> units = unitService.getAllUnits();
        return ResponseEntity.ok(units);
    }

    @PatchMapping("{id}")
    public ResponseEntity<UnitDto> updateUnitById(@PathVariable("id") Long UnitId,
                                                  @RequestBody CreateUnitDto createUnitDto) {
        UnitDto unit = unitService.updateUnitById(UnitId, createUnitDto);
        return new ResponseEntity<>(unit, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public <Object> ResponseEntity<MessageResponse> deleteUnitById(@PathVariable("id") Long UnitId) {
        UnitDto unit = unitService.deleteUnitById(UnitId);
        MessageResponse response = new MessageResponse(
                "Unit with id " + UnitId + " has been deleted successfully");

        return ResponseEntity.ok(response);
    }

}
