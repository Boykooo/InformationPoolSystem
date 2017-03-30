package services;

import Entities.IBaseEntity;
import dto.IBaseDto;

public interface IConverter<Entity extends IBaseEntity, Dto extends IBaseDto> {
    Entity convertToEntity(Dto dto);
    Dto convertToDto(Entity entity);
}
