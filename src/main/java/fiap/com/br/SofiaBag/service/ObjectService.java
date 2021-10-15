package fiap.com.br.SofiaBag.service;

import fiap.com.br.SofiaBag.dto.request.ObjectDTO;
import fiap.com.br.SofiaBag.dto.response.MessageResponseDTO;
import fiap.com.br.SofiaBag.entity.Object;
import fiap.com.br.SofiaBag.exception.UserObjectAlreadyExistsExeception;
import fiap.com.br.SofiaBag.exception.UserObjectNotFoundException;
import fiap.com.br.SofiaBag.mapper.ObjectMapper;
import fiap.com.br.SofiaBag.repository.ObjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__( @Autowired ))
public class ObjectService {

    private ObjectRepository objectRepository;

    private final ObjectMapper objectMapper = ObjectMapper.INSTANCE;

    public MessageResponseDTO createObject(ObjectDTO objectDTO) {
        Object objetToSave = objectMapper.toModel(objectDTO);

        String userId = objetToSave.getUser().getId();
		String cdRfid = objetToSave.getCdRfid();

		Optional<Object> object = objectRepository.findObjectByUserIdAndCdRfid(userId, cdRfid);

		if (object.isPresent()) {
			throw new UserObjectAlreadyExistsExeception(cdRfid, userId);
		}

        Object savedObject = objectRepository.save(objetToSave);

        return createMessageResponse(savedObject, "create");
    }

    public List<ObjectDTO> getUserObjects(String userId) {
		List<Object> allUserObjects = objectRepository.findObjectByUserId(userId);

		return allUserObjects.stream()
				.map(objectMapper::toDTO)
				.collect(Collectors.toList());
	}

	public MessageResponseDTO deleteUserObject(String userId, String cdRfid) {
		Object objectToDelete = verifyIfUserObjectExists(userId, cdRfid);
		objectRepository.delete(objectToDelete);
		return createMessageResponse(objectToDelete, "delete");
	}

	public MessageResponseDTO updateUserObject(ObjectDTO objectDTO) throws UserObjectNotFoundException {
		String userId = objectDTO.getUser().getId();
		String cdRfid = objectDTO.getCdRfid();

		verifyIfUserObjectExists(userId, cdRfid);

		Object objectToUpdate = objectMapper.toModel(objectDTO);
		objectRepository.save(objectToUpdate);

		return createMessageResponse(objectToUpdate, "update");
	}

//	public List<BackpackDTO> getUserObjectsFromADate(String userId, String date) throws ParseException {
//		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
//		Date reminder = format.parse(date);
//
//		List<Object> objectsFromAReminderDate = objectRepository.findObjectByUserIdAndReminder(userId, reminder)
//				.orElseThrow(() -> new UserObjectNotFoundException(userId));
//
//    	return objectsFromAReminderDate.stream()
//				.map(objectMapper::toDTO)
//				.collect(Collectors.toList());
//	}



	private Object verifyIfUserObjectExists(String userId, String cdRfid) throws UserObjectNotFoundException {
		return objectRepository.findObjectByUserIdAndCdRfid(userId, cdRfid)
				.orElseThrow(() -> new UserObjectNotFoundException(cdRfid));
	}

    private MessageResponseDTO createMessageResponse(Object savedObject, String messageFor) {
	    if (messageFor.startsWith("create")) {
	        return MessageResponseDTO.builder()
	                .message("Object " + savedObject.getName() + " created with ID " + savedObject.getCdRfid()).build();
	
	    } else if (messageFor.startsWith("up")) {
	        return MessageResponseDTO.builder()
	                .message("Object " + savedObject.getName() + " updeted with ID " + savedObject.getCdRfid()).build();
	
	    } else {
			return MessageResponseDTO.builder()
					.message("Object " + savedObject.getName() + " deleted with ID " + savedObject.getCdRfid()).build();
		}
    }
}
