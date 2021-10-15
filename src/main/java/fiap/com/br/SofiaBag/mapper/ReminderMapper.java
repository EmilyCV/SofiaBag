package fiap.com.br.SofiaBag.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import fiap.com.br.SofiaBag.dto.request.ReminderDTO;
import fiap.com.br.SofiaBag.entity.Reminder;
import fiap.com.br.SofiaBag.utils.RepeatType;

@Mapper
public interface ReminderMapper {

    ReminderMapper INSTANCE = Mappers.getMapper(ReminderMapper.class);

    @Mapping(target = "reminderDate", source = "reminderDate", dateFormat = "yyyy-MM-dd")    	
    Reminder toModel(ReminderDTO reminderDTO);

    ReminderDTO toDTO(Reminder reminder);

}
