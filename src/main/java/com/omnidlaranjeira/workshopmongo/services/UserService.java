package com.omnidlaranjeira.workshopmongo.services;

import com.omnidlaranjeira.workshopmongo.domain.User;
import com.omnidlaranjeira.workshopmongo.dto.UserDTO;
import com.omnidlaranjeira.workshopmongo.repository.UserRepository;
import com.omnidlaranjeira.workshopmongo.services.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> userId = userRepository.findById(id);
        return userId.orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
    }

    public User insert(User user) {
        return userRepository.insert(user);
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
