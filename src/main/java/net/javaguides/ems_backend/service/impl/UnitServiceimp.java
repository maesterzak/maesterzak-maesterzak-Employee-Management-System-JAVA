package net.javaguides.ems_backend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.ems_backend.dto.CreateUnitDto;
import net.javaguides.ems_backend.dto.UnitDto;
import net.javaguides.ems_backend.entity.Department;
import net.javaguides.ems_backend.entity.Unit;
import net.javaguides.ems_backend.exception.ResourceNotFound;
import net.javaguides.ems_backend.mapper.UnitMapper;
import net.javaguides.ems_backend.repository.DepartmentRepository;
import net.javaguides.ems_backend.repository.UnitRepository;
import net.javaguides.ems_backend.service.UnitService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UnitServiceimp implements UnitService {
    private UnitRepository unitRepository;
    private DepartmentRepository departmentRepository;


    // create unit
    @Override
    public UnitDto createUnit(CreateUnitDto createUnitDto) {

        Unit unitInp = UnitMapper.mapToUnit(createUnitDto);
        Department department = departmentRepository.findById(createUnitDto.getDepartmentId())
                .orElseThrow(() ->
                        new ResourceNotFound("Department not found"));

        unitInp.setDepartment(department);
        Unit saveUnit = unitRepository.save(unitInp);

        return UnitMapper.mapToUnitDto(saveUnit);
    }

    // Get unit by id
    @Override
    public UnitDto getUnitById(Long unitId) {
        Unit unit = unitRepository.findById(unitId)
                .orElseThrow(() -> new ResourceNotFound("Unit with id " + unitId + " does not exist"));

        return UnitMapper.mapToUnitDto(unit);
    }

    // Get all units
    @Override
    public List<UnitDto> getAllUnits() {

        List<Unit> units = unitRepository.findAll();

        return units.stream()
                .map(UnitMapper::mapToUnitDto)
                .collect(Collectors.toList());
    }

    // update units
    @Override
    public UnitDto updateUnitById(Long unitId, CreateUnitDto createUnitDto) {

        Unit unit = unitRepository.findById(unitId)
                .orElseThrow(() -> new ResourceNotFound("Unit with id " + unitId + " does not exist"));
        if (createUnitDto.getName() != null &&
                !createUnitDto.getName().isEmpty()) {

            unit.setName(createUnitDto.getName());
        }

        if (createUnitDto.getDescription() != null &&
                !createUnitDto.getDescription().isEmpty()) {

            unit.setDescription(createUnitDto.getDescription());
        }

        if (createUnitDto.getDepartmentId() != null ) {

            Department department = departmentRepository.findById(createUnitDto.getDepartmentId())
                    .orElseThrow(() ->
                            new ResourceNotFound("Department not found"));

            unit.setDepartment(department);
        }

        Unit updatedUnit = unitRepository.save(unit);

        return UnitMapper.mapToUnitDto(updatedUnit);
    }

    @Override
    public UnitDto deleteUnitById(Long unitId) {
        Unit unit = unitRepository.findById(unitId)
                .orElseThrow(() -> new ResourceNotFound("Unit with id " + unitId + " does not exist"));

        unitRepository.deleteById(unitId);

        return UnitMapper.mapToUnitDto(unit);
    }
}
