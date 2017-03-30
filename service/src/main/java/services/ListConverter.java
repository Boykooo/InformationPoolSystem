package services;

import Entities.IBaseEntity;
import dto.IBaseDto;

import java.util.List;

public final class ListConverter {

    private ListConverter() {
    }

    public static List<IBaseDto> ConvertToDto(List<? extends IBaseEntity> entitiesList, List<IBaseDto> dtoList, IConverter converter){
        entitiesList.forEach(
                (IBaseEntity entity) -> dtoList.add(converter.convertToDto(entity))
        );

        return dtoList;
    }

    public static List<IBaseEntity> ConvertToEntity(List<IBaseDto> dtoList, List<IBaseEntity> entitiesList, IConverter converter){
        dtoList.forEach(
                (IBaseDto dto) -> entitiesList.add(converter.convertToEntity(dto))
        );

        return entitiesList;
    }
}
