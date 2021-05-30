package com.example.ogrBackend.service;

import com.example.ogrBackend.dto.UserCreateDTO;
import com.example.ogrBackend.dto.UserUpdateDTO;
import com.example.ogrBackend.dto.UserViewDTO;
import com.example.ogrBackend.model.User;
import com.example.ogrBackend.repository.UserRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public UserViewDTO getUserById(long id) throws NotFoundException {
        final User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("id Not Found"));
        return UserViewDTO.of(user);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<UserViewDTO> getUsers() {
        return userRepository.findAll().stream().map(UserViewDTO::of).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<UserViewDTO> slice(Pageable pageable){
        return userRepository.findAll(pageable).stream().map(UserViewDTO::of).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserViewDTO createUser(UserCreateDTO userCreateDTO) {
        final User user = userRepository.save(new User(userCreateDTO.getUserName(), userCreateDTO.getFirstName(), userCreateDTO.getLastName()));

        return UserViewDTO.of(user);
    }

    @Override
    @Transactional
    public UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO) throws NotFoundException {
        final User user = userRepository.findById(id).orElseThrow(()-> new NotFoundException("id Not Found"));
        user.setFirstname(userUpdateDTO.getFirstName());
        user.setLastname((userUpdateDTO.getLastName()));

        final User updatedUser = userRepository.save(user);
        return UserViewDTO.of(updatedUser);
    }

    @Override
    @Transactional
    public UserViewDTO deleteUser(Long id) throws NotFoundException {
        final User user = userRepository.findById(id).orElseThrow(()-> new NotFoundException("id Not Found"));
        userRepository.deleteById(user.getId());
        return null;
    }
}
