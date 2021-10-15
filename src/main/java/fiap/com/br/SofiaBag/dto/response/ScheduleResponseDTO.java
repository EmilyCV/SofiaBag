package fiap.com.br.SofiaBag.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleResponseDTO {
    @NotEmpty
    private String name;

    @NotEmpty
    private boolean inBackPack;

    @NotEmpty
    private String cdRfid;

    @NotEmpty
    private LocalDateTime reminder;
}
