package fiap.com.br.SofiaBag.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ReminderNotFoundException extends Exception {
	 public ReminderNotFoundException(String id, String operation) {
		 super(String.format(operation + " with id %s not found in the system.", id));
	 }
}
