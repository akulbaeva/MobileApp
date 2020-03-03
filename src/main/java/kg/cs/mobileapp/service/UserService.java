package kg.cs.mobileapp.service;

import kg.cs.mobileapp.shared.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUser(String email);
}

