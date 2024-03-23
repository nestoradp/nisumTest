package com.nisum.test.security.application.interfaces;

import com.nisum.test.security.application.dto.UserBasicDTO;
import com.nisum.test.security.application.dto.UserDTO;
import com.nisum.test.security.domain.exception.UserAlreadyExistsException;

public interface IUserService {
    public UserBasicDTO createUser(UserDTO userDTO) throws UserAlreadyExistsException;

    public boolean isValidIdentificationPattern(String password);

}
