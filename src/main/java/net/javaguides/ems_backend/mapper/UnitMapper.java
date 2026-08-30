package net.javaguides.ems_backend.mapper;

import net.javaguides.ems_backend.dto.CreateUnitDto;
import net.javaguides.ems_backend.dto.UnitDto;
import net.javaguides.ems_backend.entity.Unit;

public class UnitMapper {
    public static UnitDto mapToUnitDto(Unit unit){
        return new UnitDto(
                unit.getId(),
                unit.getName(),
                unit.getDescription(),
                DepartmentMapper.mapToDepartmentDto(unit.getDepartment())
        );
    }

    public static Unit mapToUnit(CreateUnitDto unitDto){
        return new Unit(
                null,
                unitDto.getName(),
                unitDto.getDescription(),
                null
        );
    }
}
