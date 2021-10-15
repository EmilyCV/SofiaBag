package fiap.com.br.SofiaBag.mapper;

import fiap.com.br.SofiaBag.dto.request.ObjectDTO;
import fiap.com.br.SofiaBag.entity.Object;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ObjectMapper {

    ObjectMapper INSTANCE = Mappers.getMapper(ObjectMapper.class);

    Object toModel(ObjectDTO objectDTO);

    ObjectDTO toDTO(Object object);
}
