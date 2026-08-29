package net.javaguides.ems_backend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.ems_backend.dto.UnitDto;
import net.javaguides.ems_backend.entity.Unit;
import net.javaguides.ems_backend.exception.ResourceNotFound;
import net.javaguides.ems_backend.mapper.UnitMapper;
import net.javaguides.ems_backend.repository.UnitRepository;
import net.javaguides.ems_backend.service.UnitService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UnitServiceimp implements UnitService {
    private UnitRepository unitRepository;

    // create unit
    @Override
    public UnitDto createUnit(UnitDto unitDto) {

        Unit unit = UnitMapper.mapToUnit(unitDto);
        Unit saveUnit = unitRepository.save(unit);

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
    public UnitDto updateUnitById(Long unitId, UnitDto unitDto) {

        Unit unit = unitRepository.findById(unitId)
                .orElseThrow(() -> new ResourceNotFound("Unit with id " + unitId + " does not exist"));
        if (unitDto.getName() != null &&
                !unitDto.getName().isEmpty()) {

            unit.setName(unitDto.getName());
        }

        if (unitDto.getDescription() != null &&
                !unitDto.getDescription().isEmpty()) {

            unit.setDescription(unitDto.getDescription());
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
