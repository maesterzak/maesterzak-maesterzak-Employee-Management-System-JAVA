package net.javaguides.ems_backend.service;

import net.javaguides.ems_backend.dto.CreateUnitDto;
import net.javaguides.ems_backend.dto.UnitDto;
import net.javaguides.ems_backend.entity.Unit;

import java.util.List;

public interface UnitService {


    // create unit
    UnitDto createUnit(CreateUnitDto createUnitDto);

    // Get unit by id
    UnitDto getUnitById(Long unitId);

    // Get all units
    List<UnitDto> getAllUnits();

    // update units
    UnitDto updateUnitById(Long unitId, CreateUnitDto createUnitDto);

    UnitDto deleteUnitById(Long unitId);
}
