package com.example.ogrBackend.api;

import com.example.ogrBackend.dto.UserCreateDTO;
import com.example.ogrBackend.dto.UserUpdateDTO;
import com.example.ogrBackend.dto.UserViewDTO;
import com.example.ogrBackend.service.UserService;
import com.example.ogrBackend.shared.GenericResponse;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserAPI {

    private final UserService userService;

    @GetMapping("v1/user/{id}")
    public ResponseEntity<UserViewDTO> getUserById(@PathVariable long id){
        UserViewDTO user;
        try{
            user = userService.getUserById(id);
            return ResponseEntity.ok(user);
        }catch (NotFoundException e){
            e.printStackTrace();
            System.out.println("User ID not found!!");
            return (ResponseEntity<UserViewDTO>) ResponseEntity.badRequest();
        }
    }

    @GetMapping("v1/user")
    public ResponseEntity<List<UserViewDTO>> getUsers(){
        final List<UserViewDTO> usersBody = userService.getUsers();
        return ResponseEntity.ok(usersBody);
    }

    @GetMapping("v1/user/slice")
    public ResponseEntity<List<UserViewDTO>> slice(Pageable pageable){
        final List<UserViewDTO> users = userService.slice(pageable);
        return ResponseEntity.ok(users);
    }

    @PostMapping("v1/user")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserCreateDTO userCreateDTO){
        userService.createUser(userCreateDTO);
        return ResponseEntity.ok(new GenericResponse("User Created").getMessage());
    }

    @PutMapping("v1/user/{id}")
    public ResponseEntity<UserViewDTO> updateUser(@PathVariable("id") Long id, @RequestBody UserUpdateDTO userUpdateDTO){
        UserViewDTO user = null;
        try{
            user = userService.updateUser(id, userUpdateDTO);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("v1/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) throws NotFoundException {
        userService.deleteUser(id);
        return ResponseEntity.ok(new GenericResponse("Deleted " + id));
    }
}
