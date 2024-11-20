package com.example.backend.split_wise.controller;

import com.example.backend.split_wise.dto.UserDto;
import com.example.backend.split_wise.repository.UserRepository;
import com.example.backend.split_wise.service.UserService;
import com.example.backend.split_wise.utils.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> registerUser(@RequestBody @Validated UserDto userDto) {
        UserDto createdUser = userService.saveUser(userDto);
        if (createdUser == null) {
            throw new RuntimeException("please try again");
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId())
                .toUri();
        return ResponseEntity.created(location).body(userDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto userDto = userService.findUser(id);
        if (userDto == null) {
            throw new UserNotFoundException("No such user with given Id");
        }
        return ResponseEntity.ok(userDto);
    }

}
