package fiap.com.br.SofiaBag.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

import fiap.com.br.SofiaBag.utils.RepeatType;

import fiap.com.br.SofiaBag.entity.Object;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReminderDTO {

    @NotEmpty
    private String id;

    @NotEmpty
    private String reminderDate; 

    @NotEmpty
    private String reminderHour;

    @NotEmpty
    private RepeatType repeatType;
    
    @NotEmpty
    private Object object;

}
