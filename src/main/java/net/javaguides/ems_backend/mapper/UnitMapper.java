package net.javaguides.ems_backend.mapper;

import net.javaguides.ems_backend.dto.UnitDto;
import net.javaguides.ems_backend.entity.Unit;

public class UnitMapper {
    public static UnitDto mapToUnitDto(Unit unit){
        return new UnitDto(
                unit.getId(),
                unit.getName(),
                unit.getDescription()
        );
    }

    public static Unit mapToUnit(UnitDto unitDto){
        return new Unit(
                unitDto.getId(),
                unitDto.getName(),
                unitDto.getDescription()
        );
    }
}
