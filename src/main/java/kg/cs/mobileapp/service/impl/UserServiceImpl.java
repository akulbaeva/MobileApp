package kg.cs.mobileapp.service.impl;

import kg.cs.mobileapp.io.entity.UserEntity;
import kg.cs.mobileapp.io.repositories.UserRepository;
import kg.cs.mobileapp.service.UserService;
import kg.cs.mobileapp.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) {


        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        // populating required fields because they part of the UserEntity class
        userEntity.setUserId("publicUserId");

        // encrypting the user password and saving it inside UserEntity
        userEntity.setEncryptedPassword("lkjashdfjkashdflkjashdflaksjhdflaksjhdfl");

        // save new user to the database
        UserEntity storedUserDetails = userRepository.save(userEntity);

        // create return object "returnValue"
        UserDto returnValue = new UserDto();

        // copy values from storedUserDetails into the object "returnValue" of type UserDto
        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return returnValue;
    }

    @Override
    public UserDto getUser(String email) {
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(userRepository.findByEmail(email), returnValue);

        return returnValue;
    }
}

