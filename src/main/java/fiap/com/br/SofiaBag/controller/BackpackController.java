package fiap.com.br.SofiaBag.controller;

import fiap.com.br.SofiaBag.dto.request.ObjectDTO;
import fiap.com.br.SofiaBag.dto.response.MessageResponseDTO;
import fiap.com.br.SofiaBag.service.ObjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/backpack")
@AllArgsConstructor(onConstructor = @__( @Autowired ))
public class BackpackController {

    private ObjectService objectService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createObject(@RequestBody @Valid ObjectDTO objectDTO) {
    	return objectService.createObject(objectDTO);
    }

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<ObjectDTO> getUserObject(@PathVariable String id) {
 		return objectService.getUserObjects(id);
	}

	@DeleteMapping("/userId={userId}&objectId={cdRfid}")
	@ResponseStatus(HttpStatus.OK)
	public MessageResponseDTO deleteUserObject(@PathVariable String userId, @PathVariable String cdRfid) {
 		return objectService.deleteUserObject(userId, cdRfid);
	}

	@PutMapping("/userId={userId}&objectId={cdRfid}")
	@ResponseStatus(HttpStatus.OK)
	public MessageResponseDTO updateUserObject(@RequestBody @Valid ObjectDTO objectDTO) {
    	return objectService.updateUserObject(objectDTO);
	}

}
