package com.nisum.test.security.application.useCase;

import com.nisum.test.security.application.dto.UserBasicDTO;
import com.nisum.test.security.application.dto.UserDTO;
import com.nisum.test.security.application.mappers.UserMapper;
import com.nisum.test.security.auth.AuthenticationService;
import com.nisum.test.security.domain.entities.User;
import com.nisum.test.security.domain.exception.UserAlreadyExistsException;
import com.nisum.test.security.domain.repository.IUserRepository;
import com.nisum.test.security.domain.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CreateUserUseCaseTest {
    @Mock
    private IUserRepository userRepository;

    @Mock
    private UserService userService;

    @Mock
    private UserMapper userMapper;

    @Mock
    private AuthenticationService authenticationService;

    @InjectMocks
    private CreateUserUseCase createUserUseCase;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createUser() throws UserAlreadyExistsException, InstantiationException, IllegalAccessException {
        String token ="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuZXN0b3JAZ21haWwuY29tIiwiZXhwIjoxNzEzNzg3NzIzLCJuYW1lIjoiTmVzdG9y" +
                "IERlbGdhZG8gIiwiaWQiOiIxOTA1ZmMzMi00M2Y2LTQ0ZjItYWFkYi1jODJiMjZjNWNkMmUiLCJlbWFpbCI6Im" +
                "5lc3RvckBnbWFpbC5jb20ifQ.taZy_4QdStVX5XTc2j3umLd_eHxstVN92uqLLQG-sRA";
        User userToCreated = new User();
        userToCreated.setEmail("ndelgado@NISUM.COM");
        userToCreated.setName("Nestor Delgado");
        userToCreated.setPassword("123456");

        UserBasicDTO userBasicDTO = new UserBasicDTO();
        userBasicDTO.setId(UUID.randomUUID());
        userBasicDTO.setToken(token);
        userBasicDTO.setCreatedAt(new Date());
        userBasicDTO.setUpdatedAt(new Date());
        userBasicDTO.setLastLogin(new Date());
        userBasicDTO.setActive(false);

        User user = new User();
        user.setId(UUID.randomUUID());
        user.setEmail("ndelgado@NISUM.COM");
        user.setName("Nestor Delgado");
        user.setPassword("123456");
        user.setActive(false);
        user.setToken(token);



        Mockito.when(userService.isValidPasswordPattern(Mockito.any())).thenReturn(true);
        Mockito.when(userMapper.convertFromDTO(Mockito.any(UserDTO.class))).thenReturn(userToCreated);
        Mockito.when(authenticationService.createToken(userToCreated)).thenReturn(token);
        Mockito.when(userMapper.convertToBasicDTO(Mockito.any(User.class))).thenReturn(userBasicDTO);
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(user);


        User createUser = createUserUseCase.createUser(userToCreated);

        assertNotNull(createUser);
        assertEquals(userToCreated.getEmail(), createUser.getEmail());
        Mockito.verify(userRepository, Mockito.times(1)).save(Mockito.any(User.class));
    }
}