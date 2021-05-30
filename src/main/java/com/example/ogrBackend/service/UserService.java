package com.example.ogrBackend.service;

import com.example.ogrBackend.dto.UserCreateDTO;
import com.example.ogrBackend.dto.UserUpdateDTO;
import com.example.ogrBackend.dto.UserViewDTO;
import javassist.NotFoundException;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    UserViewDTO getUserById(long id) throws NotFoundException;

    List<UserViewDTO> getUsers();

    List<UserViewDTO> slice(Pageable pageable);

    UserViewDTO createUser(UserCreateDTO userCreateDTO);

    UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO) throws NotFoundException;

    UserViewDTO deleteUser(Long id) throws NotFoundException;
}
