package com.example.SpringBootWebProject.service.mapper;

import com.example.SpringBootWebProject.dto.UserDto;
import com.example.SpringBootWebProject.model.User;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userEntityToDto(User user);
    List<UserDto> userEntityListToDtoList(List<User> users);

    User userDtoToEntity(UserDto userDto);
    List<User> userDtoListToEntityList(List<UserDto> userDtos);

}
