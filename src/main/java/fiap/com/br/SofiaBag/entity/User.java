package fiap.com.br.SofiaBag.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "USUARIO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "id_usuario", unique = true, nullable = false)
    private String id;

    @Column(name = "nm_usuario")
    private String name;

    @Column(name = "apelido_usuario")
    private String nickname;

    @Column(name = "email_usuario")
    private String email;

    @Column(name = "senha_usuario")
    private String password;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Object> userObjects;
}
