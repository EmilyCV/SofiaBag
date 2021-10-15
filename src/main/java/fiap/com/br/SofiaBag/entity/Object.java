package fiap.com.br.SofiaBag.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "OBJETO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Object {

    @Id
    @Column(name = "cd_rfid", unique = true)
    private String cdRfid;

    @Column(name = "nm_objeto", nullable = false)
    private String name;

    @Column(name = "cat_objeto")
    private String category;

    @Column(name = "in_backpack")
    private boolean inBackpack;

    @ManyToOne
    @JoinColumn
    private User user;

}
