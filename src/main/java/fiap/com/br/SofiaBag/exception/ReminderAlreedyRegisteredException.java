package fiap.com.br.SofiaBag.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ReminderAlreedyRegisteredException extends Exception {
	 public ReminderAlreedyRegisteredException(String id, String nmReminder) {
		 super(String.format(nmReminder +" with id %s already registered in the system.", id));   
	 }
}
