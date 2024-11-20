package com.example.backend.split_wise.dao;

import com.example.backend.split_wise.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jfr.BooleanFlag;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Builder
@Data
@RequiredArgsConstructor
@Table(name = "users")
public class UserDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String email;
    public String password;
    public String phone;

    public UserDao(Long id, String name, String email, String password, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public static UserDao fromUserDto(UserDto userDto) {
        return UserDao.builder()
                .email(userDto.email)
                .name(userDto.name)
                .phone(userDto.phone)
                .password(userDto.password)
                .build();
    }
}
