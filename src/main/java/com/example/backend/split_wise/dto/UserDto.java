package com.example.backend.split_wise.dto;

import com.example.backend.split_wise.dao.UserDao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    @JsonIgnore
    public Long id;
    @NotNull
    public String name;
    @NotNull
    public String email;
    @NotNull
    public String password;
    @NotNull
    public String phone;

    public static UserDto fromUserDao(UserDao userDao) {
        return UserDto.builder()
                .email(userDao.getEmail())
                .name(userDao.getName())
                .phone(userDao.getPhone())
                .build();
    }
}
