package com.nisum.test.security.domain.services;


import com.nisum.test.common.config.NisumConfiguration;
import com.nisum.test.common.util.RegexUtil;
import com.nisum.test.security.application.dto.UserBasicDTO;
import com.nisum.test.security.application.dto.UserDTO;
import com.nisum.test.security.application.interfaces.IUserService;
import com.nisum.test.security.application.mappers.UserMapper;
import com.nisum.test.security.application.useCase.CreateUserUseCase;
import com.nisum.test.security.domain.entities.User;
import com.nisum.test.security.domain.exception.UserAlreadyExistsException;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class UserService implements IUserService {


    private final CreateUserUseCase createUserUseCase;


    private final UserMapper userMapper;

    private final NisumConfiguration nisumConfiguration;


    public UserService(CreateUserUseCase createUserUseCase, UserMapper userMapper, NisumConfiguration nisumConfiguration) {
        this.createUserUseCase = createUserUseCase;
        this.userMapper = userMapper;
        this.nisumConfiguration = nisumConfiguration;
    }

    @Transactional
    public UserBasicDTO createUser(UserDTO userDTO) throws UserAlreadyExistsException {
        if (!isValidIdentificationPattern(userDTO.getPassword())) {
            throw new IllegalArgumentException("Invalid Password");
        }

            User createdUser = this.userMapper.convertFromDTO(userDTO);
            User newUser= createUserUseCase.createUser(createdUser);
            return this.userMapper.convertToBasicDTO(newUser);

    }

    public boolean isValidIdentificationPattern(String password){
        String regex = nisumConfiguration.getPasswordRegex();
        return RegexUtil.validateRegex(password, regex);

    }


}
