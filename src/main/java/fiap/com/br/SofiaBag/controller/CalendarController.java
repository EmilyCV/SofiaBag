package fiap.com.br.SofiaBag.controller;

import fiap.com.br.SofiaBag.dto.request.ReminderDTO;
import fiap.com.br.SofiaBag.dto.response.MessageResponseDTO;
import fiap.com.br.SofiaBag.exception.ReminderAlreedyRegisteredException;
import fiap.com.br.SofiaBag.exception.ReminderNotFoundException;
import fiap.com.br.SofiaBag.service.ReminderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/calendar")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CalendarController {

    private ReminderService reminderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createReminder(@RequestBody ReminderDTO reminderDTO) throws ReminderAlreedyRegisteredException, ParseException {
        return reminderService.createReminder(reminderDTO);
    }
    
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO updateReminder(@RequestBody ReminderDTO reminderDTO) throws ReminderNotFoundException {
    	return reminderService.updateReminder(reminderDTO);
    }
    
    @DeleteMapping("/{cdReminder}")
	@ResponseStatus(HttpStatus.OK)
	public MessageResponseDTO deleteUserObject(@PathVariable String cdReminder) throws ReminderNotFoundException{
 		return reminderService.deleteReminder(cdReminder);
	}

    @GetMapping("/id={userId}&date={date}")
    @ResponseStatus(HttpStatus.OK)
    public List<ReminderDTO> getUserObjectsFromADate(@PathVariable String userId, @PathVariable String date) throws ParseException {
    	System.out.println("CONTROLLER");
    	return reminderService.getUserObjectsFromADate(userId, date);
    }

}
