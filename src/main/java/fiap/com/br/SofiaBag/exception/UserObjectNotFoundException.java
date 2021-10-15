package fiap.com.br.SofiaBag.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserObjectNotFoundException extends RuntimeException {

    public UserObjectNotFoundException(String cdRid) {
        super("Object not found with rfid " + cdRid);
    }

}
