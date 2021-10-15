package fiap.com.br.SofiaBag.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import fiap.com.br.SofiaBag.dto.request.ReminderDTO;
import fiap.com.br.SofiaBag.entity.Reminder;
import fiap.com.br.SofiaBag.exception.ReminderAlreedyRegisteredException;
import fiap.com.br.SofiaBag.exception.ReminderNotFoundException;
import fiap.com.br.SofiaBag.repository.ReminderRepository;

public class ReminderValidation {

	public static Reminder FormatObject(Reminder reminder, ReminderDTO reminderDTO) {
		//set the day of the week 	
		String weekDay = new SimpleDateFormat("EEEE").format(reminder.getReminderDate());
		reminder.setDayOfWeek(weekDay);		
		
		return reminder;
	}
	
	
	public static void verifyIfIsAlreadyRegistered(ReminderRepository repoObj, String objCdRfid, String dtReminder) throws ReminderAlreedyRegisteredException, ParseException {	
		Date dt = new SimpleDateFormat("yyyy-MM-dd").parse(dtReminder);	
		StringBuilder str = new StringBuilder(dt.toLocaleString());
		CharSequence sequence = str.delete(6, 8).subSequence(0, 8);	
		System.out.println(objCdRfid);
		
		Reminder reminder = repoObj.findByCdRfidAndReminder(objCdRfid, sequence);
		
		if (reminder != null) {			
			throw new ReminderAlreedyRegisteredException(objCdRfid, "Reminder");
		}
	}
	
	public static Reminder verifyIfExists(ReminderRepository repoObj, String id) throws ReminderNotFoundException{
		return repoObj.findById(id).orElseThrow(() -> new ReminderNotFoundException(id, "Reminder"));
	}
}
