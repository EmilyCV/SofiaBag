package fiap.com.br.SofiaBag.dto.request;

import fiap.com.br.SofiaBag.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ObjectDTO {

    @NotEmpty
    private String cdRfid;

    @NotEmpty
    private String name;

    private String category;

    @NotEmpty
    private User user;
}
