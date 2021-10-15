package fiap.com.br.SofiaBag.repository;

import fiap.com.br.SofiaBag.entity.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReminderRepository extends JpaRepository<Reminder, String> {
    Optional<List<Reminder>> findObjectByUserIdAndReminderDate(String userId, Date reminder);
    Optional<Reminder> findAllById(String id);

    @Query(value = "SELECT * FROM Lembrete l WHERE l.object_cd_rfid = :rfid AND l.dt_lembrete LIKE %:reminder%",  nativeQuery = true)
	Reminder findByCdRfidAndReminder(@Param("rfid")String rfid, @Param("reminder")CharSequence reminder);

	 @Query(value = "SELECT * FROM Lembrete l WHERE " +
	            "l.user_id_usuario = :idUser AND (l.repeat_type <> 1 and l.day_week = :dayWeek) OR " +
	            "(l.repeat_type = 1 and l.dt_lembrete LIKE %:reminder%)", nativeQuery = true)
	List<Reminder> findReminderDay(@Param("idUser")String idUser, @Param("dayWeek")String dayWeek, @Param("reminder")CharSequence reminder);	
}
