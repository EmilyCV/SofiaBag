package fiap.com.br.SofiaBag.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserObjectAlreadyExistsExeception extends RuntimeException {

    public UserObjectAlreadyExistsExeception(String cdRfid, String userId) {
        super("User with ID " + userId + " already has object with rfid " + cdRfid + " registrated");
    }
}
