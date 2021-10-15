package fiap.com.br.SofiaBag.entity;

import fiap.com.br.SofiaBag.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import fiap.com.br.SofiaBag.utils.RepeatType;

import java.sql.Timestamp;
import java.util.Date;

@Entity(name = "LEMBRETE")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reminder {

    @Id
    @Column(name = "reminder_id", unique = true)
    private String id;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_lembrete", nullable = false)
    private Date reminderDate;

    @Column(name = "hr_lembrete", nullable = false)
    private String reminderHour;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "repeat_type", nullable = false)
    private RepeatType repeatType;
    
    @Column(name = "day_week", nullable = false)
    private String dayOfWeek;
    
    @ManyToOne
    @JoinColumn
    private Object object;

    @ManyToOne
    @JoinColumn
    private User user;
}
