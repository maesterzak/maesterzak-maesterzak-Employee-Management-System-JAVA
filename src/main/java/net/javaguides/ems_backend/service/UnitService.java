package net.javaguides.ems_backend.service;

import net.javaguides.ems_backend.dto.UnitDto;

import java.util.List;

public interface UnitService {
    // create unit
    UnitDto createUnit(UnitDto unitDto);

    // Get unit by id
    UnitDto getUnitById(Long unitId);

    // Get all units
    List<UnitDto> getAllUnits();

    // update units
    UnitDto updateUnitById(Long unitId, UnitDto unitDto);

    UnitDto deleteUnitById(Long unitId);
}
