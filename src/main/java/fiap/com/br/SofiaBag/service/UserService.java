package fiap.com.br.SofiaBag.service;

import fiap.com.br.SofiaBag.dto.request.UserDTO;
import fiap.com.br.SofiaBag.dto.response.MessageResponseDTO;
import fiap.com.br.SofiaBag.entity.User;
import fiap.com.br.SofiaBag.mapper.UserMapper;
import fiap.com.br.SofiaBag.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__( @Autowired ))
public class UserService {

    private UserRepository userRepository;

    private final UserMapper userMapper = UserMapper.INSTANCE;

    public MessageResponseDTO createUser(UserDTO userDTO) {
        User userToSave = userMapper.toModel(userDTO);
        User savedUser = userRepository.save(userToSave);
        return createMessageResponse(savedUser);
    }

    public Optional<UserDTO> getUser(String id) {
        Optional<User> userFound = userRepository.findById(id);
        if (userFound.isPresent()) {
            return userFound.map(userMapper::toDTO);
        }
        return null; // throws exception to handle it?
    }

    public List<UserDTO> listAll() {
        List<User> allUsers = userRepository.findAll();
        return allUsers.stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    private MessageResponseDTO createMessageResponse( User savedUser ) {
        return MessageResponseDTO
                .builder()
                .message("User " + savedUser.getName() + " created with ID " + savedUser.getId())
                .build();
    }
}
