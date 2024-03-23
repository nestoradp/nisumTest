package com.nisum.test.security.application.useCase;
import com.nisum.test.security.auth.AuthenticationService;
import com.nisum.test.security.domain.entities.Phone;
import com.nisum.test.security.domain.entities.User;
import com.nisum.test.security.domain.exception.UserAlreadyExistsException;
import com.nisum.test.security.domain.repository.IUserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CreateUserUseCase {


    private final IUserRepository userRepository;


    private final AuthenticationService authenticationService;



    public CreateUserUseCase(IUserRepository userRepository, AuthenticationService authenticationService) {
        this.userRepository = userRepository;
        this.authenticationService = authenticationService;
    }

    public User createUser(User createdUser) throws UserAlreadyExistsException {
        checkUserEmail(createdUser.getEmail());
        this.updatePhone(createdUser.getPhones(), createdUser);
        createdUser.setToken(this.authenticationService.createToken(createdUser));
        return this.userRepository.save(createdUser);
    }



    public void updatePhone(List<Phone> phoneList, User user) {
        if(phoneList != null){
            phoneList.forEach(phone -> phone.setUser(user));
        }
    }

    private void checkUserEmail(String email) throws UserAlreadyExistsException {
        Optional<User> user= this.userRepository.findByEmail(email);
        if(user.isPresent()){
            throw new UserAlreadyExistsException("Email already exists");
        }
    }

}

