package fiap.com.br.SofiaBag.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CalendarResponseDTO {

    @NotEmpty
    private String cdRfid;

    @NotEmpty
    private String name;

    @NotEmpty
    private LocalDateTime reminder;
}
